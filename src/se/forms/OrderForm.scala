package forms

/**
  * Created by Panteha Taherifard on 5/21/2017.
  */

/**
  * Form containing data for a single item of customer's order.
  *
  * @author Panteha Taherifard
  * @param productDetailID Product detail ID to identify chosen size and the corresponding price.
  * @param extras List of the IDs of the chosen extras (as product ID)
  */
case class OrderForm(productDetailID: Long, extras: List[Long], quantity: Int)
