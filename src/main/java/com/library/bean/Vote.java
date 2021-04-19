package com.library.bean;

import java.util.Date;

/**
 * @author Bobby
 * @date 2021-04-16
 */
public class Vote {
    private int id;
    private String title;
    private String votedesc;
    private int votetype;
    private Date starttime;
    private Date endtime;
    private int isanonymous;
    private String image;
    private int userid;
    private int end;
    private int vshow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVotedesc() {
        return votedesc;
    }

    public void setVotedesc(String votedesc) {
        this.votedesc = votedesc;
    }

    public int getVotetype() {
        return votetype;
    }

    public void setVotetype(int votetype) {
        this.votetype = votetype;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getIsanonymous() {
        return isanonymous;
    }

    public void setIsanonymous(int isanonymous) {
        this.isanonymous = isanonymous;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getVshow() {
        return vshow;
    }

    public void setVshow(int vshow) {
        this.vshow = vshow;
    }
}
