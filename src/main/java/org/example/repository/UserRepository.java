package org.example.repository;

import org.example.Models.Apartment;
import org.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //devuelve paginado 10 usuarios por cada page
    @Query(value = "SELECT * FROM users LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<User> findAllByPage(int page);
    //Devuelve los usuarios por apartamentoID
    @Query(value = "SELECT * FROM users u WHERE u.id_apartment = ?1", nativeQuery = true)
    List<User> getUsersByApartmentId(int id);

    //Devuelve los usuarios por tarea id
    @Query(value = "SELECT u.* FROM users u JOIN tasks t ON u.id = t.user_id WHERE t.id = ?1", nativeQuery = true)
    List<User> getUsersByTaskId(int id);

    // Método para buscar un usuario por nombre de usuario o correo electrónico
    @Query(value = "SELECT * FROM users u WHERE u.name = ?1 OR u.email = ?1", nativeQuery = true)
    User findByUsernameOrEmail(String usernameOrEmail);

    //Devuelve los usuarios por nombre de usuario
    @Query(value = "SELECT * FROM users u WHERE u.name = ?1", nativeQuery = true)
    List<User> getUsersByName(String name);

    //Devuelve los usuarios por nombre de apartamento
    @Query(value = "SELECT * FROM users u WHERE u.apartment_name = ?1", nativeQuery = true)
    List<User> getUsersByApartmentName(String name);


    //Devuelve los usuarios que no tienen tareas completadas
    @Query(value = "SELECT * FROM users u WHERE u.id NOT IN (SELECT t.user_id FROM tasks t WHERE t.completed = true)", nativeQuery = true)
    List<User> getUsersTaskUncompleted();
}