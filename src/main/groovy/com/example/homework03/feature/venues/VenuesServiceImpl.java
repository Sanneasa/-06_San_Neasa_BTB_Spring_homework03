package com.example.homework03.feature.venues;

import com.example.homework03.feature.venues.dto.VenuesRequest;
import com.example.homework03.feature.venues.dto.VenuesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VenuesServiceImpl implements VenuesService {

    private final VenuesRepository venuesRepository;

    VenuesServiceImpl(VenuesRepository venuesRepository){
        this.venuesRepository = venuesRepository;
    }

    @Override
    public VenuesResponse addNewVenues(VenuesRequest venuesRequest)  {

        if(venuesRequest == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Venues  request cannot be null ?"

            );
        }
        if(venuesRequest.getVenuesName()==null || venuesRequest.getLocation() == null) {
              throw new ResponseStatusException(
                      HttpStatus.BAD_REQUEST,
                      " Venues name and location should be not null ? "
              );
        }

        return  venuesRepository.createVenues(venuesRequest);
    }

    @Override
    public List<VenuesResponse> findAllVenues(Integer page, Integer size) {
        return  venuesRepository.findAllVenues(page,size);
    }

    @Override
    public VenuesResponse findVenuesById(Integer id) {
        return venuesRepository.findVenuesById(id);
    }

    @Override
    public VenuesResponse updateVenuesById(Integer id, VenuesRequest venuesRequest) {

        return venuesRepository.updateVenuesById(venuesRequest,id);
    }

    @Override
    public boolean deleteVenuesById(Integer id) {
        return venuesRepository.deleteVenuesById(id);
    }

}
