package com.learning.api.v1.model;

import java.util.List;

public class CategoryListDTO {

    List<CategoryDTO> categories;

    public CategoryListDTO(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
