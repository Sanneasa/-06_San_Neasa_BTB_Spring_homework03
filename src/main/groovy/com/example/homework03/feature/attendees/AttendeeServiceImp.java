package com.example.homework03.feature.attendees;

import com.example.homework03.feature.attendees.dto.AttendeeRequest;
import com.example.homework03.feature.attendees.dto.AttendeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImp  implements  AttendeeService{

    AttendeeServiceImp(AttendeeRepository attendeeRepository){
        this.attendeeRepository = attendeeRepository;
    }
    private final AttendeeRepository attendeeRepository;

    @Override
    public AttendeeResponse addNewAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.addNewAttendee(attendeeRequest);
    }

    @Override
    public List<AttendeeResponse> finAllAttendee(Integer page, Integer size) {
        return attendeeRepository.findAllAttendee(page,size);
    }

    @Override
    public AttendeeResponse findAttendeeById(Integer id) {
        return attendeeRepository.findAttendeeById(id);
    }

    @Override
    public AttendeeResponse updateAttendeeById(AttendeeRequest attendeeRequest, Integer id) {
        return attendeeRepository.updateAttendeeById(attendeeRequest,id);
    }

    @Override
    public boolean deletedAttendeeById(Integer id) {
        return attendeeRepository.deleteVenuesById(id);
    }
}
