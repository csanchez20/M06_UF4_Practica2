package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Category;
import java.util.Set;

public interface CategoryService {
    Set<Category> findAllCategories();

    Category findCategoryById(Long id);

    Category saveCategory(Category category);

    void deleteCategory(Long id);
}
