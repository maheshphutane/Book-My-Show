package com.scaler.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
public class Booking extends BaseModel{
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<MovieShowSeat> movieShowSeats;
    @ManyToOne
    private MovieShow movieShow;
    @Column(nullable = true)
    private double amount;
}
