package com.example.homework03.feature.venues;
import com.example.homework03.feature.venues.dto.VenuesRequest;
import com.example.homework03.feature.venues.dto.VenuesResponse;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface VenuesRepository {

    @Select("""
        INSERT INTO venues (venues_name, location,venues_id)
        VALUES (#{request.venuesName}, #{request.location},#{request.venuesId})
        RETURNING *
    """)
    @Results(
            id = "venuesMapper",
            value = {
                    @Result(property="venuesId", column="venues_id"),
                    @Result(property="venuesName", column="venues_name"),
                    @Result(property="location", column="location")
            }
    )
    VenuesResponse createVenues(@Param("request") VenuesRequest venuesRequest);


    @Select(
            """
      select * from venues 
      offset #{size} *(#{page}-1)
      limit #{size};
    """
    )
    @ResultMap("venuesMapper")
    List<VenuesResponse> findAllVenues(Integer page, Integer size);


    @Select(
            """
       select * from venues 
       where venues_id = #{id}
    """
    )
     @ResultMap("venuesMapper")
     VenuesResponse findVenuesById(Integer id);

   @Select(
           """
        update venues
        set venues_name = #{request.venuesName}, location = #{request.location}
        where venues_id = #{id}
        returning *
   """
   )
    @ResultMap("venuesMapper")
     VenuesResponse updateVenuesById(@Param("request") VenuesRequest venuesRequest,Integer id);


   @Delete(
   """ 
    delete  from venues
    where venues_id =#{id}
   """
   )
     boolean deleteVenuesById(Integer id);


}