package com.example.homework03.feature.event;


import com.example.homework03.feature.event.dto.EventCreateRequest;
import com.example.homework03.feature.event.dto.EventResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select(
            """
          select  * from events
          offset #{page} * (#{size}-1)
          limit #{size}
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
    List<EventResponse>  findAllEvent(Integer page, Integer size);


    @Select(
            """
      select * from events e
      where e.event_id = #{eventId}
     """
    )
     @ResultMap("eventMapper")
     EventResponse findEventById(@Param("eventId") Integer eventId);


    @Select("""
        DELETE FROM events
        WHERE event_id = #{eventId}
        RETURNING true
    """)
    Boolean deleteEventById(@Param("eventId") Integer eventId);


    @Select("""
        UPDATE events
        SET event_name = #{request.eventName},
            event_date = #{request.eventDate},
            venues_id = #{request.venuesList}
        WHERE event_id = #{id}
        RETURNING  *
    """)
     EventResponse updateEvent( Integer id, @Param("request") EventCreateRequest eventCreateRequest);



    @Select(
            """
        insert  into events (event_name,event_date, venues_id)
        values(#{request.eventName}, #{request.eventDate}, #{request.venuesList})
     """
    )
    @ResultMap("eventMapper")
    EventResponse createEvent(@Param("request") EventCreateRequest eventCreateRequest);






}
