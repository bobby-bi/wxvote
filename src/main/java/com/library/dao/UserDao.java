package com.library.dao;

import com.library.bean.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao {

    private final static String NAMESPACE = "com.library.dao.UserDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int getMatchOpenId(final String openid) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getMatchOpenId", openid);
    }
    public int addUser(User user){
        return sqlSessionTemplate.insert(NAMESPACE+"addUser",user);
    }
    public int getIdByOpenId(String openid){
        return sqlSessionTemplate.selectOne(NAMESPACE+"getIdByOpenId",openid);
    }
    public User getUserById( int id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getUserById", id);
    }

    public List<Integer> getIdByVoteId(int voteid){
        return sqlSessionTemplate.selectList(NAMESPACE+"getIdByVoteId",voteid);
    }
    public List<Integer> getIdByOptionId(int optionid){
        return sqlSessionTemplate.selectList(NAMESPACE+"getIdByOptionId",optionid);
    }

}
