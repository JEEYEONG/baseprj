package kr.co.baseprj.service;

import kr.co.baseprj.mapper.UserMapper;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserMapper userMapper;

    SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    public void joinUser(UserVo userVo) {
        userVo.setUserId(userVo.getUserId());
        userVo.setUserNm(userVo.getUserNm());
        userVo.setAuthGroupCd(userVo.getAuthGroupCd());
        userVo.setSecretNum(userVo.getSecretNum());
        userVo.setRegDt(LocalDateTime.now());
        userVo.setModDt(LocalDateTime.now());
        userVo.setRegrId(userVo.getRegrId());
        userVo.setModrId(userVo.getModrId());
        userVo.setDelYn(userVo.getDelYn());
        userVo.setUserDiv(userVo.getUserDiv());

        userMapper.saveUser(userVo);
    }

    public List<UserVo> userList(){
        List<UserVo> userList = userMapper.getUserList();
        return userList;
    }

}
