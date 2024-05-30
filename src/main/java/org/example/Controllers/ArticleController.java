package org.example.Controllers;

import org.example.Models.Article;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Article>> getArticlesByApartmentId(@PathVariable("id") int id) {
        List<Article> Articles = articleService.getArticlesByApartmentId(id);
        return ResponseEntity.ok(Articles);
    }

    @PostMapping
    public Article createOrUpdateArticle(@RequestBody Article article) {
        return articleService.createOrUpdateArticle(article);
    }

}
