package shoppingcart

import org.scalatest._

class cartTest extends FlatSpec with Matchers  {

  "Price and Offer of Apple " should "be values 0.6 and 1" in {
    cart.getPriceandOffer("apple") should be (0.6, 1)
  }

  "Price and Offer of Orange " should "be values 0.25 and 1" in {
    cart.getPriceandOffer("orange") should be (0.25, 2)
  }

  "Buy One Get One Free" should "return quantity / 2 if passed even no and quantity/2 + 1 if passed Odd" in {
    cart.buyOneGetOneFree(2) should be (1)
    cart.buyOneGetOneFree(5) should be (3)
  }

  "Buy Three for the price of Two" should "return 2 * quantity / 3 if passed multiples of 3 and 2*quantity/3 + quantity%3 if passed non-multiples of 3" in {
    cart.threeForTwo(9) should be (6)
    cart.threeForTwo(11) should be (8)
  }

  "Get Total cost of an Item with based on item offers" should "look up offers for that item and return the total cost" in {
    cart.getTotalCostPerItem(1, 2.00, 6) should be (6)
    cart.getTotalCostPerItem(2, 2.00, 9) should be (12)
  }

  "Test 1 Check out the list of apples and oranges" should "look up offers and quantity for all the items and return the total cost" in {
    cart.checkout(Array("Apple", "Apple", "Apple", "Orange")) should be (1.45)
  }

  "Test 2 Check out the list of apples and oranges" should "look up offers and quantity for all the items and return the total cost" in {
    cart.checkout(Array("Apple", "Apple", "Apple", "Orange", "Orange", "Orange")) should be (1.70)
  }



}
