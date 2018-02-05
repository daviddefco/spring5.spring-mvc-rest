package com.daviddefco.codesamples.spring5.springmvcrest.repositories;

import com.daviddefco.codesamples.spring5.springmvcrest.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
