package com.example.homework03.feature.venues;

import com.example.homework03.feature.venues.dto.VenuesRequest;
import com.example.homework03.feature.venues.dto.VenuesResponse;

import java.util.List;

public interface VenuesService {

    VenuesResponse addNewVenues(VenuesRequest venuesRequest);

    List<VenuesResponse> findAllVenues(Integer page, Integer size);

    VenuesResponse findVenuesById(Integer id);

    VenuesResponse updateVenuesById(Integer id , VenuesRequest venuesRequest);

    boolean deleteVenuesById(Integer id);

}
