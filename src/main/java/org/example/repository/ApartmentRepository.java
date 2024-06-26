package org.example.repository;
import org.example.Models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    @Query(value = "SELECT a.* FROM apartment a JOIN tasks t ON a.id = t.id_apartment WHERE t.completed = false", nativeQuery = true)
    List<Apartment> getApartmentsUncompleted();


    //Devuelve los apartamentos por nombre de apartamento
    @Query(value = "SELECT * FROM apartment a WHERE a.name=?1", nativeQuery = true)
    List<Apartment> getApartmentsByName(String name);

    //Devuelve todos los apatmentos por tarea id
    @Query(value = "SELECT a.* FROM apartment a JOIN tasks t ON a.id = t.apartment_id WHERE t.id = ?1", nativeQuery = true)
    List<Apartment> getApartmentsByTask(int id);
}
