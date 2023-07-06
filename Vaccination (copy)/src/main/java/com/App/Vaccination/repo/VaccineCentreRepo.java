package com.App.Vaccination.repo;

import com.App.Vaccination.model.VaccineCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineCentreRepo extends JpaRepository<VaccineCentre, Integer> {
}
