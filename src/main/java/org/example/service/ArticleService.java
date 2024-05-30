package org.example.service;


import org.example.Models.Article;
import org.example.exception.RecordNotFoundException;
import org.example.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticlesByApartmentId(int id) {
        return articleRepository.getArticlesByApartmentId(id);
    }

    public  Article createOrUpdateArticle(Article article) {
        Article result;
        if (article.getId() != 0) {
            Optional<Article> articleOptional = articleRepository.findById(article.getId());
            if (articleOptional.isPresent()) {      //Update
                Article fromDB = articleOptional.get();
                fromDB.setArticle(article.getArticle());
                result = articleRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No article found with id: " + article.getId());
            }
        } else {
            result = articleRepository.save(article);
        }
        return result;
    }

}
