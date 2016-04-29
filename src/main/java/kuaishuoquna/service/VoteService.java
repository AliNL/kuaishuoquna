package kuaishuoquna.service;

import kuaishuoquna.mappers.MyBatisUtil;
import kuaishuoquna.mappers.VoteMapper;
import kuaishuoquna.model.Address;
import kuaishuoquna.model.Time;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    private VoteMapper voteMapper = sqlSession.getMapper(VoteMapper.class);

    public void createTime(Time time) {
        voteMapper.insertTime(time);
        sqlSession.commit();
    }

    public void createAddress(Address address) {
        voteMapper.insertAddress(address);
        sqlSession.commit();
    }

    public List<Time> findTimeByEventId(long eventId) {
        sqlSession.clearCache();
        return voteMapper.getTimeByEventId(eventId);
    }

    public List<Address> findAddressByEventId(long eventId) {
        sqlSession.clearCache();
        return voteMapper.getAddressByEventId(eventId);
    }
}
