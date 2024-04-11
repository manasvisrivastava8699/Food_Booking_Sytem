package com.manasvi.Project.Services;

import com.manasvi.Project.Entiry.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FoodService {

    Page<Food> getAllFood(Pageable page);

        Page<Food> getAllFoodByLoggedInUser(Pageable page);

    Food getFoodById(int id);

    String deleteFoodById(int id);

    Food saveFoodDetails(Food food);

    Food updateFoodDetails(int id, Food resource);

    String bookFood(int id, Food food);


}
