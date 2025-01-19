package com.tekarch.TafBookingService.Model;

import java.time.LocalDateTime;

public class BookingsDTO {
    private Long bookingId;
    private Long userId;
    private Long flightId;
    private String status;
    private LocalDateTime created_at;
    private  LocalDateTime updated_at;
}
