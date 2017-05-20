package se.forms

/**
  * Created by Panteha Taherifard on 5/19/2017.
  */

/**
  * Form containing data for an address object.
  *
  * @author Panteha Taherifard
  * @param street Address's street name and number.
  * @param postCode Address's post code.
  * @param city Address's city.
  * @param coutry Address's country.
  */
case class AddressForm(street: String, postCode: Int, city: String, coutry: String)
