package com.example.homework03.feature.attendees;

import com.example.homework03.feature.attendees.dto.AttendeeRequest;
import com.example.homework03.feature.attendees.dto.AttendeeResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AttendeeService {

       AttendeeResponse addNewAttendee(AttendeeRequest attendeeRequest);

       List<AttendeeResponse> finAllAttendee( Integer page , Integer size);


       AttendeeResponse   findAttendeeById(Integer id);


       AttendeeResponse updateAttendeeById(AttendeeRequest attendeeRequest , Integer id);


       boolean deletedAttendeeById(Integer id);


}
