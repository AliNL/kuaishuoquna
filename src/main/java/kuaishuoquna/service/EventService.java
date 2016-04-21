package kuaishuoquna.service;

import kuaishuoquna.mappers.EventMapper;
import kuaishuoquna.mappers.MyBatisUtil;
import kuaishuoquna.model.Event;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    final EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);


    public void createEvent(Event event) {
        eventMapper.insert(event);
    }

    public Event findEventByUrl(String url) {
        return eventMapper.getEventByUrl(url);
    }
}
