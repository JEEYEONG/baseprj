package kr.co.baseprj.mapper;

import java.util.List;
import java.util.Optional;
import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  void saveUser(UserVo userVo);

  public List<UserVo> getUserList(SearchCondition sc);

  Optional<UserVo> findByUserId(String userId);


  void deleteUser(String userId);

  void updateUser(UserVo userVo);

  int findUserCnt();

  int checkId(String userId);
}
