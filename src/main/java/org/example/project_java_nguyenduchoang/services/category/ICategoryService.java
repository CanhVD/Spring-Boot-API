package org.example.project_java_nguyenduchoang.services.category;


import org.example.project_java_nguyenduchoang.dtos.CategoryDTO;
import org.example.project_java_nguyenduchoang.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(Long id) throws Exception;
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long id, CategoryDTO categoryDTO) throws Exception;
    Category deleteCategory(long id) throws Exception;
}
