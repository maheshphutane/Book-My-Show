package com.scaler.bookmyshow.repository;

import com.scaler.bookmyshow.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow,Long> {
}
