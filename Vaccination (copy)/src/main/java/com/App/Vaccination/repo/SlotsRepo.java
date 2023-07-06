package com.App.Vaccination.repo;

import com.App.Vaccination.model.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SlotsRepo extends JpaRepository<Slots, Integer> {

    @Query(
            value = "select count(*) from slots where date = :date",
            nativeQuery = true
    )
    public Integer findBookedSlotsByDate(Date date);

    @Query(
            value = "select * from slots where user_id = :userId",
            nativeQuery = true
    )
    public List<Slots> findByUserId(Integer userId);

}
