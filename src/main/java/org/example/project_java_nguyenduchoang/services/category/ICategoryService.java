package org.example.project_java_nguyenduchoang.services.category;


import org.example.project_java_nguyenduchoang.dtos.CategoryDTO;
import org.example.project_java_nguyenduchoang.models.Category;

public interface ICategoryService {
    Category createCategory(CategoryDTO categoryDTO);

}
