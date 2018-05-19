(function () {

    jQuery(main);

    var tbody;
    var template;
    var userService = new UserServiceClient()

    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('#createUser').click(createUser);

        findAllUsers();
    }

    // Returns all users in the system
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    function createUser() {
        console.log('createUser called');

        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName
        };

        fetch('http://localhost:8080/api/user', {
        	method: 'post',
        	body: JSON.stringify(user),
        	headers: {
        		'content-type': 'application/json'
        	}
        })
        
        userService
            .createUser(user)
            .then(findAllUsers);
    }

    function renderUsers(users) {
        tbody.empty();

        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();

            clone.attr('id', user.id);

            clone.find('.delete').click(deleteUser);
            clone.find('.edit').click(editUser);

            clone.find('.username').html(user.username);
            clone.find('.firstName').html(user.firstName);
            clone.find('.lastName').html(user.lastName);
            console.log('lastname: ' + user.lastName)
            tbody.append(clone);
        }
    }

    function deleteUser(event) {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            .parent()
            .parent()
            .attr('id');

        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }

    function editUser(event) {
        console.log('editUser');
        console.log(event);
    }

})();