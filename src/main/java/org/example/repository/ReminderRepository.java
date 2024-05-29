package org.example.repository;

import org.example.Models.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Integer> {

    //Devuevuele los recordatios creados , por apartment id
    @Query(value = "SELECT * FROM reminder r WHERE r.id_apartment = ?1", nativeQuery = true)
    List<Reminder> getRemindersByApartmentId(int id);

}
