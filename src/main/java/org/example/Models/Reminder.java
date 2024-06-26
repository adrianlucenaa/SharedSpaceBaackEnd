package org.example.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8100")
@Entity
@Table(name = "reminder")
public class Reminder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;



    @Column(name = "date")
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date date;
    //@ManyToOne(optional = true, fetch = FetchType.EAGER, cascade =  {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_apartment")
    @JsonIgnoreProperties({"users","tasks","reminder"})
    private Apartment apartment;

    public Reminder() {
    }



    public Reminder(int id, String description, Date date, Apartment apartment) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.apartment = apartment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //@JsonIgnore
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", description=" + description + '\'' +
                ", date=" + date +
                ", apartment=" + apartment +
                '}';
    }
}
