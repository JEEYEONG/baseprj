$(document).ready(function () {
  $('#topMenuForm').on('submit', function (event) {
    event.preventDefault();

    isValidateForm(function (isValid) {
      if (isValid) {
        $('#topMenuForm')[0].submit(); // DOM 요소로부터 직접 submit() 메서드 호출
      }
    });
  });


  $('#sub_menu_div').on('click', '#del_input_area', function () {
    console.log("동작됨");
    $(event.target).closest("#new_input_area").remove();
  });

  $('#save_sub_btn').on('click', function () {
    let isExist = isAlreadyExist();

    if(isExist) {
      $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
          "parentMenuCd" : $('#topMenuCd').val(),
          "subMenuNm" : $('#subMenuNm').val(),
          "subLinkUrl" : $('#subLinkUrl').val(),
          "subDisplYn" : $('#subDisplYn').val()
        }),
        url: "/menu/save/subMenu",
        success: function (response) {

        },
        error: function (xhr, textStatus, errorThrown) {
          console.log(xhr);
          let response = JSON.parse(xhr.responseText);
          alert(response.message);
          $(`#${response.target}`).focus();
        },
      });
    } else {
      return;
    }
  });

  $('#add_menu_btn').on('click', function () {

    let isExist = isAlreadyExist();

    if (isExist) {

    } else {
      let addCodeRow = $("#add-code-row-template").html();
      $('#sub_menu_div').append(addCodeRow);
    }

  });

});

function isAlreadyExist() {
  let newInput = $('#new_input_area').length;

  if (newInput > 0) {
    return true;
  } else {
    return false
  }
}

function getMenu(menuCd) {
  $.ajax({
    type: "GET",
    contentType: "application/json; charset=utf-8",
    url: '/menu/menu/' + menuCd, // 실제 요청할 URL 설정
    success: function (response) {
      const menuVo = response.menuVo;
      const subMenuList = response.submenuList;

      $('#topMenuCd').val(menuVo.menuCd);
      $('#topMenuNm').val(menuVo.menuNm);
      $('#topLinkUrl').val(menuVo.linkUrl);
      $('#topDisplYn').val(menuVo.displYn);

      if(subMenuList) {

        $.each(subMenuList, function(index, value) {
          const template = $('.submenuTemplate').clone();

          console.log(template);

          template.removeClass("submenuTemplate");
          template.find("input").attr("id", "pageName" + value.menuCd);
          template.find("button").attr("data-menuCd", value.menuCd);

          template.appendTo("#sub_menu_div");
        });
      }
    },
    error: function (xhr, textStatus, errorThrown) {
      let response = JSON.parse(xhr.responseText);
      alert(response.message);
      $(`#${response.target}`).focus();
    },
  });

}

function isValidateForm(callback) {
  let topMenuCd = $('#topMenuCd').val();
  let topMenuNm = $('#topMenuNm').val();
  let topLinkUrl = $('#topLinkUrl').val();
  let topDisplYn = $('#topDisplYn').val();

  $.ajax({
    type: "POST",
    contentType: "application/json; charset=utf-8",
    url: '/menu/isValidate', // 실제 요청할 URL 설정
    data: JSON.stringify({
      "topMenuCd": topMenuCd,
      "topMenuNm": topMenuNm,
      "topDisplYn": topDisplYn,
      "topLinkUrl": topLinkUrl
    }),
    success: function (response) {
      callback(true); // 유효성 검사 성공 시 true를 콜백으로 전달
    },
    error: function (xhr, textStatus, errorThrown) {
      let response = JSON.parse(xhr.responseText);
      alert(response.message);
      $(`#${response.target}`).focus();
      callback(false); // 유효성 검사 실패 시 false를 콜백으로 전달
    },
  });
}