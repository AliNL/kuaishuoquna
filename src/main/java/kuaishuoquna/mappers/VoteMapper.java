package kuaishuoquna.mappers;

import kuaishuoquna.model.Address;
import kuaishuoquna.model.People;
import kuaishuoquna.model.Time;
import kuaishuoquna.model.VoteDetail;
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

    @Select(
            "SELECT event_url, people_id, name FROM people " +
                    "WHERE event_url = #{event_url}"
    )
    @Results(value = {
            @Result(property="event_url"),
            @Result(property="people_id"),
            @Result(property="name")
    })
    List<People> getPeopleByEventUrl(String event_url);

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

    @Insert(
            "INSERT INTO people (name, event_url) " +
                    "VALUES (#{name}, #{event_url})"
    )
    @Options(keyProperty = "people_id", useGeneratedKeys = true)
    @Result(property = "people_id")
    long insertPeople(People people);

    @Insert(
            "INSERT INTO vote_detail (people_id, type, item_id) " +
                    "VALUES (#{people_id}, #{type}, #{item_id})"
    )
    void insertVoteDetail(VoteDetail voteDetail);

    @Update(
            "UPDATE time " +
                    "SET count_number = count_number + 1 " +
                    "WHERE time_id = #{item_id}"
    )
    void updateTimeNumber(long item_id);

    @Update(
            "UPDATE address " +
                    "SET count_number = count_number + 1 " +
                    "WHERE address_id = #{item_id}"
    )
    void updateAddressNumber(long item_id);

    @Update(
            "UPDATE event " +
                    "SET active = false " +
                    "WHERE event_url = #{event_url}"
    )
    void EndEventByUrl(String event_url);
}