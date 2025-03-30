package com.example.homework03.feature.event;


import com.example.homework03.feature.event.dto.EventResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select(
            """
      select  * from events
    """
    )
    @Results(
            id= "eventMapper",value = {
                    @Result(property = "eventName",column = "event_name"),
                    @Result(property = "eventDate",column = "event_date"),
                    @Result(property = "venuesList",column = "venues_id",
                            many = @Many(select = "com.example.homework03.feature.venues.VenuesRepository.findVenuesById")
                    ),
                   @Result(property = "attendeesList",column = "attendee_id",
                    many = @Many(select = "com.example.homework03.feature.attendees.AttendeeRepository.getAttendeeByEventId")
            )
    }
    )
    List<EventResponse>  findAllEvent();
}
