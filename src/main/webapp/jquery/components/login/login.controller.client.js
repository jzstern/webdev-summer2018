(function () {

  jQuery(main);

  var userService = new UserServiceClient();
  var $username, $password, $loginBtn;

  function main() {
    $username = $('#usernameFld').val();
    $password = $('#passwordFld').val();
    $loginBtn = $('#login-button').click(login);
  }

  function login() {

    if (!$username || !$password) {
      alert('Please enter values for both username and password');
    }

    var user = new User();
    user.setUsername($username);
    user.setPassword($password);

    console.log('TRYNA LOGIN HERE');

    userService
      .login(user)
      .then(checkLogin);
  }

  function checkLogin(user) {
    if (user) {
      window.location.href = "../profile/profile.template.client.html?" + user.id;
    } else {
      alert('Sorry, that username password combination does not exist');
    }
  }
});