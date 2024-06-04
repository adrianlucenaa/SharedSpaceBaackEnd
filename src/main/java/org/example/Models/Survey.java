/*

package org.example.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "survey")
public class Survey {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "options")
    private String options;


    @Column(name = "solution")
    private String solution;


    //@ManyToOne(optional = true, fetch = FetchType.EAGER, cascade =  {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_apartment")
    @JsonIgnoreProperties("apartment")
    //@JsonIgnoreProperties("survey")
    //@JsonIgnoreProperties({"users","tasks"})
    private Apartment apartment;

    public Survey() {
    }

    public Survey(int id, String description, String options, String solution, Apartment apartment) {
        this.id = id;
        this.description = description;
        this.options = options;
        this.solution = solution;
        this.apartment = apartment;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }


    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", options='" + options + '\'' +
                ", solution='" + solution + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}

 */