package se.forms

/**
  * Created by Panteha Taherifard on 03.05.17.
  */

/**
  * Form containing information to register a new user/customer
  *
  * @author Panteha Taherifard
  * @param email User's email.
  * @param password User's password.
  * @param confirmPassword Confirmation of the user's password. Makes sure the user typed the right password.
  */
case class RegisterForm(email: String, password: String, confirmPassword: String)
