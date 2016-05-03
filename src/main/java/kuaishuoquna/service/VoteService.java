package kuaishuoquna.service;

import kuaishuoquna.mappers.MyBatisUtil;
import kuaishuoquna.mappers.VoteMapper;
import kuaishuoquna.model.Address;
import kuaishuoquna.model.People;
import kuaishuoquna.model.Time;
import kuaishuoquna.model.VoteDetail;
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

    public List<Time> findTimeByEventUrl(String url) {
        sqlSession.clearCache();
        return voteMapper.getTimeByEventUrl(url);
    }

    public List<Address> findAddressByEventUrl(String url) {
        sqlSession.clearCache();
        return voteMapper.getAddressByEventUrl(url);
    }

    public long createPeople(People people) {
        long people_id = voteMapper.insertPeople(people);
        sqlSession.commit();
        return people_id;
    }

    public List<People> findPeopleByEventUrl(String url) {
        sqlSession.clearCache();
        return voteMapper.getPeopleByEventUrl(url);
    }

    public void createVoteDetails(List<VoteDetail> voteDetails) {
        for (VoteDetail voteDetail : voteDetails) {
            voteMapper.insertVoteDetail(voteDetail);
            if (voteDetail.getType().equals("time"))
                voteMapper.updateTimeNumber(voteDetail.getItem_id());
            else
                voteMapper.updateAddressNumber(voteDetail.getItem_id());
        }
        sqlSession.commit();
    }

    public void EndEventByUrl(String event_url) {
        voteMapper.EndEventByUrl(event_url);
        sqlSession.commit();
    }
}
