package com.library.service;

import com.library.bean.User;
import com.library.bean.UserVote;
import com.library.bean.Vote;
import com.library.dao.UserDao;
import com.library.dao.VoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {
    @Autowired
    private VoteDao voteDao;
    @Autowired
    private UserService userService;
    public List<Vote> getAllVote() {
        return voteDao.getAllVote();
    }
    public boolean setEnd(int id) {
        return voteDao.setEnd(id)>0;
    }
    public List<UserVote> getUserVotes(List<Vote> allVote){
        List<UserVote> allUserVote = new ArrayList<>();
        for(Vote vote:allVote){
            User userById = userService.getUserById(vote.getUserid());
            UserVote userVote=new UserVote();
            userVote.setEnd(vote.getEnd());
            userVote.setEndtime(vote.getEndtime());
            userVote.setId(vote.getId());
            userVote.setImage(vote.getImage());
            userVote.setIsanonymous(vote.getIsanonymous());
            userVote.setLogo(userById.getImage());
            userVote.setName(userById.getName());
            userVote.setStarttime(vote.getStarttime());
            userVote.setTitle(vote.getTitle());
            userVote.setVotedesc(vote.getVotedesc());
            userVote.setVotetype(vote.getVotetype());
            userVote.setVshow(vote.getVshow());
            userVote.setGender(userById.getGender());
            allUserVote.add(userVote);
        }
        return allUserVote;
    }
    public List<Vote> getAllVoteById(int id) {
        return voteDao.getAllVoteById(id);
    }
    public void addVote(Vote vote){
        voteDao.addVote(vote);
    }
    public int maxId(){
        return voteDao.maxId();
    }
    public List<Vote> getVoteByUserId(int id) {
        return voteDao.getVoteByUserId(id);
    }
    public List<Integer> getJoinVoteIdByUserId(int id) {
        return voteDao.getJoinVoteIdByUserId(id);
    }
    public Vote getVoteById(int id) {
        return voteDao.getVoteById(id);
    }
    public void deleteVoteById(int id) {
        voteDao.deleteVoteById(id);
    }
}
