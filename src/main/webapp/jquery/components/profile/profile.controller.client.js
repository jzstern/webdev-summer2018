(function() {
    $(init);

    var staticEmail;
    var firstName;
    var lastName;
    var updateBtn;
    var logoutBtn
    var serService = new UserServiceClient();

    function init() {
        staticEmail = $("#staticEmail");
        firstName = $("#firstName");
        lastName = $("#lastName");
        updateBtn = $("#update-button").click(updateProfile);
        logoutBtn = $("#logout-button").click(logout);

        findUserById(12);
    }

    function updateProfile() {
        var user = {
            firstName: $firstName.val(),
            lastName: $lastName.val()
        };

        userService
            .updateUser(12, user)
            .then(success);
    }

    function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }
    
    function renderUser(user) {
        console.log(user);
        $staticEmail.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lastName);
    }
})();