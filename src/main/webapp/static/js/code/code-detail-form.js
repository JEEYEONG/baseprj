$(document).ready(function () {
  $("#add_code_btn").on("click", () => {
    let addCodeRow = $("#add-code-row-template").html();

    $("tbody.text-gray-600").append(addCodeRow);
  });

  $("#save_code_btn").on("click", () => {
    let cd = $("input[name='cd']").val();
    let stCdNm = $("input[name='stCdNm']").val();
    let displYn = $("input[name='displYn']").val();

    $.ajax({
      type: "post",
      contentType: "application/json; charset=utf-8",
      url: "/", // 실제 요청할 URL 설정
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
