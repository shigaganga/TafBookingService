package com.tekarch.TafBookingService.Controller;

import com.tekarch.TafBookingService.Model.BookingsDTO;
import com.tekarch.TafBookingService.Service.BookingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/bookings")
    public class BookingController {
        private static final Logger logger = LogManager.getLogger(BookingController.class);
        @Autowired
        BookingServiceImpl bookingServiceImpl;
        @PostMapping
        public BookingsDTO createBooking(@RequestBody BookingsDTO bookingsDTO){
            return bookingServiceImpl.createBooking(bookingsDTO);
        }
        @GetMapping
        public List<BookingsDTO> getAllBookings(){
            return bookingServiceImpl.getAllBookings();
        }
        @GetMapping("/{bookingId}")
        public BookingsDTO getBookingBybookingId(@PathVariable Long bookingId){
            return bookingServiceImpl.getBookingByBookingId(bookingId);
        }
        @GetMapping("users/{userId}")
        public BookingsDTO getBookingByuserId(@PathVariable Long userId){
            return bookingServiceImpl.getBookingByUserId(userId);
        }
        @DeleteMapping("/{bookingId}")
        public void deleteBooking(@PathVariable Long bookingId){
            bookingServiceImpl.deleteBookingByBookingId(bookingId);
        }
}
