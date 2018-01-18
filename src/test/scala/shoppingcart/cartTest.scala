package shoppingcart

import org.scalatest._

class cartTest extends FlatSpec with Matchers  {

  "Price and Offer of Apple " should "be values 0.6 and 1" in {
    cart.getPriceandOffer("apple") should be (0.6, 1)
  }

  "Price and Offer of Orange " should "be values 0.25 and 1" in {
    cart.getPriceandOffer("orange") should be (0.25, 2)
  }


}
