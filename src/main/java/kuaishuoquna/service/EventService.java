package kuaishuoquna.service;

import kuaishuoquna.mappers.EventMapper;
import kuaishuoquna.mappers.MyBatisUtil;
import kuaishuoquna.model.Event;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    private EventMapper eventMapper = sqlSession.getMapper(EventMapper.class);


    public void createEvent(Event event) {
        eventMapper.insert(event);
        sqlSession.commit();
    }

    public Event findEventByUrl(String url) {
        sqlSession.clearCache();
        return eventMapper.getEventByUrl(url);
    }
}
