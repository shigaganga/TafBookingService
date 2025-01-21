package com.tekarch.TafBookingService.Model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingsDTO {

    private Long booking_id;

  //  @ManyToOne(fetch = FetchType.EAGER,optional = false) g

//This means that many Booking records can be linked to one User.
//The User object is not fetched immediately when the Booking is loaded from the database.
  //  @JoinColumn(name="user_id",nullable = false)
//Specifies that the user_id column in the Booking table
// is the foreign key linking to the id column in the User table.
    private UserDTO user;
   // @ManyToOne(fetch = FetchType.EAGER,optional = false)

   // @JoinColumn(name="flight_id",nullable = false)
    private FlightDTO flight;
    @Column(name="status")
    private String status;
    @UpdateTimestamp
    @Column(name="created_at")
    private LocalDateTime created_at;
    @UpdateTimestamp
    @Column(name="updated_at")
    private  LocalDateTime updated_at;

}
