package kr.co.baseprj.sample;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleDao {

    private static final String NAME_SPACE = "kr.co.baseprj.sample.SampleDao.";

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession sqlSession;

    /**
     * Sample List
     *
     * @return
     */
    public List<SampleVO> getSampleList() {
        SampleVO paramVO = new SampleVO();
        return sqlSession.selectList(NAME_SPACE + "selectSampleList", paramVO);
    }

}
