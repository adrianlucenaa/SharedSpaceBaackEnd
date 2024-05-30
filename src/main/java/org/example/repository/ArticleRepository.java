package org.example.repository;

import org.example.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query(value = "SELECT * FROM article WHERE id_apartment = ?1", nativeQuery = true)
    List<Article> getArticlesByApartmentId(int id);
}
