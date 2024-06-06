package org.example.service;

import org.example.Models.Reminder;
import org.example.exception.RecordNotFoundException;
import org.example.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Reminder createOrUpdateReminder(Reminder reminder) {
        Reminder result;
        if (reminder.getId() != 0) {
            Optional<Reminder> resultOptional = reminderRepository.findById(reminder.getId());
            if (resultOptional.isPresent()) {
                Reminder fromDB = resultOptional.get();
                fromDB.setDescription(reminder.getDescription());
                fromDB.setDate(reminder.getDate());
                //fromDB.setApartment(reminder.getApartment());
                if (reminder.getApartment() != null) {
                    fromDB.setApartment(reminder.getApartment());
                }
                result = reminderRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No reminder found with id: " + reminder.getId());
            }
        } else {  //insert
            result = reminderRepository.save(reminder);
        }
        return result;
    }


    public void deleteReminder(int id) {
        Optional<Reminder> resultOptional = reminderRepository.findById(id);
        if (resultOptional.isPresent()) {
            reminderRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No reminder found with id: " + id);
        }
    }


    public List<Reminder> getRemindersByApartmentId(int id) {
        return reminderRepository.getRemindersByApartmentId(id);
    }
}
