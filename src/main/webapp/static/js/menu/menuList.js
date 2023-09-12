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
