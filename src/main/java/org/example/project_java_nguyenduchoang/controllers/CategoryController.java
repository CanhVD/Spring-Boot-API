package org.example.project_java_nguyenduchoang.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.project_java_nguyenduchoang.dtos.CategoryDTO;
import org.example.project_java_nguyenduchoang.models.Category;
import org.example.project_java_nguyenduchoang.reponses.category.CategoryResponse;
import org.example.project_java_nguyenduchoang.services.category.CategoryService;
import org.example.project_java_nguyenduchoang.services.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        Category category = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(
                CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build(),
                HttpStatus.CREATED
        );
    }
}
