$(document).ready(function () {
    $("#add_code_btn").on("click", () => {
        let addCodeRow = $("#add-code-row-template").html();

        $("tbody.text-gray-600").append(addCodeRow);
    });

    $("tbody.text-gray-600").on("click", "#del_input_area", function (event) {
        console.log("동작됨");
        $(event.target).closest("tr").remove();
    });

    $("#del_btn").on("click", function () {
        let cd = $(this).data("cd");
        let groupCd = $(this).data("groupCd");
        let page = $(this).data("page");
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: 'delete/stCd', // 실제 요청할 URL 설정
            data: JSON.stringify({
                "cd": cd,
                "groupCd": groupCd,
            }),
            success: function (response) {
                alert('삭제가 완료되었습니다');

                location.href = `/code/${groupCd}?page=${page}&pageSize=5&groupCd=${groupCd}`
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

    $("#mod_btn").on("click", function (event) {
        let groupCd = $(this).data("groupCd");
        let groupCdNm = $("input[name='groupCdNm']").val();
        let delYn = $("select[name='groupCd_delYn']").val();
        let descrt = $("#groupCd_descrt").val();
        let pageSize = 5;
        let page = $(this).data("page");

        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: `/code/update/groupCd`, // 실제 요청할 URL 설정
            data: JSON.stringify({
                "groupCd": groupCd,
                "groupCdNm": groupCdNm,
                "delYn": delYn,
                "descrt": descrt
            }),
            success: function (response) {
                alert('수정이 완료되었습니다');
                if (response === 'success') {
                    location.href = `/code/${groupCd}?page=${page}&pageSize=5&groupCd=${groupCd}`
                } else if (response === 'delete') {
                    location.href = '/code/codeList';
                }
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

    $("#save_code_btn").on("click", () => {
        let groupCd = $('#groupCd').val();
        let cd = $("input[name='cd']").val();
        let stCdNm = $("input[name='stCdNm']").val();
        let delYn = $("select[name='delYn']").val();
        let descrt = $("#stCd_descrt").val();

        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: `/code/${groupCd}/${encodeURIComponent(cd)}`, // 실제 요청할 URL 설정
            data: JSON.stringify({
                "cd": cd,
                "groupCd": groupCd,
                "stCdNm": stCdNm,
                "delYn": delYn,
                "descrt": descrt,
            }),
            success: function (response) {
                console.log(response);
                location.href = response.referer;
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
