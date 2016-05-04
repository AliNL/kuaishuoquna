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
        List<Time> list = voteMapper.getTimeByEventUrl(url);
        for (Time time : list) {
            time.setPeopleList(findPeopleByTimeId(time.getTime_id()));
        }
        return list;
    }

    public List<Address> findAddressByEventUrl(String url) {
        sqlSession.clearCache();
        List<Address> list = voteMapper.getAddressByEventUrl(url);
        for (Address address : list) {
            address.setPeopleList(findPeopleByAddressId(address.getAddress_id()));
        }
        return list;
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

    public List<Time> findTimeInOrder(String url) {
        sqlSession.clearCache();
        List<Time> list = voteMapper.getTimeInOrder(url);
        for (Time time : list) {
            time.setPeopleList(findPeopleByTimeId(time.getTime_id()));
        }
        return list;
    }

    public List<Address> findAddressInOrder(String url) {
        sqlSession.clearCache();
        List<Address> list = voteMapper.getAddressInOrder(url);
        for (Address address : list) {
            address.setPeopleList(findPeopleByAddressId(address.getAddress_id()));
        }
        return list;
    }

    public List<People> findPeopleByTimeId(long time_id) {
        sqlSession.clearCache();
        return voteMapper.getPeopleByTimeId(time_id);
    }

    public List<People> findPeopleByAddressId(long address_id) {
        sqlSession.clearCache();
        return voteMapper.getPeopleByAddressId(address_id);
    }
}
