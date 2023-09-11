$(document).ready(function () {
  let authGroup = $('#auth-group').val();

  $('#auth-group').on('change', function() {
    authGroup = $('#auth-group').val();
    console.log(authGroup);
  });
  console.log('authGroup: ' + authGroup);

  let authdata = $
  // let authdata = $('#auth').val();
  console.log(authdata)
  $('#auth').on('click', function () {
    authdata = $('#auth').data("auth");
    console.log(authdata)
  })

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
  const prev = document.querySelector("#prev");
  const next = document.querySelector("#next");

  next.insertBefore(prev.firstChild, next.firstChild);
  next.appendChild(prev.firstChild);
}
