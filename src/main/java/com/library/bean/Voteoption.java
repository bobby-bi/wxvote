package com.library.bean;

/**
 * @author Bobby
 * @date 2021-04-16
 */
public class Voteoption {
    private int id;
    private String vdesc;
    private int voteid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVdesc() {
        return vdesc;
    }

    public void setVdesc(String vdesc) {
        this.vdesc = vdesc;
    }

    public int getVoteid() {
        return voteid;
    }

    public void setVoteid(int voteid) {
        this.voteid = voteid;
    }
}
