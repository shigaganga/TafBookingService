package com.tekarch.TafBookingService.Service.Interface;

import com.tekarch.TafBookingService.Model.BookingsDTO;

import java.util.List;

public interface BookingService {
    BookingsDTO createBooking(BookingsDTO bookingsDTO);
    List<BookingsDTO> getAllBookings();
    BookingsDTO getBookingByBookingId(Long bookingId);
    BookingsDTO getBookingByUserId(Long userId);
    void deleteBookingByBookingId(Long BookingId);
}
