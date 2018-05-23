(function() {

	$(main)

	var $username, $password, $verifyPassword
	var registerBtn
	var userService = new UserServiceClient()

	function main() {
		$username = $('#usernameFld')
		$password = $('#passwordFld')
		registerBtn = $('#register-button').click(register)
	}

	function register() {
		$username = $('#usernameFld').val()
		$password = $('#passwordFld').val()
		$verifyPassword = $('#verifyPasswordFld').val()

		if ($password !== $verifyPassword) {
			alert('Passwords must match')
			// clearForm;
		}
		else if ($username === "") {
			alert('Username cannot be blank')
		}
		else if ($password === "") {
			alert('Password cannot be blank')
		}
		else {
			userService
				.findUserByUsername($username)
				.then(tryRegistration);
		}
	}

	function tryRegistration(receivedUser) {
		$username = $('#usernameFld').val()
		$password = $('#passwordFld').val()

		if (receivedUser.username == null) {
			var user = {
				username: $username,
				password: $password
			}

			userService
				.register(user)
				.then(function(user) {
					window.location.href = '../profile/profile.template.client.html?' + user.id
				})
		} else {
			alert('Sorry, that username is taken. Please choose another')
			clearForm;
		}
	}

	function clearForm() {
		$('#username').val('')
		$('#password').val('')
		$('#verifyPassword').val('')
	}
})();