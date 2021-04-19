package com.library.service;

import com.library.bean.Book;
import com.library.dao.BookDao;
import com.library.dao.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassService {
    @Autowired
    private ClassDao classDao;

    public String getClass(int class_id) {
        return classDao.getClass(class_id);
    }
}
