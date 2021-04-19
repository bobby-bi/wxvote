package com.library.service;

import com.library.dao.ClassDao;
import com.library.dao.SelectdetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectdetailService {
    @Autowired
    private SelectdetailDao selectdetailDao;


}
