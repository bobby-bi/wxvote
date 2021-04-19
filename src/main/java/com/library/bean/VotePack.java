package com.library.bean;

import java.util.Date;

/**
 * @author Bobby
 * @date 2021-04-17
 */
public class VotePack {
    private String title;
    private String text;
    private String[] options;
    private int voteOptionCount;
    private Date endTime;
    private int anonymous;
    private String image;
    private int userid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public int getVoteOptionCount() {
        return voteOptionCount;
    }

    public void setVoteOptionCount(int voteOptionCount) {
        this.voteOptionCount = voteOptionCount;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
