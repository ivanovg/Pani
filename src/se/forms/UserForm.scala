package forms

/**
  * Created by Panteha on 02/05/2017.
  */

/**
  * Form containing data to create an user.
  *
  * @author Panteha Taherifard
  * @param firstName User's first name.
  * @param lastName User's last name.
  * @param street Street name and number of the user.
  * @param postCode Post code of the user.
  * @param city City of the user.
  * @param country Country of the user.
  * @param email User's email.
  * @param userName User's user name.
  * @param password User's password.
  * @param accessLevel User's access level.
  */
case class UserForm(firstName: String, lastName: String, street: String, postCode: Int, city: String, country: String, email: String, userName: String, password: String, accessLevel: String)

