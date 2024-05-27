package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Subcategory;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {
}
