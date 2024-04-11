package com.manasvi.Project.Repository;

import com.manasvi.Project.Entiry.BookFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodBookingRepository extends JpaRepository<BookFood, Integer> {
}
