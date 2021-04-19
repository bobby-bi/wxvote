package com.library.controller;
import com.library.bean.*;
import com.library.service.UserService;
import com.library.service.VoteService;
import com.library.service.VoteoptionService;
import com.library.util.AesCbcUtil;
import com.library.util.HttpRequest;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class VoteController {
    @Autowired
    private VoteService voteService;
    @Autowired
    private UserService userService;
    @Autowired
    private VoteoptionService voteoptionService;

    @ResponseBody
    @RequestMapping(value = "/get_vote_list", method = RequestMethod.GET)
    public List getVoteList() {
        List<Vote> allVote = voteService.getAllVote();
        List<UserVote> userVotes = voteService.getUserVotes(allVote);
        return userVotes;
    }
    @ResponseBody
    @RequestMapping(value = "/endvote", method = RequestMethod.GET)
    public void endVote(int id) {
        voteService.setEnd(id);
    }
    @ResponseBody
    @RequestMapping(value = "/get_vote_detail", method = RequestMethod.GET)
    public List getVoteDetail(int id) {
        List list=new ArrayList();
        List<Vote> allVoteById = voteService.getAllVoteById(id);
        List<UserVote> userVotes = voteService.getUserVotes(allVoteById);
        list.add(userVotes);
        List<OptionInfo> optionInfo = voteoptionService.getOptionInfo(id);
        list.add(optionInfo);
        List<Integer> userIds = userService.getIdByVoteId(id);
        List<User> users=new ArrayList<>();
        for(int userid:userIds){
            User user = userService.getUserById(userid);
            users.add(user);
        }
        list.add(users);
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "/addoption", method = RequestMethod.GET)
    public List addoption(String option,int userid,int voteid) {
        String s = option.replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("\"", "");
        String[] split = s.split(",");
        for(String i:split){
            voteoptionService.addSelect(voteid,userid,Integer.parseInt(i));
        }
        List list=new ArrayList();
        List<Vote> allVoteById = voteService.getAllVoteById(voteid);
        List<UserVote> userVotes = voteService.getUserVotes(allVoteById);
        list.add(userVotes);
        List<OptionInfo> optionInfo = voteoptionService.getOptionInfo(voteid);
        list.add(optionInfo);
        List<Integer> userIds = userService.getIdByVoteId(voteid);
        List<User> users=new ArrayList<>();
        for(int i:userIds){
            User user = userService.getUserById(i);
            users.add(user);
        }
        list.add(users);
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "/get_optiondetail", method = RequestMethod.GET)
    public List getOptiondetail(int id) {
        List list=new ArrayList();
        List<OptionInfo> optionInfo = voteoptionService.getOptionInfo(id);
        for(OptionInfo o:optionInfo){
            List list1=new ArrayList();
            list1.add(o);
            List<Integer> idByVoteId = userService.getIdByOptionId(o.getId());
            List list2=new ArrayList();
            for(int i:idByVoteId){
                list2.add(userService.getUserById(i));
            }
            list1.add(list2);
            list.add(list1);
        }
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "/wx_vote_save", method = RequestMethod.GET)
    public void wxVoteSave( @RequestParam("votePack") String json) {
        String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        Map<String, Class> classMap = new HashMap<String, Class>();
        Object o = JSONObject.toBean(JSONObject.fromObject(json), VotePack.class,classMap);
        VotePack votePack=(VotePack)o;
        Vote vote=new Vote();
        vote.setEnd(1);
        vote.setEndtime(votePack.getEndTime());
        vote.setImage(votePack.getImage());
        vote.setIsanonymous(votePack.getAnonymous());
        vote.setStarttime(new Date());
        vote.setTitle(votePack.getTitle());
        vote.setVotedesc(votePack.getText());
        vote.setVshow(2);
        vote.setUserid(votePack.getUserid());
        vote.setVotetype(votePack.getVoteOptionCount());
        voteService.addVote(vote);
        int maxId = voteService.maxId();
        String[] options = votePack.getOptions();
        for(String option:options){
            Voteoption voteoption=new Voteoption();
            voteoption.setVdesc(option);
            voteoption.setVoteid(maxId);
            voteoptionService.addOption(voteoption);
        }
    }
    @ResponseBody
    @RequestMapping(value = "/get_vote_list_own", method = RequestMethod.GET)
    public List getVoteListOwn(int id) {
        List<Vote> voteByUserId = voteService.getVoteByUserId(id);
        List<UserVote> userVotes = voteService.getUserVotes(voteByUserId);
        return userVotes;
    }
    @ResponseBody
    @RequestMapping(value = "/get_vote_list_join", method = RequestMethod.GET)
    public List getVoteListJoin(int id) {
        List<Integer> joinVoteIdByUserId = voteService.getJoinVoteIdByUserId(id);
        Set<Integer> set=new HashSet<>(joinVoteIdByUserId);
        List<Vote> list =new ArrayList<>();
        for(int i:set){
            Vote voteById = voteService.getVoteById(i);
            list.add(voteById);
        }
        List<UserVote> userVotes = voteService.getUserVotes(list);
        return userVotes;
    }
    @ResponseBody
    @RequestMapping(value = "/deletevote", method = RequestMethod.GET)
    public void deleteVote(int id) {
        voteService.deleteVoteById(id);
        voteoptionService.deleteVoteOptionByVoteId(id);
        voteoptionService.deleteSelectByVoteId(id);
    }
}