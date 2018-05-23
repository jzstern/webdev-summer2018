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
    var user = new User()
    user.setUsername($username.val())
    user.setPassword($password.val())

    userService
      .login(user.username, user.password)
      .then(checkLogin)
  }

  function checkLogin(user) {
    if (user.username == null && user.password == null) {
      window.location.href = "../profile/profile.template.client.html?" + user.id
    } else {
      alert('Sorry, that username password combination does not exist')
    }
  }
})();