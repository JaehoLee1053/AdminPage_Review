package com.example.study_review.repository;

import com.example.study_review.StudyReviewApplicationTests;
import com.example.study_review.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class CategoryRepositoryTest extends StudyReviewApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {

        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminSever";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read() {

        String type = "COMPUTER";

        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        // select * from category where type = "COMPUTER"


        optionalCategory.ifPresent(c -> {

            Assertions.assertEquals(c.getType(), type);

            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });

    }

}