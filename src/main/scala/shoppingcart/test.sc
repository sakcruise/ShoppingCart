val items: Array[String] = Array("Apple", "Orange")

private val allowedList: List[String] = List("apple", "orange")

//private val priceList: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))
import shoppingcart.cart
val itemCost = cart.getPrice("apple")

val totalCost = totalCost + itemCost


