package com.scaler.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Hall extends BaseModel{
    private String hallName;
    @OneToMany
    private List<Seat> seats;
    private SreenType sreenType;
}
