package com.library.dao;

import com.library.bean.Lend;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LendDao {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    private final static String NAMESPACE = "com.library.dao.LendDao.";

    public int returnBookOne(final String book_name, long reader_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("book_name", book_name);
        map.put("reader_id", reader_id);
        return sqlSessionTemplate.update(NAMESPACE + "returnBookOne", map);
    }

    public int returnBookTwo(final String book_name) {
        return sqlSessionTemplate.update(NAMESPACE + "returnBookTwo", book_name);
    }

    public int lendBookOne(final String book_name, final long reader_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("book_name", book_name);
        map.put("reader_id", reader_id);
        return sqlSessionTemplate.insert(NAMESPACE + "lendBookOne", map);
    }

    public int lendBookTwo(final String book_name) {
        return sqlSessionTemplate.update(NAMESPACE + "lendBookTwo", book_name);
    }

    public ArrayList<Lend> lendList() {
        List<Lend> result = sqlSessionTemplate.selectList(NAMESPACE + "lendList");
        return (ArrayList<Lend>) result;
    }

    public ArrayList<Lend> myLendList(final long reader_id) {
        List<Lend> result = sqlSessionTemplate.selectList(NAMESPACE + "myLendList", reader_id);
        return (ArrayList<Lend>) result;
    }

    public int deleteLend(final long ser_num) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteLend", ser_num);
    }
}
