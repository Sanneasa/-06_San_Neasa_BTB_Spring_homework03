package com.example.homework03.feature.attendees;


import com.example.homework03.feature.attendees.dto.AttendeeRequest;
import com.example.homework03.feature.attendees.dto.AttendeeResponse;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select(
            """
            INSERT INTO attendee (attendee_name, email)
            VALUES (#{request.attendeeName}, #{request.attendeeEmail})
            RETURNING *
            """
    )
    @Results(id="attendeeMapper", value={
            @Result(property="attendeeName", column="attendee_name"),
            @Result(property="attendeeId", column="attendee_id"),
            @Result(property="attendeeEmail", column="email")

    })
    AttendeeResponse addNewAttendee(@Param("request") AttendeeRequest attendeerequest);

    @Select(
            """
       select * from attendee 
       offset #{page} * (#{size}-1)
       limit #{size}
    """
    )
    @ResultMap("attendeeMapper")
    List<AttendeeResponse>  findAllAttendee(Integer page, Integer size);


    @Select(
            """
    select  a.attendee_id ,a.attendee_name, a.email
    from attendee a
    inner join event_attendee ea
    on a.attendee_id = ea.attendee_id
    where event_id = #{eventId}
    """
    )
    @ResultMap("attendeeMapper")
    AttendeeResponse getAttendeeByEventId(Integer eventId);


    @Select(
            """
        select * from attendee
        where attendee_id = #{id}
    """
    )
    @ResultMap("attendeeMapper")
    AttendeeResponse findAttendeeById(Integer id);


    @Select(
            """
        update  attendee
        set  attendee_name = #{request.attendeeName}, email = #{request.attendeeEmail}
        where attendee_id = #{id}
       returning *
     """
    )
    @ResultMap("attendeeMapper")
    AttendeeResponse  updateAttendeeById( @Param("request") AttendeeRequest attendeeRequest, Integer id);


    @Delete(
            """ 
             delete  from attendee
             where attendee_id =#{id}
            """
    )
    boolean deleteVenuesById( Integer id);


}



