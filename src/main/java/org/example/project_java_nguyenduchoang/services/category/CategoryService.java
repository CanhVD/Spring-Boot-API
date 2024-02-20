package org.example.project_java_nguyenduchoang.services.category;

import lombok.RequiredArgsConstructor;
import org.example.project_java_nguyenduchoang.dtos.CategoryDTO;
import org.example.project_java_nguyenduchoang.models.Category;
import org.example.project_java_nguyenduchoang.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        return categoryRepository.findById(id).orElseThrow(() -> new Exception("Category not found"));
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(Category.builder()
                .name(categoryDTO.getName())
                .build());
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) throws Exception{
        Category category = getCategoryById(id);
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(long id) throws Exception {
        Category category = getCategoryById(id);
        categoryRepository.deleteById(id);
        return category;
    }
}
