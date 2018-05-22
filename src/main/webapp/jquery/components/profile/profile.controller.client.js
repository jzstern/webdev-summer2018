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
        if(!response) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }

    function logout() {
        console.log('CALLING LOGOUT');
        window.location.href = "../login/login.template.client.html";
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }

    function renderUser(user) {
        var bday = new Date(user.birthday);
        var year = user.birthday.substring(0, 4);
        var month = bday.getMonth();
        if (month.toString().length == 1) month = '0' + month;
        var day = bday.getDay();
        if (day.toString().length == 1) day = '0' + day;

        $("#username").val(user.username);
        $("#phoneNumber").val(user.phoneNumber);
        $("#email").val(user.email);
        $("#role").val(user.role);
        $("#birthday").val(year + '-' + month + '-' + day);
    }
})();