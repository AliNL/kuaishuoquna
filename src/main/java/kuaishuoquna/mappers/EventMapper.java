package kuaishuoquna.mappers;

import kuaishuoquna.model.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface EventMapper {

    @Insert(
            "INSERT INTO event (url, name, owner, password, description, active) " +
            "VALUES (#{url}, #{name}, #{owner}, #{password}, #{description}, #{active})"
    )
    @Options(keyProperty = "event_id", useGeneratedKeys = true)
    void insert(Event event);

    @Select(
            "SELECT event_id, url, name, owner, password, description, active " +
                    "FROM event " +
                    "WHERE url = #{url}"
    )
    Event getEventByUrl(String url);
}
