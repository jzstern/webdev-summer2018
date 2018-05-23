function User(username, password, firstName, lastName, email, phone, role, DOB) {
// function User() {
  this.username = username;
  this.password = password;
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.role = role;
  this.dateOfBirth = DOB;

	// this.username;
	// this.password;
	// this.firstName;
	// this.lastName;
	// this.email;
	// this.phone;
	// this.role;
	// this.dateOfBirth;

  this.setUsername = setUsername;
  this.getUsername = getUsername;
  this.setPassword = setPassword;
  this.getPassword = getPassword;
  this.setFirstName = setFirstName;
  this.getFirstName = getFirstName;
  this.setLastName = setLastName;
  this.getLastName = getLastName;
  this.setEmail = setEmail;
  this.getEmail = getEmail;
  this.setPhoneNumber = setPhoneNumber;
  this.getPhoneNumber = getPhoneNumber;
  this.setRole = setRole;
  this.getRole = getRole;
  this.setBirthday = setBirthday;
  this.getBirthday = getBirthday;

  function setUsername(username) {
    this.username = username;
  }
  function getUsername() {
    return this.username;
  }
  function setPassword(password) {
    this.password = password;
  }
  function getPassword() {
    return this.password;
  }
  function setFirstName(firstName) {
    this.firstName = firstName;
  }
  function getFirstName() {
    return this.firstName;
  }
  function setLastName(lastName) {
    this.lastName = lastName;
  }
  function getLastName() {
    return this.lastName;
  }
  function setEmail(email) {
    this.email = email;
  }
  function getEmail() {
    return this.email;
  }
  function setPhoneNumber(phoneNumber) {
    this.phone = phoneNumber;
  }
  function getPhoneNumber() {
    return this.phone;
  }
  function setRole(role) {
    this.role = role;
  }
  function getRole() {
    return this.role;
  }
  function setBirthday(birthday) {
    this.dateOfBirth = birthday;
  }
  function getBirthday() {
    return this.dateOfBirth;
  }
}
