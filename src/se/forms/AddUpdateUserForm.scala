package forms

/**
  * Created by Panteha Taherifard on 6/8/2017.
  */

/**
  * Form containing data for adding/updating an user.
  * @author Panteha Taherifard
  * @param userName User's user name.
  * @param firstName User's first name.
  * @param lastName User's last name.
  * @param email User's email.
  * @param password User's password.
  * @param accessLevel User's access level.
  * @param street User's street name and number.
  * @param postCode User's post code.
  * @param city User's city.
  * @param country User's country.
  */
case class AddUpdateUserForm(userName: String, firstName: String, lastName: String, email: String, password: String, accessLevel: Long,
                             street: String, postCode:String, city: String, country: String)
