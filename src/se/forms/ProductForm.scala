package forms

/**
  * Created by Panteha Taherifard on 02/05/2017.
  */

/**
  * Form containing data to create a product.
  *
  * @author Panteha Taherifard
  * @param name Name of the product.
  * @param description Description of the product.
  * @param category Category of the product.
  * @param productStatus Status of the product.
  * @param size List of sizes, which the product is offered in.
  * @param unit Unit, which the size is measured in.
  * @param price List of prices for each size.
  */
case class ProductForm (name: String, description: String, category: String, productStatus: String, size: List[Int], unit: String, price: List[Double])
