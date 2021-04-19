package com.library.dao;

import com.library.bean.Voteoption;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VoteoptionDao {

    private final static String NAMESPACE = "com.library.dao.VoteoptionDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public List<Voteoption> getOptionByVoteId(int voteid) {
        return sqlSessionTemplate.selectList(NAMESPACE + "getOptionByVoteId", voteid);
    }
    public int matchOptionIdCount(int optionid){
        return sqlSessionTemplate.selectOne(NAMESPACE + "matchOptionIdCount",optionid);
    }
    public int addSelect(int voteid,int userid,int optionid){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("voteid", voteid);
        paramMap.put("userid", userid);
        paramMap.put("optionid", optionid);
        return sqlSessionTemplate.insert(NAMESPACE +"addSelect",paramMap);
    }
    public void addOption(Voteoption voteoption){
         sqlSessionTemplate.insert(NAMESPACE +"addOption",voteoption);
    }
    public void deleteVoteOptionByVoteId(int id) {
        sqlSessionTemplate.delete(NAMESPACE + "deleteVoteOptionByVoteId",id);
    }
    public void deleteSelectByVoteId(int id) {
        sqlSessionTemplate.delete(NAMESPACE + "deleteSelectByVoteId",id);
    }
}
