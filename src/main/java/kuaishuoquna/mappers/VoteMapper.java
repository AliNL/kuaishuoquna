package kuaishuoquna.mappers;

import kuaishuoquna.model.Address;
import kuaishuoquna.model.Event;
import kuaishuoquna.model.Time;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yzhou on 16-4-29.
 */
public interface VoteMapper {

    @Select(
            "SELECT event_id, time_id, note, count_number FROM time " +
                    "WHERE event_id = #{eventId}"
    )
    @Results(value = {
            @Result(property="event_id"),
            @Result(property="time_id"),
            @Result(property="note"),
            @Result(property="count_number")
    })
    List<Time> getTimeByEventId(long eventId);

    @Select(
            "SELECT event_id, address_id, note, count_number FROM address " +
                    "WHERE event_id = #{eventId}"
    )
    @Results(value = {
            @Result(property="event_id"),
            @Result(property="address_id"),
            @Result(property="note"),
            @Result(property="count_number")
    })
    List<Address> getAddressByEventId(long eventId);

    @Insert(
            "INSERT INTO time (event_id, note) " +
                    "VALUES (#{event_id}, #{note})"
    )
    @Options(keyProperty = "time_id", useGeneratedKeys = true)
    void insertTime(Time time);

    @Insert(
            "INSERT INTO address (event_id, note) " +
                    "VALUES (#{event_id}, #{note})"
    )
    @Options(keyProperty = "address_id", useGeneratedKeys = true)
    void insertAddress(Address address);
}
