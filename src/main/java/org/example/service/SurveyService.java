


/*
package org.example.service;


import org.example.Models.Survey;
import org.example.exception.RecordNotFoundException;
import org.example.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public List<Survey> getSurveyByApartmentId(int id) {
        return surveyRepository.getSurveyByApartmentId(id);
    }

    public void deleteSurvey(int id) {
        Optional<Survey> surveyOptional = surveyRepository.findById(id); // Usar la instancia inyectada
        if (surveyOptional.isPresent()) {
            surveyRepository.deleteById(id);
        } else {
            System.out.println("No se encontró la encuesta");
        }
    }



    //Logica para crear o actualizar una tarea
    public Survey createSurvey(Survey survey) {
        Survey result;
        System.out.println(survey);
        if (survey.getId() != 0) {
            Optional<Survey> resultOptional = surveyRepository.findById(survey.getId());
            if (resultOptional.isPresent()) {
                //Imprimir por pantalla el survey
                System.out.println(survey);
                Survey fromDB = resultOptional.get();
                fromDB.setDescription(survey.getDescription());
                fromDB.setOptions(survey.getOptions());
                fromDB.setSolution(survey.getSolution());
                if(survey.getApartment()!=null){
                    fromDB.setApartment(survey.getApartment());
                }
                result = surveyRepository.save(fromDB);
                return result;
            } else {
                throw new RecordNotFoundException("No task found with id: " + survey.getId());
            }
        } else {  //insert
            result = surveyRepository.save(survey);
        }
        return result;
    }

}

*/

