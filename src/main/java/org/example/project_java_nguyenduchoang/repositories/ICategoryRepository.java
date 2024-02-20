package org.example.project_java_nguyenduchoang.repositories;

import org.example.project_java_nguyenduchoang.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
