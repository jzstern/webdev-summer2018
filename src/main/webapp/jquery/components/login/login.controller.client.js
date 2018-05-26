(function () {

  var userService = new UserServiceClient()
  var $username, $password, $loginBtn
	$(main);

  function main() {
	  $username = $("#usernameFld")
	  $password = $("#passwordFld")
    $loginBtn = $("#login-button").click(login)
  }

  function login() {
	  $username = $("#usernameFld").val()
	  $password = $("#passwordFld").val()

    var user = {
      username: $username,
      password: $password
    }

    userService
      .login(user)
      .then(checkLogin)
  }

  function checkLogin(users) {
    var user = users[0]

    if (user.username === null && user.password === null) {
      alert('Sorry, that username password combination does not exist')
    } else {
      window.location.href = "../profile/profile.template.client.html?" + user.id
    }
  }
})();