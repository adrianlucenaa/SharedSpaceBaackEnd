package org.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "article")
    private String article;

    //private List<BuyList> buyList;


    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_apartment")
    @JsonIgnoreProperties("apartment")
    private Apartment apartment;


    public Article() {
    }

    public Article(int id, String article, int apartmentId) {
        this.id = id;
        this.article = article;
        this.apartment.setId(apartmentId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
/*
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
*/
    public void setApartmentId(int apartmentId) {
        this.apartment = new Apartment();
        this.apartment.setId(apartmentId);
    }

    public int getApartmentId() {
        this.apartment.getId();
        return apartment.getId();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", article='" + article + '\'' +
                ", apartmentId=" + apartment.getId() +
                '}';
    }
}
