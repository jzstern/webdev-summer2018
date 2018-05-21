(function() {
    $(init);

    var $username;
    var $phoneNumber;
    var $email;
    var $role;
    var $dateOfBirth;
    // var $firstName;
    // var $lastName;
    var updateBtn, logoutBtn;
    var userService = new UserServiceClient();

    function init() {
        $username = $("#username");
        $phoneNumber = $("#phoneNumber");
        $email = $("#email");
        $role = $("#role");
        $dateOfBirth = $("#birthday");
        updateBtn = $("#update-button").click(updateProfile);
        logoutBtn = $("#logout-button").click(logout);

        findUserById(2);
    }

    function updateProfile() {
        var user = {
            firstName: firstName.val(),
            lastName: lastName.val()

        };

        userService
            .updateUser(2, user)
            .then(success);
    }

    function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }

    function logout() {

    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }
    
    function renderUser(user) {
        console.log(user);
        $("#username").val(user.username);
        $("#phoneNumber").val(user.phone);
        $("#email").val(user.email);
        $("#role").val(user.role);
        $("#birthday").val(user.dateOfBirth);
        // $firstName.val(user.firstName);
        // $lastName.val(user.lastName);
    }
})();