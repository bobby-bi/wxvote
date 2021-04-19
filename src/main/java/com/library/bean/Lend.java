package com.library.bean;

import java.io.Serializable;
import java.util.Date;

public class Lend implements Serializable {

    private long ser_num;
    private String book_name;
    private long reader_id;
    private Date lend_date;
    private Date back_date;

    public long getReaderId() {
        return reader_id;
    }

    public void setReaderId(long reader_id) {
        this.reader_id = reader_id;
    }

    public String getBookName() {
        return book_name;
    }

    public void setBookName(String book_name) {
        this.book_name = book_name;
    }

    public void setSer_num(long ser_num) {
        this.ser_num = ser_num;
    }

    public Date getBackDate() {
        return back_date;
    }

    public void setBackDate(Date back_date) {
        this.back_date = back_date;
    }

    public Date getLendDate() {
        return lend_date;
    }

    public void setLendDate(Date lend_date) {
        this.lend_date = lend_date;
    }

    public long getSer_num() {
        return ser_num;
    }
}
