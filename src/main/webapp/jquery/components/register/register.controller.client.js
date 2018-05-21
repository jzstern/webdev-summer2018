(function () {

  jQuery(main);

  var userService = new UserServiceClient();
  var username, password, verifyPassword;

  function main() {
    template = $('.template');
    $('#register-button').click(register);
  }

  function register() {
    // TODO ; prevent adding blank users

    username = $('#usernameFld').val();
    password = $('#passwordFld').val();
    verifyPassword = $('#verifyPasswordFld').val();

    if (password == verifyPassword) {
      var user = {
        username: username,
        password: password
      };

      userService
        .register(user)
        .then(function() {
          // TODO ; navigate to
        });
    }
  }
});