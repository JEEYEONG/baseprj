package kr.co.baseprj.mgmt.codemgmt;

import java.util.List;
import java.util.Map;
import kr.co.soundtag.admin.system.codemgmt.vo.CodeVO;
import kr.co.soundtag.admin.system.codemgmt.vo.GroupCodeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CodeMgmtDao {

    private static final String NAME_SPACE = "kr.co.soundtag.admin.system.codemgmt.CodeMgmtDao.";

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    /**
     * 그룹 코드 List
     *
     * @return
     */
    public List<GroupCodeVO> selectGroupCodeList(Map<String, Object> param) {
        return sqlSession.selectList(NAME_SPACE + "selectGroupCodeList", param);
    }

    /**
     * 그룹 코드 목록 총 갯수
     * @param param
     * @return
     */
    public int selectGroupCodeCount(Map<String, Object> param) {
        return sqlSession.selectOne(NAME_SPACE + "selectGroupCodeCount", param);
    }

    /**
     * 그룹 코드 상세 조회
     * @param param
     * @return
     */
    public GroupCodeVO selectGroupCode(GroupCodeVO param) {
        return sqlSession.selectOne(NAME_SPACE + "selectGroupCode", param);
    }

    /**
     * 그룹 코드 등록
     * @param param
     * @return
     */
    public int insertGroupCode(GroupCodeVO param) {
        return sqlSession.insert(NAME_SPACE + "insertGroupCode", param);
    }

    /**
     * 그룹 코드 수정
     * @param param
     * @return
     */
    public int updateGroupCode(GroupCodeVO param) {
        return sqlSession.update(NAME_SPACE + "updateGroupCode", param);
    }

    /**
     * 그룹 코드 삭제
     * @param param
     * @return
     */
    public int deleteGroupCode(GroupCodeVO param) {
        return sqlSession.update(NAME_SPACE + "deleteGroupCode", param);
    }

    /**
     * 코드 List
     *
     * @return
     */
    public List<CodeVO> selectCodeList(GroupCodeVO param) {
        return sqlSession.selectList(NAME_SPACE + "selectCodeList", param);
    }

    /**
     * 코드 등록
     * @param param
     * @return
     */
    public int insertCode(List<CodeVO> param) {
        return sqlSession.insert(NAME_SPACE + "insertCode", param);
    }

    /**
     * 코드 삭제
     * @param param
     * @return
     */
    public int deleteCode(CodeVO param) {
        return sqlSession.update(NAME_SPACE + "deleteCode", param);
    }

    /**selectCode
     * 코드
     *
     *
     *
     *
     * @return
     */
    public CodeVO selectCode(CodeVO param) {
        return sqlSession.selectOne(NAME_SPACE + "selectCode", param);
    }

}
