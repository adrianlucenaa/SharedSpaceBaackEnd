package org.example.Controllers;

import org.example.Models.Survey;
import org.example.Models.User;
import org.example.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {


     @Autowired
     SurveyService service;


    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = service.getAllSurveys();
        return ResponseEntity.ok(surveys);
    }

    @GetMapping("/apartment/{id}")
    public ResponseEntity<List<Survey>> getSurveysByApartmentId(@PathVariable("id") int id) {
        List<Survey> surveys = service.getSurveyByApartmentId(id);
        return ResponseEntity.ok(surveys);
    }

    //Crea o actualiza un usuario
    @PostMapping
    public ResponseEntity<Survey> CreateSurvey(@RequestBody Survey survey){
        Survey end = service.createSurvey(survey);
        return ResponseEntity.ok(end);
    }

    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable("id") int id) {
        service.deleteSurvey(id);
    }

}
