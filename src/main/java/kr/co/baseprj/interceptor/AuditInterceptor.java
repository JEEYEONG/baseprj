package kr.co.baseprj.interceptor;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import javax.servlet.http.HttpSession;

import kr.co.baseprj.vo.code.GroupCodeVo;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.user.UserVo;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class})
    , @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
    Object.class})
})
public class AuditInterceptor implements Interceptor {

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
    SqlCommandType commandType = mappedStatement.getSqlCommandType();

    // 감사 작업 수행
    if (commandType.equals(SqlCommandType.INSERT)) {
      // INSERT 작업일 경우 감사 작업 수행
      Object parameter = invocation.getArgs()[1];

      if (parameter instanceof MenuSaveVo) {
        processAuditLogging((MenuSaveVo) parameter);
      } else if(parameter instanceof GroupCodeVo) {
        processAuditLogging((GroupCodeVo) parameter);
      } else if(parameter instanceof UserVo) {
        processAuditLogging((UserVo) parameter);
      }
    }

    return invocation.proceed(); // 실제 데이터베이스 작업 수행
  }

  private void processAuditLogging(UserVo userVo) {
    String userId = getUserIdFromSession();
    Date now = Timestamp.valueOf(LocalDateTime.now());

    userVo.setRegrId(userId);
    userVo.setRegDt(now);
  }

  private void processAuditLogging(MenuSaveVo menuSaveVo) {
    // 감사 로그 작성 및 저장

    String userId = getUserIdFromSession();
    Date now = Timestamp.valueOf(LocalDateTime.now());

    menuSaveVo.setRegrId(userId);
    menuSaveVo.setRegDt(now);

  }
  private void processAuditLogging(GroupCodeVo groupCodeVo) {
    // 감사 로그 작성 및 저장

    String userId = getUserIdFromSession();
    Date now = Timestamp.valueOf(LocalDateTime.now());

    groupCodeVo.setRegrId(userId);
    groupCodeVo.setRegDt(now);

  }

  private String getUserIdFromSession() {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    HttpSession session = requestAttributes.getRequest().getSession();
    return (String) session.getAttribute("userId");
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 설정 값 전달 (선택적)
  }
}