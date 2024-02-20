package org.example.project_java_nguyenduchoang.services.category;

import lombok.RequiredArgsConstructor;
import org.example.project_java_nguyenduchoang.dtos.CategoryDTO;
import org.example.project_java_nguyenduchoang.models.Category;
import org.example.project_java_nguyenduchoang.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(Category.builder()
                .name(categoryDTO.getName())
                .build());
    }
}
