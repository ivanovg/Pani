package forms

/**
  * Created by Panteha Taherifard on 6/7/2017.
  */

/**
  * Form containing data for adding/updating a product.
  *
  * @author Panteha Taherifard
  * @param name Name of the product.
  * @param description Description of the product.
  * @param category Category ID of the product.
  * @param sizes List of sizes that the product is offered in.
  * @param units List of units that the product is offered in.
  * @param prices List of prices that the product is offered in.
  * @param statuses List of statuses for each product detail.
  */
case class AddUpdateProductForm(name: String, description: String, category: Long, sizes: List[Int], units: List[String], prices: List[Double], statuses: List[Long])
