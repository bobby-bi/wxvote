package com.library.service;

import com.library.bean.User;
import com.library.dao.SelectdetailDao;
import com.library.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public boolean matchOpenId(String openid){
        return userDao.getMatchOpenId(openid)>0;
    }
    public boolean addUser(User user){
        return userDao.addUser(user)>0;
    }
    public int getIdByOpenId(String openid){
        return userDao.getIdByOpenId(openid);
    }
    public User getUserById( int id) {
        return userDao.getUserById(id);
    }
    public List<Integer> getIdByVoteId(int voteid){
        return userDao.getIdByVoteId(voteid);
    }
    public List<Integer> getIdByOptionId(int option){
        return userDao.getIdByOptionId(option);
    }
}
