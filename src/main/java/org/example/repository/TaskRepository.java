package org.example.repository;

import org.example.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    //Devuelve las tareas por apartamento
    @Query(value = "SELECT * FROM tasks t WHERE t.id_apartment = ?1", nativeQuery = true)
    List<Task> getTasksByApartmentId(int id);

    //Devuelve las tareas por usuario
    @Query(value = "SELECT * FROM tasks t WHERE t.id_user = ?1", nativeQuery = true)
    List<Task> getTasksByUserId(int id);

    //Devuelve las tareas por apartamento y usuario
    @Query(value = "SELECT * FROM tasks t WHERE t.id_apartment = ?1 AND t.id_user = ?2", nativeQuery = true)
    List<Task> getTasksByApartmentIdAndUserId(int id1, int id2);

    //Devuelve las tareas por nombre de usuario
    @Query(value = "SELECT * FROM tasks t WHERE t.user_name = ?1", nativeQuery = true)
    List<Task> getTasksByUserName(String name);

}