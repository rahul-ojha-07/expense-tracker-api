package io.github.rahulojha07.expensetrackerapi.services;

import io.github.rahulojha07.expensetrackerapi.domain.Category;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtBadRequestException;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtResourceNotFoundException;
import io.github.rahulojha07.expensetrackerapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        return categoryRepository.findAll(userId);
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
        return null;
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {

    }

    @Override
    public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException {

    }
}
