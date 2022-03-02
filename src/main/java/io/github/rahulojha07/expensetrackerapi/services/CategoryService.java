package io.github.rahulojha07.expensetrackerapi.services;

import io.github.rahulojha07.expensetrackerapi.domain.Category;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtBadRequestException;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;

    void updateCategory(Integer userId,Integer categoryId, Category category) throws EtBadRequestException;

    void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;


}
