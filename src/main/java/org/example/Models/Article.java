package org.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "article")
    private String article;

    //@ManyToOne(optional = true, fetch = FetchType.EAGER, cascade =  {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_apartment")
    @JsonIgnoreProperties({"users","tasks","article"})
    private Apartment apartment;


    public Article() {
    }

    public Article(int id, String article, Apartment apartment) {
        this.id = id;
        this.article = article;
        this.apartment = apartment;
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


    //@JsonIgnore
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }



    @Override
    public String toString() {
        return "Article{" +
                "id='" + id +
                ", article='" + article + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}
