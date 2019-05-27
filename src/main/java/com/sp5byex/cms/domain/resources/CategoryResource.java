package com.sp5byex.cms.domain.resources;

import com.sp5byex.cms.domain.models.Category;
import com.sp5byex.cms.domain.service.CategoryService;
import com.sp5byex.cms.domain.vo.CategoryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/catetory")
@Api(tags="category", description = "Category API")
public class CategoryResource {

  private final CategoryService categoryService;
  public CategoryResource(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Find category", notes = "Find the Category by ID")
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Category found"),
      @ApiResponse(code = 404, message = "Category not found")
    }
  )
  public ResponseEntity<Category> findOne(
    @PathVariable("id") String id
  ) {
    return ResponseEntity.ok(new Category());
  }

  @GetMapping
  @ApiOperation(value = "List categories", notes = "List all categories")
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Categories found"),
      @ApiResponse(code = 404, message = "Categories not found")
    }
  )
  public ResponseEntity<List<Category>> findAll() {
    return ResponseEntity.ok(
      categoryService.findAll()
    );
  }

  @PostMapping
  public ResponseEntity<Category> newCategory(@RequestBody CategoryRequest cat) {
    return new ResponseEntity<>(categoryService.create(cat), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removeCategory(@PathVariable("id") String id) {

  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest req) {
    return new ResponseEntity<>(new Category(), HttpStatus.OK);
  }

}
