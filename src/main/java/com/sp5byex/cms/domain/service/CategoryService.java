package com.sp5byex.cms.domain.service;

import com.sp5byex.cms.domain.models.Category;
import com.sp5byex.cms.domain.repository.CategoryRepository;
import com.sp5byex.cms.domain.vo.CategoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoryService {

  private final CategoryRepository categoryRepository;


  public CategoryService(
    CategoryRepository catRepo
  ) {
    this.categoryRepository = catRepo;
  }

  @Transactional
  public Category update(Category cat) {
    return this.categoryRepository.save(cat);
  }

  @Transactional
  public Category create(CategoryRequest req) {
    Category cat = new Category();
    cat.setName(req.getName());
    return this.categoryRepository.save(cat);
  }

  @Transactional
  public void delete(String id) {
    final Optional<Category> cat = this.categoryRepository.findById(id);
    cat.ifPresent(this.categoryRepository::delete);

  }

  public List<Category> findAll() {
    return this.categoryRepository.findAll();
  }

  public Category findById(String id) {

    final Optional<Category> category = this.categoryRepository.findById(id);

    if (category.isPresent()) {
      return category.get();
    }
    else {
      throw new RuntimeException("category not found!");
    }
  }

}
