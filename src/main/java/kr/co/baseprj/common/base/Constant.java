package kr.co.baseprj.common.base;

public class Constant {

	//결과, 오류 코드
	public static final String SUCCESS_CODE = "0000";
	public static final String BINDING_ERRPR_CODE = "1000";
	public static final String DUPLICATION_CODE = "2000";
	public static final String TRANSACTION_FAIL = "9000";
	public static final String SYSTEM_ERROR_CODE = "9999";

	public static final String SUCCESS_CODE_MSG = "정상 처리 되었습니다.";
	public static final String BINDING_ERRPR_CODE_MSG = "";
	public static final String DUPLICATION_CODE_MSG = "중복된 데이터가 있습니다.";
	public static final String TRANSACTION_FAIL_MSG = "저장이 정상적으로 이뤄지지 않았습니다.";
	public static final String SYSTEM_ERROR_CODE_MSG = "알 수 없는 시스템 오류입니다.";

	//세션
	public static final String SESS_MNGR = "mngrInfo";
	public static final String SESS_MNGR_ID = "mngrId";
	public static final String SESS_MNGR_NAME = "mngrName";
	public static final String SESS_MNGR_TYPE = "mngrType";
	public static final String SESS_USER_ID = "userId";

	//BASE END DATE
	public static final String BASE_END_DATE = "99991231";

	// 배치 상태 코드 - 시작
	public static final String BATCH_START = "S";
	// 배치 상태 코드 - 완료
	public static final String BATCH_COMMPLE = "C";
	// 배치 상태 코드 - 실패
	public static final String BATCH_FAIL = "F";

}
