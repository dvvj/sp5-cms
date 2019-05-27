package com.sp5byex.cms.domain.repository;

import com.sp5byex.cms.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
  List<Category> findByName(String name);
  List<Category> findByNameIgnoreCaseStartingWith(String name);
}
//@Service
//public class CategoryRepository extends AbstractRepository<Category> {
//}
