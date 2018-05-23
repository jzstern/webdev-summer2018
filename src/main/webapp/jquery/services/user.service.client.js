function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
    this.findUserByUsername = findUserByUsername;
    this.updateUser = updateUser;
    this.register = register;
    this.login = login;
    this.url = 'http://localhost:8080/api/user';                    // for local testing
    this.loginURL = 'http://localhost:8080/api/login';
    this.registerURL = 'http://localhost:8080/api/register';
    // this.url = 'https://stern-webdev-2018.herokuapp.com';           // for deployment
    // this.loginURL = 'https://stern-webdev-2018.herokuapp.com/api/login';
    var self = this;

    function login(user) {
        return fetch(self.loginURL, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
          .then(function(response) {
              return response.json()
          })
    }

    function register(user) {
        return fetch(self.registerURL, {
	        method: 'post',
	        body: JSON.stringify(user),
	        headers: {
		        'content-type': 'application/json'
	        }
        })
            .then(function (response) {
              return response.json()
            })
    }

    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
        .then(function(response){
            return response.json();
        })
    }

    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function(response) {
                return response.json()
            })
    }

    function findUserByUsername(username) {
        return fetch(self.url + '-string/' + username)
          .then(function(response) {
              return response.json()
          })
    }

    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        })
    }

    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json()
            });
    }

    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
    }
}