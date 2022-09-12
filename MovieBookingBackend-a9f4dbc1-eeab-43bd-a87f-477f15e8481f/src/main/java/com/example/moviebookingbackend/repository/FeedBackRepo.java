package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepo extends JpaRepository<FeedBack , Long> {
}
