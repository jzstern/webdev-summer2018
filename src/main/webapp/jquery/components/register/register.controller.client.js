(function() {

	$(main);

	var $username, $password, $verifyPassword;
	var registerBtn;
	var userService = new UserServiceClient();

	function main() {
		registerBtn = $('#register-button').click(register);
	}

	function register() {
		$username = $('#usernameFld').val();
		$password = $('#passwordFld').val();
		$verifyPassword = $('#verifyPasswordFld').val();

		console.log('CALLED REGISTER');

		if ($password !== $verifyPassword) {
			alert('Passwords must match');
			clearForm;
		}
		else if ($username === "") {
			alert('Username cannot be blank')
		}
		else if ($password === "") {
			alert('Password cannot be blank')
		}
		else {
			userService
				.findByUsername($username)
				.then(tryRegistration);
		}
	}

	function tryRegistration(receivedUser) {
		if (!receivedUser.username) {
			var user = new User();
			user.setUsername($username);
			user.setPassword($password);

			userService
				.register(user)
				.then(function(user) {
					window.location.href = '../profile/profile.template.client.html?' + user.id;
				})
		} else {
			alert('Sorry, that username is taken. Please choose another');
			clearForm;
		}
	}

	function clearForm() {
		$('#username').val('');
		$('#password').val('');
		$('#verifyPassword').val('');
	}
});