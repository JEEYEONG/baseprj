package kr.co.baseprj.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private static final String NAME_SPACE = "kr.co.baseprj.dao.userDao";

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

}
