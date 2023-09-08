$(document).ready(function () {
  let idCheck = false;

  $("#id-check").click(function () {
    var checkId = $("#userId").val();
    var msg = $("#msg");

    console.log(checkId);

    if (checkId == "") {
      console.log("아이디 없음")
      alert("아이디를 입력해주세요.")
      return;
    } else {
      $.ajax({
        type: "post",
        contentType: "application/json; charset=utf-8",
        url: "/idCheck", //ajax 통신 url controller로 가는 매핑
        data: JSON.stringify(
            {
              "userId": checkId
            }
        ), //전달할 데이터 파라미터 : 값
        data_type: "json", //전달받을 데이터 타입;
        async: true, //비동기화 동작 여부
        success: function (response) {
          console.log("response : " + response)
          if (response == 'Y') {
            msg.html("아이디가 이미 존재합니다.");
          } else {
            idCheck = true;
            msg.html("사용 가능한 아이디입니다.");
          }
        }
      })
    }
  });

});
var form = document.joinForm;

function isUserValidate() {
  console.log('userId' + form.userId.value);

  if (!form.userId.value) {
    alert("아이디를 입력하세요.")
    form.userId.focus();
    return false;
  }
  if (!form.userNm.value) {
    alert("이름을 입력해주세요.");
    form.userNm.focus();
    return false;
  }
  if (!form.secretNum.value) {
    alert("비밀번호를 입력해주세요.");
    form.secretNum.focus();
    return false;
  }
  return true;
}