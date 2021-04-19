package com.library.dao;

import com.library.bean.Vote;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class VoteDao {

    private final static String NAMESPACE = "com.library.dao.VoteDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public List<Vote> getAllVote() {
        return sqlSessionTemplate.selectList(NAMESPACE + "getAllVote");
    }
    public int setEnd(int id) {
        return sqlSessionTemplate.update(NAMESPACE + "setEnd",id);
    }
    public List<Vote> getAllVoteById(int id) {
        return sqlSessionTemplate.selectList(NAMESPACE + "getAllVoteById",id);
    }
    public void addVote(Vote vote){
        sqlSessionTemplate.insert(NAMESPACE+"addVote",vote);
    }
    public int maxId(){
        return sqlSessionTemplate.selectOne(NAMESPACE+"maxId");
    }
    public List<Vote> getVoteByUserId(int id) {
        return sqlSessionTemplate.selectList(NAMESPACE + "getVoteByUserId",id);
    }

    public List<Integer> getJoinVoteIdByUserId(int id) {
        return sqlSessionTemplate.selectList(NAMESPACE + "getJoinVoteIdByUserId",id);
    }
    public Vote getVoteById(int id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getVoteById",id);
    }
    public void deleteVoteById(int id) {
        sqlSessionTemplate.delete(NAMESPACE + "deleteVoteById",id);
    }

}
