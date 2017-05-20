package se.forms

/**
  * Created by Panteha Taherifard on 5/19/2017.
  */

/**
  * Form containing customer's personal information.
  *
  * @author Panteha Taherifard
  * @param firstName Customer's first name.
  * @param lastName Customers's last name.
  * @param userName Customers's user name.
  * @param email Customer's email.
  */
case class PersonalInfoForm(firstName: String, lastName: String, userName: String, email: String)
