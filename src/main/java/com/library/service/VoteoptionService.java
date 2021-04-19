package com.library.service;

import com.library.bean.OptionInfo;
import com.library.bean.Voteoption;
import com.library.dao.VoteDao;
import com.library.dao.VoteoptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteoptionService {
    @Autowired
    private VoteoptionDao voteoptionDao;

    public List<OptionInfo> getOptionInfo(int voteid){
        List<Voteoption> optionByVoteId = voteoptionDao.getOptionByVoteId(voteid);
        List<OptionInfo> optionInfos=new ArrayList<>();
        for(Voteoption voteoption: optionByVoteId){
            OptionInfo optionInfo = new OptionInfo();
            optionInfo.setId(voteoption.getId());
            optionInfo.setVdesc(voteoption.getVdesc());
            optionInfo.setVoteid(voteoption.getVoteid());
            optionInfo.setSum(voteoptionDao.matchOptionIdCount(voteoption.getId()));
            optionInfos.add(optionInfo);
        }
        return optionInfos;
    }
    public boolean addSelect(int voteid,int userid,int optionid){
       return  voteoptionDao.addSelect(voteid,userid,optionid)>0;
    }
    public void addOption(Voteoption voteoption){
          voteoptionDao.addOption(voteoption);
    }
    public void deleteVoteOptionByVoteId(int id) {
        voteoptionDao.deleteVoteOptionByVoteId(id);
    }
    public void deleteSelectByVoteId(int id) {
        voteoptionDao.deleteSelectByVoteId(id);
    }
}
