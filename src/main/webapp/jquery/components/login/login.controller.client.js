(function () {

  jQuery(main);

  var userService = new UserServiceClient();
  var username, password;

  function main() {
    template = $('.template');
    $('#login-button').click(login);
  }

  function login() {
    // TODO ; incorrect username/password

    username = $('#usernameFld').val();
    password = $('#passwordFld').val();

    var user = {
      username: username,
      password: password
    };

    userService
      .login(user)
      .then(function() {
        // TODO ; redirect to profile page
      });
  }
});