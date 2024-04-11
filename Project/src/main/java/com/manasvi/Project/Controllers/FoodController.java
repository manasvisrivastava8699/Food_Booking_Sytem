package com.manasvi.Project.Controllers;

import com.manasvi.Project.Entiry.Food;
import com.manasvi.Project.Repository.FoodRepository;
import com.manasvi.Project.Services.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    FoodServiceImpl foodService;

    @CrossOrigin
    @PostMapping("/food")
    public String saveFoodDetails(@RequestBody Food food ) {
        foodService.saveFoodDetails(food);
        return "The food item has been created successfully";
    }

    @CrossOrigin
    @DeleteMapping("/food/{id}")
    public String DeleteResourceById(@PathVariable("id")int id) {
        foodService.deleteFoodById(id);
        return "The food item has been deleted successfully";
    }

    @CrossOrigin
    @PostMapping("/food/{id}")
    public String BookResourceById(@RequestBody Food food,@PathVariable("id")int id) {
        foodService.bookFood(id,food);
        return "The food item has been added successfully to cart";
    }

    @CrossOrigin
    @GetMapping("/food")
    public List<Food> findAllResources(Pageable page) {
        return foodService.getAllFood((org.springframework.data.domain.Pageable) page).toList();
    }
}
