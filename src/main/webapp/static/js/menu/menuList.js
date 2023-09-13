$(document).ready(function () {
  let authGroup = $('#auth-group').val();
  let authMenu

  $('#auth-group').on('change', function () {
    authGroup = $('#auth-group').val();
    console.log(authGroup);
  });
  console.log('authGroup: ' + authGroup);

  $('.menu').on('click', function () {
    authMenu = $(this).data("menu");
    console.log(authMenu);

  });

  $("#save-btn").click(function () {
    console.log(authMenu);
    let menuCd = authMenu;
    console.log(menuCd);
    let authGroupCd = $('#auth-group').val();
    console.log("menucd, auth : "+ menuCd, authGroupCd);

    $.ajax({
      type: "post",
      contentType: "application/json; charset=utf-8",
      url: "/authMenu/save", // 실제 요청할 URL 설정
      data: JSON.stringify({
        menuCd: menuCd,
        authGroupCd: authGroupCd,
      }),
      success: function (response) {
        if(response === "success") {
          alert('메뉴 등록을 완료했습니다.');
          location.href = "/authMenu/list";
        }
      },
    })


  });

});

document.addEventListener('DOMContentLoaded', function () {
  let allList = document.querySelectorAll('li');
  console.log(allList); //모든 li 요소 가져옴

  allList.forEach(function (authMenu) { //각 li 요소에 클릭 이벤트 추가
    authMenu.addEventListener('click', function () {
      console.log(authMenu);
      this.style.backgroundColor = "lightsteelblue"; //배경색 변경

      let authmMenu = document.getElementById('authMenu');//이동할 위치
      authmMenu.appendChild(this);//클릭한 li 요소 이동


    });

  });
});



function moveToNext() {

  let allList = document.getElementById("allList");
  let authMenu = document.getElementById("authMenu");

  console.log("authMenu에 추가");

  authMenu.appendChild(allList);
}

function moveToNextAll() {
  let allList = document.getElementById("allList");
  let authMenu = document.getElementById("authMenu");

  console.log("authMenu에 추가");

  authMenu.appendChild(allList);
}
