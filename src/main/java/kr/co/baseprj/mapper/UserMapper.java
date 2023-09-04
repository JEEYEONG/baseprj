package kr.co.baseprj.mapper;

import java.util.Optional;
import kr.co.baseprj.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void saveUser(UserVo userVo);

    public List<UserVo> getUserList();

    Optional<UserVo> findByUserId(String userId);


    void deleteUser(String userId);

    void updateUser(UserVo userVo);
}
