$(document).ready(function () {
  $("#save_btn").click(function () {
    let groupCd = $("#groupCd").val();
    let groupCdNm = $("#groupCdNm").val();
    let displYn = $("#displYn").val();
    let descrt = $("#descrt").val();

    $.ajax({
      type: "post",
      contentType: "application/json; charset=utf-8",
      url: "/code/save", // 실제 요청할 URL 설정
      data: JSON.stringify({
        groupCd: groupCd,
        groupCdNm: groupCdNm,
        displYn: displYn,
        descrt: descrt,
      }),
      success: function (response) {
        location.href = "/code/codeList";
        return "success";
      },
      error: function (xhr, textStatus, errorThrown) {
        console.log(xhr);
        let responseJson = xhr.responseJSON;

        if (responseJson.code) {
          alert(responseJson.message);
        }
      },
    });
  });
});
