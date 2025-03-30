package com.example.homework03.feature.venues;

import com.example.homework03.exception.ApiResponse;
import com.example.homework03.feature.venues.dto.VenuesRequest;
import com.example.homework03.feature.venues.dto.VenuesResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenuesController {


    VenuesController( VenuesService venuesService) {
        this.venuesService = venuesService;
    }
    private  final VenuesService venuesService;

    @PostMapping()
    ResponseEntity<ApiResponse<VenuesResponse>>  createVenues(@Valid @RequestBody VenuesRequest venuesRequest) {

        VenuesResponse venues = venuesService.addNewVenues(venuesRequest);

        ApiResponse<VenuesResponse>  response = ApiResponse.<VenuesResponse> builder()
                .message("Create venues successfully..")
                .httpStatus(HttpStatus.CREATED)
                .timeStamp(LocalTime.now())
                .payload(venues)
                .build();

        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping
    ResponseEntity<ApiResponse<List<VenuesResponse>>> findAllVenues(@RequestParam Integer page,@RequestParam Integer size) {

        List<VenuesResponse> venuesResponse = venuesService.findAllVenues(page,size);

        ApiResponse<List<VenuesResponse>> response  = ApiResponse.<List<VenuesResponse>> builder()
                .message("Find all venues successfully..")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(venuesResponse)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{venues-id}")
    ResponseEntity<ApiResponse<VenuesResponse>>  findVenuesById (@PathVariable("venues-id") Integer id) {
        VenuesResponse venuesResponse = venuesService.findVenuesById(id);
        ApiResponse<VenuesResponse> response = ApiResponse.<VenuesResponse> builder()
                .message("Find by id successfully..")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(venuesResponse)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{venues-id}")
    ResponseEntity<ApiResponse<VenuesResponse>> updateVenuesById(@Valid @RequestBody VenuesRequest venuesRequest,@PathVariable("venues-id") Integer id){
        VenuesResponse venuesUpdate = venuesService.updateVenuesById(id,venuesRequest);
        ApiResponse<VenuesResponse> response = ApiResponse.<VenuesResponse> builder()
                .message("Update venues by id successfully..")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(venuesUpdate)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @DeleteMapping("/{venues-id}")
    ResponseEntity<ApiResponse<VenuesResponse>> deletedVenuesById(@PathVariable("venues-id") Integer id) {
        boolean venuesDeleted = venuesService.deleteVenuesById(id);
        ApiResponse<VenuesResponse> response = ApiResponse.<VenuesResponse> builder()
                .message("Deleted venues by id successfully..")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}

