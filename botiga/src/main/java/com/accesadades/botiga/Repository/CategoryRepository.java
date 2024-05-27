package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
