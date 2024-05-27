package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.SubcategoryRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Set<Subcategory> findAllSubcategories() {
        Set<Subcategory> subcategories = new HashSet<>();
        subcategoryRepository.findAll().forEach(subcategories::add);
        return subcategories;
    }

    @Override
    public Subcategory findSubcategoryById(Long id) {
        return subcategoryRepository.findById(id).orElse(null);
    }

    @Override
    public Subcategory saveSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
