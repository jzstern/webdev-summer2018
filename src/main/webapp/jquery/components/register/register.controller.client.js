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

    if (password != verifyPassword) {
      alert('Passwords must match');
    }
    else if (username == "") {
      alert('Username cannot be blank')
    }
    else if (password == "") {
      alert('Password cannot be blank')
    }
    else {
      var user = {
        username: username,
        password: password
      };

      userService
        .register(user)
        .then(function(registeredUser) {
          console.log(registeredUser);
          var url = "http://localhost:8080/jquery/components/profile/profile.template.client.html?" + registeredUser.userId;
          window.location = url;
        });
    }
  }
});