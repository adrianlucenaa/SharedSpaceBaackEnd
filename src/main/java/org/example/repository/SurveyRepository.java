
/*


package org.example.repository;

import org.example.Models.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    //Devuelve las encuesta por Apartmento
    @Query(value = "SELECT * FROM survey WHERE id_apartment = ?1", nativeQuery = true)
    List<Survey> getSurveyByApartmentId(int id);
}
*/