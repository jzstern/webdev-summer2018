(function () {

    jQuery(main);

    var tbody;
    var template;
    var currentUserId;
    var userService = new UserServiceClient()

    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('#search-user-button').click(findUserById);
        $('#create-user-button').click(createUser);
        $('#update-user-button').click(updateUser);
        $('#delete-user-button').click(deleteUser);
        $('#edit-user-button').click(editUser);

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
          .then();
    }

    function createUser() {
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

        if (username === '' || password === '' || firstName === '' || lastName === '') {
            alert('You must fill out all fields before creating a user');
        } else {
            userService
                .createUser(user)
                .then(findAllUsers);

            clearForm;
        }

    }

    function editUser(event) {
        var editBtn = $(event.currentTarget);
        var userId = editBtn
          .parent()
          .parent()
          .attr('id');

        userService
          .findUserById(userId)
          .then(function(user) {
            $('#usernameFld').val(user.username);
            $('#passwordFld').val(user.password);
            $('#firstNameFld').val(user.firstName);
            $('#lastNameFld').val(user.lastName);
            $(':selected').val(user.role);

            currentUserId = userId;
          });
    }

    function updateUser() {
        var user = {};

        user.username =  $('#usernameFld').val();
        user.password =  $('#passwordFld').val();
        user.firstName =  $('#firstNameFld').val();
        user.lastName =  $('#lastNameFld').val();
        user.role = $(':selected').val();

        clearForm;

        userService
          .updateUser(currentUserId, user)
          .then(findAllUsers);
    }

    function clearForm() {
        $('#usernameFld').val('');
        $('#passwordFld').val('');
        $('#firstNameFld').val('');
        $('#lastNameFld').val('');
        currentUserId = null;
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
      clone.find('.edit').click(editUser);

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