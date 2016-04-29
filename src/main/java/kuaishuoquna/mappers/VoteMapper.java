package kuaishuoquna.mappers;

import kuaishuoquna.model.Address;
import kuaishuoquna.model.Time;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface VoteMapper {

    @Select(
            "SELECT event_url, time_id, note, count_number FROM time " +
                    "WHERE event_url = #{event_url}"
    )
    @Results(value = {
            @Result(property="event_url"),
            @Result(property="time_id"),
            @Result(property="note"),
            @Result(property="count_number")
    })
    List<Time> getTimeByEventUrl(String event_url);

    @Select(
            "SELECT event_url, address_id, note, count_number FROM address " +
                    "WHERE event_url = #{event_url}"
    )
    @Results(value = {
            @Result(property="event_url"),
            @Result(property="address_id"),
            @Result(property="note"),
            @Result(property="count_number")
    })
    List<Address> getAddressByEventUrl(String event_url);

    @Insert(
            "INSERT INTO time (event_url, note) " +
                    "VALUES (#{event_url}, #{note})"
    )
    @Options(keyProperty = "time_id", useGeneratedKeys = true)
    void insertTime(Time time);

    @Insert(
            "INSERT INTO address (event_url, note) " +
                    "VALUES (#{event_url}, #{note})"
    )
    @Options(keyProperty = "address_id", useGeneratedKeys = true)
    void insertAddress(Address address);
}
