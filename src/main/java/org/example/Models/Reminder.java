package org.example.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;


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
    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_apartment")
    @JsonIgnoreProperties("apartment")
    private Apartment apartment;

    public Reminder() {
    }

    public Reminder(String description, Date date, int apartmentId) {
        this.description = description;
        this.date = date;
        this.apartment.setId(apartmentId);
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

    public int getApartmentId() {
        this.apartment.getId();
        return apartment.getId();
    }

    public int setApartmentId(int apartmentId) {
        this.apartment = new Apartment();
        this.apartment.setId(apartmentId);
        return apartment.getId();
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", apartmentId=" + apartment +
                '}';
    }
}
