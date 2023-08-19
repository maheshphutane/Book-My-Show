package com.scaler.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{
    private Date startTime;
    private int durationMinutes;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Hall hall;
}
