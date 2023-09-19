package kr.co.baseprj.mgmt.userMgmt;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

    private static final String NAME_SPACE = "kr.co.baseprj.mgmt.userMgmt.UserDao.";

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;


    /**
     * user 등록
     * @param userVo
     * @return
     */
    public int saveUser(UserVo userVo) {
        return sqlSession.insert(NAME_SPACE + "saveUser", userVo);
    }


    /**
     * 유저 아이디로 유저 한 명을 조회한다.
     *
     * @author : sebin
     * @param userId : 유저 아이디
     * @return : UserVo
     */
    public UserVo findUserByUserId(String userId) {
        return sqlSession.selectOne(NAME_SPACE + "findUserById", userId);
    }

    /**
     * user 목록 조회
     * @param paramMap
     * @return
     */
    public List<UserVo> userList(HashMap<String, Object> paramMap) {
        return sqlSession.selectList(NAME_SPACE + "userList", paramMap);
    }

    /**
     * user 총 개수 조회
     * @param paramMap
     * @return
     */
    public int userListCount(HashMap<String, Object> paramMap) {
        return sqlSession.selectOne(NAME_SPACE + "userListCount", paramMap);
    }

    /**
     * 테스트용
     * @param userVo
     * @return
     */
    public List<UserVo> userLists(UserVo userVo) {
        return sqlSession.selectList(NAME_SPACE + "userLists", userVo);
    }
}
