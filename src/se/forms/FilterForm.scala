package forms

/**
  * Created by Panteha Taherifard on 5/24/2017.
  */

/**
  * Form containing data for product filter.
  *
  * @author Panteha Taherifard
  * @param name Product's name.
  * @param categories List of categories for product.
  * @param priceStart Starting price for the search.
  * @param priceEnd Ending price for the search.
  * @param statuses List of statuses for the product search.
  */
case class ProductFilterForm(name: String, categories: List[Long], priceStart: Double, priceEnd: Double, statuses: List[Long])

/**
  * Form containing data for user filter.
  *
  * @author Panteha Taherifard
  * @param userName User's user name.
  * @param firstName User's first name.
  * @param lastName User's last name.
  * @param street User's street name and number.
  * @param postCode User's post code.
  * @param city User's city.
  * @param country User's country.
  * @param email User's email.
  * @param access User's access level.
  * @param status User's status.
  */
case class UserFilterForm(userName: String, firstName: String, lastName: String, street: String, postCode: String, city: String, country: String, email: String, access: List[Long], status: List[Long])

/**
  * Form containing data for order filter
  *
  * @author Panteha Taherifard
  * @param userID ID of the user who placed the order.
  * @param dateStart Starting date for the search.
  * @param dateEnd Ending date for the search.
  * @param priceStart Starting price for the search.
  * @param priceEnd Ending price for the search.
  * @param orderStatus Order's status.
  */
case class OrderFilterForm(userID: Long, dateStart: String, dateEnd: String, priceStart: Double, priceEnd: Double, orderStatus: Long)
