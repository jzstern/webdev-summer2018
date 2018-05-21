(function() {
    $(init);

    var globalUserId;
    var $username;
    var $phoneNumber;
    var $email;
    var $role;
    var $birthday;
    var updateBtn, logoutBtn;
    var userService = new UserServiceClient();

    function init() {
        $username = $("#username");
        $phoneNumber = $("#phoneNumber");
        $email = $("#email");
        $role = $("#role");
        $birthday = $("#birthday");
        updateBtn = $("#update-button").click(updateProfile);
        logoutBtn = $("#logout-button").click(logout);

        globalUserId = window.location.href.split('?')[1];
        findUserById(globalUserId);
    }

    function updateProfile() {
        userService
          .findUserById(globalUserId)
          .then(function(originalUser) {
            var user = {
              firstName: originalUser.firstName,
              lastName: originalUser.lastName,
              username: originalUser.username,
              phoneNumber: $phoneNumber.val(),
              email: $email.val(),
              role: $role.val(),
              birthday: $birthday.val()
            };

            userService
                .updateUser(globalUserId, user)
                .then(success);
        });

    }

    function success(response) {
        if(response === null) {
            alert('unable to update')
            console.log('undable to update')
        } else {
            alert('success');
            console.log('success!')
        }
    }

    function logout() {
        console.log('CALLING LOGOUT');
        // for local
        window.location.href = "http://localhost:8080/jquery/components/login/login.template.client.html";
        // for heroku
        // window.location = "https://stern-webdev-2018.herokuapp.com/jquery/components/login/login.template.client.html";
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }
    
    function renderUser(user) {
        // var bday = user.birthday.toISOString().split('T')[0];

        console.log(user);
        $("#username").val(user.username);
        $("#phoneNumber").val(user.phoneNumber);
        $("#email").val(user.email);
        $("#role").val(user.role);
        // $("#birthday").val(bday);
        $("#birthday").val(user.birthday);
        // $firstName.val(user.firstName);
        // $lastName.val(user.lastName);
    }
})();