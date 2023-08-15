package com.tracker.dredson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dredson.models.Category;
import com.tracker.dredson.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public Category save(@RequestBody Category category ) {
        return categoryService.save(category);
    }

    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }
}