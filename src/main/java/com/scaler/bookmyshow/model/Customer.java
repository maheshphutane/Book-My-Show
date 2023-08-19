package com.scaler.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseModel{
    private String name;
    private String email;
    @OneToMany
    private List<Booking> bookings;

}
