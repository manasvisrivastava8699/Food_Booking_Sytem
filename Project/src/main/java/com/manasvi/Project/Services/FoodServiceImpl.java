package com.manasvi.Project.Services;

import com.manasvi.Project.Entiry.BookFood;
import com.manasvi.Project.Entiry.Food;
import com.manasvi.Project.Repository.FoodBookingRepository;
import com.manasvi.Project.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodBookingRepository foodBookingRepository;

    @Autowired
    private UserService userService;

    @Override
    public Page<Food> getAllFood(Pageable page) {
        return foodRepository.findAll(page);
    }

    @Override
    public Page<Food> getAllFoodByLoggedInUser(Pageable page) {
        return foodRepository.findBybookingemailId(userService.getLoggedInUser().getEmail(), page);
    }

    @Override
    public Food getFoodById(int id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()) {
            return food.get();
        }
        throw new RuntimeException("Food Item is not found for this id " + id);
    }

    @Override
    public String deleteFoodById(int id) {
        Food existingfood = getFoodById(id);
        foodRepository.deleteById(id);
        return "The Food Item has been permanently deleted";
    }

    @Override
    public Food saveFoodDetails(Food food) {
        food.setBookingemailId("NULL");
        return foodRepository.save(food);
    }

    @Override
    public Food updateFoodDetails(int id, Food food) {
        Food existingFood = getFoodById(id);
        existingFood.setName(food.getName() != null ? food.getName() : existingFood.getName());
        existingFood.setCost(food.getCost() != null ? food.getCost() : existingFood.getCost());
        existingFood.setType(food.getType() != null ? food.getType() : existingFood.getType());
        return foodRepository.save(existingFood);
    }

    @Override
    public String bookFood(int id, Food food) {
        Food existingfood =getFoodById(id);
        BookFood fb = new BookFood();
        fb.setName(existingfood.getName());
        fb.setBookingname(userService.getLoggedInUser().getUsername());
        fb.setBookingemailId(userService.getLoggedInUser().getEmail());
        fb.setCost(existingfood.getCost());
        fb.setType(existingfood.getType());
        foodBookingRepository.save(fb);
        return "Item added successfully";
    }
}


