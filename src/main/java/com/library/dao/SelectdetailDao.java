package com.library.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SelectdetailDao {

    private final static String NAMESPACE = "com.library.dao.SelectdetailDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public String getClass(final int class_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getClass", class_id);
    }

}
