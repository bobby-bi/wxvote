package com.library.service;

import com.library.bean.Lend;
import com.library.dao.LendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LendService {
    @Autowired
    private LendDao lendDao;

    public boolean returnBook(String bookName, long readerId){
        return lendDao.returnBookOne(bookName, readerId)>0 && lendDao.returnBookTwo(bookName)>0;
    }

    public boolean lendBook(String bookName,long readerId){
        return lendDao.lendBookOne(bookName,readerId)>0 && lendDao.lendBookTwo(bookName)>0;
    }

    public ArrayList<Lend> lendList(){
        return lendDao.lendList();
    }
    public ArrayList<Lend> myLendList(long readerId){
        return lendDao.myLendList(readerId);
    }

    public int deleteLend(long serNum) {
        return lendDao.deleteLend(serNum);
    }

}
