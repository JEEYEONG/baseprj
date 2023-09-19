package kr.co.baseprj.mgmt.userMgmt;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.common.base.BaseController;
import kr.co.baseprj.common.base.PageNavigator;
import kr.co.baseprj.common.utils.UserSessUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController extends BaseController {

  private final UserService userService;

  private final UserDao userDao;
  private HttpServletRequest request;


  /**
   * 회원 등록 페이지로 이동합니다.
   *
   * @return mgmt/user/userDetail
   */
  @GetMapping("/insertUser")
  public String insertUser() {
    return "mgmt/user/userDetail";
  }

  /**
   * user 등록
   *
   * @param userVo
   * @param model
   * @return
   * @throws Exception
   */
  @PostMapping("/insertUser")
  @ResponseBody
  public String insertUser(UserVo userVo, Model model) throws Exception {

    /*ResultVo resultVo = new ResultVo();*/

    /*// Validation Check
    if (result.hasErrors()) {
      resultVo.setResultCode(Constant.BINDING_ERRPR_CODE);
      resultVo.setResultMsg(getErrMsgValidAnnotation(result));

      return resultVo.toString();
    }*/
    try {
      String userId = UserSessUtil.getUserId(request);
      userVo.setRegrId(userId);
      /*currentUser = UserSessUtil.getUserId(getRequest());*/

      userService.insertUser(userVo);

      System.out.println("userVo = " + userVo);


    } catch (IllegalAccessError e) {
      model.addAttribute("errorMessage", "등록 중 에러가 발생하였습니다.");
      return "mgmt/user/userDetail";
    }
    return "redirect:/";
  }


/*
/** 아이디 중복 검사
  @ResponseBody
  @PostMapping("/idCheck")
  public String idCheck(@RequestBody UserVo userVo) {
    String checkId = "N";
    int result = userService.checkId(userVo.getUserId());
    if (result == 1) {
      checkId = "Y"; //아이디가 있으면 Y
    }
    return checkId;
  }
  */


  /**
   * user 목록 조회
   * @param model
   * @param page
   * @param userVo
   * @return
   * @throws Exception
   */
  @GetMapping("/userList")
  public String userList(Model model, PageNavigator page, UserVo userVo) throws Exception {
    page = makePageNavigator();

    List<UserVo> userLists = userService.userLists(userVo);

     /*List<UserVo> userList = userService.userList(userVo, page);*/
    page.setTotalSize(userService.userListCount(userVo, page));
    System.out.println(page.getTotalSize());

    model.addAttribute("userLists", userLists);
    /*model.addAttribute("userList", userList);*/
    model.addAttribute("s", userVo);
    model.addAttribute("p", page);

    return "mgmt/user/userList";
  }

/*
  //  회원 상세보기
  @GetMapping(value = {"/userDetail/{userId}", "/userDetail"})
  public String userDetail(Model model, @PathVariable("userId") String userId) {
    UserVo userVo = userService.getUserDtl(userId);
    model.addAttribute("userDtl", userVo);

    return "user/userDetail";
  }

  // 회원 삭제 근데 db는 남아있는
  @GetMapping("/delete/{userId}")
  public String deleteUser(@PathVariable("userId") String userId, Model model, SearchCondition sc) {
    userService.userDelete(userId);
    List<UserVo> userLists = userService.userList(sc);
    model.addAttribute("userLists", userLists);

    return "user/userList";
  }

  // 회원 수정 페이지 이동
  @GetMapping("/mod/{userId}")
  public String modUser(@PathVariable("userId") String userId, Model model) {
    UserVo userVo = userService.getUserDtl(userId);
    model.addAttribute("userDtl", userVo);

    return "user/userMod";
  }

  // 수정 버튼 클릭시 작동
  @PostMapping("/mod/{userId}")
  public String modUser(UserVo userVo, Model model, SearchCondition sc,
      @SessionAttribute(name = "currentUser", required = false) String currentUser) {
    userService.updateUser(userVo, currentUser);
    List<UserVo> userLists = userService.userList(sc);

    int totalCnt = userService.getResultCnt();
    PageHandler ph = new PageHandler(totalCnt, sc);

    model.addAttribute("userLists", userLists);
    model.addAttribute("page", ph);
    return "user/userList";
  }

  */

}
