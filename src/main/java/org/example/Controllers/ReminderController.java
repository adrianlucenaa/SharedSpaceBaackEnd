package org.example.Controllers;


import org.example.Models.Reminder;
import org.example.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {


    @Autowired
    ReminderService service;


    @GetMapping
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = service.getAllReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Reminder>> getRemindersByApartmentId(@PathVariable("id") int id) {
        List<Reminder> reminders = service.getRemindersByApartmentId(id);
        return ResponseEntity.ok(reminders);
    }

    @PostMapping
    public ResponseEntity <Reminder> createOrUpdateReminder(Reminder reminder) {
        Reminder end = service.createOrUpdateReminder(reminder);
        return ResponseEntity.ok(end);
    }

    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable("id") int id) {
        service.deleteReminder(id);
    }
}


