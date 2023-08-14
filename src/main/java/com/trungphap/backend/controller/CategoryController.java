package com.trungphap.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trungphap.backend.entity.Category;
import com.trungphap.backend.service.CategoryService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long Categoryld) {
        Category Category = categoryService.getCategoryById(Categoryld);
        return new ResponseEntity<>(Category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategorys() {
        List<Category> Categorys = categoryService.getAllCategorys();
        return new ResponseEntity<>(Categorys, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long Categoryld,
            @RequestBody Category Category) {
        Category.setId(Categoryld);
        Category updatedCategory = categoryService.updateCategory(Category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long CategoryId) {
        categoryService.deleteCategory(CategoryId);
        return new ResponseEntity<>("Category successfully deleted!", HttpStatus.OK);
    }
}
