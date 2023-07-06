package com.App.Vaccination.controller;

import com.App.Vaccination.model.Slots;
import com.App.Vaccination.model.User;
import com.App.Vaccination.model.VaccineCentre;
import com.App.Vaccination.repo.SlotsRepo;
import com.App.Vaccination.repo.VaccineCentreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/slot")
public class SlotsController {

    @Autowired
    private SlotsRepo slotsRepo;

    @Autowired
    private VaccineCentreRepo vaccineCentreRepo;

    @GetMapping("/availableSlots")
    public ResponseEntity getAvailableSlots() {
        List< VaccineCentre> centres = vaccineCentreRepo.findAll();
        List<VaccineCentre> availableCentres = new ArrayList<>();
        for(VaccineCentre centre : centres) {
            int slotsBooked = slotsRepo.findBookedSlotsByDate(new Date());
            if(slotsBooked < 10)
                availableCentres.add(centre);
        }
        return ResponseEntity.ok(availableCentres);
    }

    @PostMapping("/getByUserId")
    public ResponseEntity getByUserId(@RequestBody User user) {
        List<Slots> slotsList = slotsRepo.findByUserId(user.getUserId());
        return ResponseEntity.ok(slotsList);
    }

    @PostMapping("/add")
    public ResponseEntity addSlot(@RequestBody Slots slot) {
        if(slot.getCentreId() == null)
            return ResponseEntity.badRequest().body("No Centre Id");
        int centreId = slot.getCentreId();
        int slotsBooked = slotsRepo.findBookedSlotsByDate(new Date());

        if(slotsBooked >= 10)
            return ResponseEntity.badRequest().body("All slots booked");

        slot.setDate(new Date());
        slot.setBooked(true);
        slotsRepo.save(slot);
        return ResponseEntity.ok("Slot booked successfully");
    }

}
