$(document).ready(function () {
  $("#menu_add").click(function () {
    let menuCd = $("#menuCd").val();
    let menuNm = $("#menuNm").val();
    let linkUrl = $("#linkUrl").val();
    let displYn = $("#displYn").val();

    if (!validateInput(menuCd, /^[A-Za-z]{1,9}$/, "메뉴 코드는 영문 9자 이내로 입력해주세요.") ||
        !validateInput(menuNm, /^[가-힣]{3,}$/, "메뉴 명은 한글 3자 이상이어야 합니다.") ||
        !validateInput(linkUrl, /^[A-Za-z]{1,5}$/, "대표 URL은 영문 5자 이내로 입력해주세요.")) {
      return; // 중단
    }

    $.ajax({
      type: "POST",
      contentType: 'application/json; charset=utf-8',
      url: "/menu/save/" + menuCd, // 실제 요청할 URL 설정
      data: JSON.stringify({
        "menuCd": menuCd,
        "menuNm": menuNm,
        "linkUrl": linkUrl,
        "displYn": displYn,
      }),
      success: function (response) {

      },
      error: function (xhr, textStatus, errorThrown) {
        let responseJson = xhr.responseJSON;

        if (responseJson.code) {
          alert(responseJson.message);
        }
      }
    });
  });

// 입력 값 검증 함수
  function validateInput(input, regex, errorMessage) {
    if (input.length === 0) {
      alert(errorMessage.replace("을", "를")); // "을"을 "를"로 변경하여 알림 표시
      return false;
    } else if (!regex.test(input)) {
      alert(errorMessage);
      return false;
    }
    return true;
  }
});
