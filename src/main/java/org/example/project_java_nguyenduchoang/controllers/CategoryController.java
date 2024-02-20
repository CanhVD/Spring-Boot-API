package org.example.project_java_nguyenduchoang.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.project_java_nguyenduchoang.components.LocalizationUtils;
import org.example.project_java_nguyenduchoang.dtos.CategoryDTO;
import org.example.project_java_nguyenduchoang.models.Category;
import org.example.project_java_nguyenduchoang.reponses.category.CategoryResponse;
import org.example.project_java_nguyenduchoang.reponses.category.ResponseObject;
import org.example.project_java_nguyenduchoang.services.category.CategoryService;
import org.example.project_java_nguyenduchoang.services.category.ICategoryService;
import org.example.project_java_nguyenduchoang.utils.MessageKeys;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;
    private final ModelMapper modelMapper;
    private final LocalizationUtils localizationUtils;

    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory(); // Danh sách nguồn
        List<CategoryResponse> categoryResponseList = categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(categoryResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getAllCagetCategoryByIdtegory(@PathVariable Long id) throws Exception {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(
                CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build(),
                HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            ResponseObject responseObject = new ResponseObject();
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            responseObject.setMessage("FAIL");
            responseObject.setErrorCode(1);
            responseObject.setData(errorMessages);
            return ResponseEntity.badRequest().body(responseObject);
        }

        Category category = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(ResponseObject.builder()
                .message("SUCCESS")
                .errorCode(0)
                .data(category)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result) throws Exception {

        if (result.hasErrors()) {
            ResponseObject responseObject = new ResponseObject();
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            responseObject.setMessage("FAIL");
            responseObject.setErrorCode(1);
            responseObject.setData(errorMessages);
            return ResponseEntity.badRequest().body(responseObject);
        }

        Category category = categoryService.updateCategory(id, categoryDTO);
        return new ResponseEntity<>(ResponseObject.builder()
                .message("SUCCESS")
                .errorCode(0)
                .data(category)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> updateCategory(@PathVariable Long id) throws Exception {
        Category category = categoryService.deleteCategory(id);
        return new ResponseEntity<>(ResponseObject.builder()
                .message("SUCCESS")
                .errorCode(0)
                .data(category)
                .build(), HttpStatus.OK);
    }
}
