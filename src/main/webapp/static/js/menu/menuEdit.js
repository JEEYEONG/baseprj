$(document).ready(function () {
  let authGroup = $('#auth-group').val();

  $('#auth-group').on('change', function() {
    authGroup = $('#auth-group').val();
    console.log(authGroup);
  });
  console.log('authGroup: ' + authGroup);



 /* let authdata = $('#auth').val();
  console.log(authdata)
  $('#auth').on('click', function () {
    authdata = $('#auth').data("auth");
    console.log(authdata)
  })*/

  /*$('#auth-group').on('click', function () {
    var auth = $('#auth-group').val();
    console.log(auth);

    $.ajax({
      type: "post",
      contentType: "application/json; charset=utf-8",
      url: "/authMenu/authGroup", //ajax 통신 url controller로 가는 매핑
      data: JSON.stringify(
          {
            "auth-group": auth,
          }
      ), //전달할 데이터 파라미터 : 값
      data_type: "json", //전달받을 데이터 타입;
      async: true, //비동기화 동작 여부
      success: function (response) {
        console.log("response : " + response)
        if (response == 'root') {
          console.log(response)
        }else if (response == 'admin'){

        } else {
          ;

        }
      }
    })

  });*/


});

function moveToNext() {

  const prev = document.querySelector("#prev");
  const next = document.querySelector("#next");


  console.log("prev")

  next.insertBefore(prev.firstChild, next.firstChild);
  next.appendChild(prev.firstChild);
}
function moveToNextAll() {
  console.log()

  let prev = $('#prev');
  // const prev = document.querySelector("#prev");
  const next = document.querySelector("#next");

  next.insertBefore(prev.firstChild, next.firstChild);
  next.appendChild(prev.firstChild);
}
