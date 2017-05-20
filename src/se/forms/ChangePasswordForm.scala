package forms

/**
  * Created by Panteha Taherifard on 5/19/2017.
  */

/**
  * Form containing data to change customer's password.
  *
  * @author Panteha Taherifard
  * @param oldPassword Customer's old password.
  * @param newPassword Customer's new password.
  * @param confirmPassword Confirmation of customer's new password.
  */
case class ChangePasswordForm(oldPassword: String, newPassword: String, confirmPassword: String)
