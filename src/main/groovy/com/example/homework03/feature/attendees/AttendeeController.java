package com.example.homework03.feature.attendees;

import com.example.homework03.exception.ApiResponse;
import com.example.homework03.feature.attendees.dto.AttendeeRequest;
import com.example.homework03.feature.attendees.dto.AttendeeResponse;
import com.example.homework03.feature.venues.dto.VenuesResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/vi/attendee")
public class AttendeeController {

    AttendeeController(AttendeeService attendeeService){
        this.attendeeService = attendeeService;
    }
    private final AttendeeService attendeeService;

    @PostMapping
    ResponseEntity<ApiResponse<AttendeeResponse>>  addNewAttendee(@Valid @RequestBody AttendeeRequest attendeeRequest){
        AttendeeResponse addNewAtt = attendeeService.addNewAttendee(attendeeRequest);
        ApiResponse<AttendeeResponse>  response = ApiResponse.<AttendeeResponse> builder()
                .message("Add new attendee successfully....")
                .httpStatus(HttpStatus.CREATED)
                .timeStamp(LocalTime.now())
                .payload(addNewAtt)
                .build();
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @GetMapping()
    ResponseEntity<ApiResponse<List<AttendeeResponse>>> findAllAttendee(@Valid @RequestParam Integer page , @RequestParam Integer size) {

       List<AttendeeResponse> findAttendee = attendeeService.finAllAttendee(size,page);
       ApiResponse<List<AttendeeResponse>> response = ApiResponse .<List<AttendeeResponse>>  builder()
               .message("Find attendee successfully...")
               .httpStatus(HttpStatus.OK)
               .timeStamp(LocalTime.now())
               .payload(findAttendee)
               .build();

       return new ResponseEntity<>(response,HttpStatus.OK);

    }


    @GetMapping("/{attendee-id}")
    ResponseEntity<ApiResponse<AttendeeResponse>> findAttendeeById(@Valid @PathVariable("attendee-id") Integer id) {

        AttendeeResponse findAttendeeId = attendeeService.findAttendeeById(id);
        ApiResponse<AttendeeResponse> response = ApiResponse .<AttendeeResponse>  builder()
                .message("Find attendee successfully...")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(findAttendeeId)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PutMapping("/{attendee-id}")
    ResponseEntity<ApiResponse<AttendeeResponse>> updateAttendeeById(@Valid @PathVariable("attendee-id") Integer id,@RequestBody AttendeeRequest attendeeRequest) {

        AttendeeResponse updateAttendeeId = attendeeService.updateAttendeeById(attendeeRequest,id);
        ApiResponse<AttendeeResponse> response = ApiResponse .<AttendeeResponse>  builder()
                .message("Update attendee successfully...")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .payload(updateAttendeeId)
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);


    }

    @DeleteMapping("/{attendee-id}")
    ResponseEntity<ApiResponse<VenuesResponse>> deletedAttendeeById( @Valid @PathVariable("attendee-id") Integer id) {
        boolean attendee = attendeeService.deletedAttendeeById(id);
        ApiResponse<VenuesResponse> response = ApiResponse.<VenuesResponse> builder()
                .message("Deleted attendee by id successfully..")
                .httpStatus(HttpStatus.OK)
                .timeStamp(LocalTime.now())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
