package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Subcategory;
import java.util.Set;

public interface SubcategoryService {
    Set<Subcategory> findAllSubcategories();

    Subcategory findSubcategoryById(Long id);

    Subcategory findByName(String name);

    Set<Subcategory> findByCategoryName(String categoryName);

    Subcategory saveSubcategory(Subcategory subcategory);

    void deleteSubcategory(Long id);
}
