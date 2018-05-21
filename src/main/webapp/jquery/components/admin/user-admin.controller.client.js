(function () {

    jQuery(main);

    var tbody;
    var template;
    var userService = new UserServiceClient()

    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('#search-user-button').click(findUserById);
        $('#create-user-button').click(createUser);
        $('#update-user-button').click(updateUser);
        $('#delete-user-button').click(deleteUser);
        $('#edit-user-button').click(updateUser);

        findAllUsers();
    }

    // Returns all users in the system
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    function findUserById() {
        userService
          .findUserById()
          .then()
    }

    function selectUser() {

    }

    function createUser() {
        console.log('createUser called');

        // TODO ; prevent adding blank users

        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();
        var role = $(':selected').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };
        
        userService
            .createUser(user)
            .then(findAllUsers);

        // TODO ; clear form after adding user
    }

    function updateUser() {

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

    function renderUser(user) {
      var clone = template.clone();
      clone.attr('id', user.id);

      clone.find('.delete').click(deleteUser);
      clone.find('.edit').click(updateUser);

      clone.find('.username').html(user.username);
      clone.find('.firstName').html(user.firstName);
      clone.find('.lastName').html(user.lastName);
      clone.find('.role').html(user.role);
      return clone;
    }

    function renderUsers(users) {
        tbody.empty();

        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = renderUser(user);
            tbody.append(clone);
        }
    }
})();