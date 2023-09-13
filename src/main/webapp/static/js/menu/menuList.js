$(document).ready(function () {
  let authGroup = $('#auth-group').val();
  let authMenu = $('#allList').val();

  $('#auth-group').on('change', function () {
    authGroup = $('#auth-group').val();
    console.log(authGroup);
  });
  console.log('authGroup: ' + authGroup);

  $('.menu').on('click', function () {
    authMenu = $(this).data("auth");
    console.log(authMenu);



  });





   $("#save-btn").click(function () {


   });



});

document.addEventListener('DOMContentLoaded',function () {
  let allList = document.querySelectorAll('li');
  console.log(allList);
  allList.forEach(function (authMenu) {
    authMenu.addEventListener('click', function () {
      console.log(authMenu);
      this.style.backgroundColor = "lightsteelblue";
      this.style.width = "400px";


      let authmMenu = document.getElementById('authMenu');//이동할 위치
      authmMenu.appendChild(this);

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
