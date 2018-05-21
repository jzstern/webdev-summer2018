function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
    this.updateUser = updateUser;
    this.register = register;
    this.login = login;
    this.url = 'http://localhost:8080/api/user';                    // for local testing
    this.loginURL = 'http://localhost:8080/api/login';
    // this.url = 'https://stern-webdev-2018.herokuapp.com';           // for deployment
    // this.loginURL = 'https://stern-webdev-2018.herokuapp.com/api/login';
    var self = this;

    function login(username, password, callback) {
        return fetch(self.loginURL, {
            method: 'post',
            body: JSON.stringify({username:username, password: password}),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function register(username, password, callback) {
        return fetch(self.url + '/register')
          .then(function(response) {
                                                        // TODO ; ADD STUFF
          })
    }

    function updateUser(userId, user, callback) {
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
        .then(function(response, callback){
            if(response.bodyUsed) {
                return response.json();
            } else {
                return null;
            }
        });
    }

    function findUserById(userId, callback) {
        return fetch(self.url + '/' + userId)
            .then(function(response){
                return response.json();
            });
    }

    function deleteUser(userId, callback) {
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        })
    }

    function findAllUsers(callback) {
        return fetch(self.url)
            .then(function (response) {
                return response.json();
            });
    }

    function createUser(user, callback) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }
}