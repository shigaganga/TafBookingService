package com.tekarch.TafBookingService.Service;

import com.tekarch.TafBookingService.Model.BookingsDTO;
import com.tekarch.TafBookingService.Service.Interface.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
   // private final String DATASOURCE_URL = "http://localhost:8080/bookings";
   @Value("${datasource.url}")
   private String DATASOURCE_URL;
    @Override
    public BookingsDTO createBooking(BookingsDTO bookingsDTO) {
        System.out.println("from booking"+bookingsDTO);
        ResponseEntity<BookingsDTO> response=restTemplate.postForEntity(DATASOURCE_URL,bookingsDTO, BookingsDTO.class);
        return response.getBody();
    }

    @Override
    public List<BookingsDTO> getAllBookings() {
        List<BookingsDTO> bookings=restTemplate.exchange(DATASOURCE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<BookingsDTO>>() {
        }).getBody();
        return bookings;
    }

    @Override
    public BookingsDTO getBookingByBookingId(Long bookingId) {
        String url= DATASOURCE_URL+"/"+bookingId;
        return  restTemplate.getForObject(url, BookingsDTO.class);
    }

    @Override
    public BookingsDTO getBookingByUserId(Long userId) {
        // Placeholder logic to get booking by user ID
        String url = DATASOURCE_URL + "/users/" + userId;
        BookingsDTO booking = restTemplate.getForObject(url, BookingsDTO.class);

        if (booking != null) {
            logger.info("Booking retrieved for user ID {}: {}", userId, booking);
            return booking;
        } else {
            logger.error("No booking found for user ID: {}", userId);
            return null;  // Or you can return an empty object or a default value
        }
    }

    @Override
    public void deleteBookingByBookingId(Long bookingId) {
        String url=DATASOURCE_URL+"/"+bookingId;
        restTemplate.delete(url);
    }
}
