package com.library.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ClassDao {

    private final static String NAMESPACE = "com.library.dao.ClassDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public String getClass(final int class_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getClass", class_id);
    }

}
