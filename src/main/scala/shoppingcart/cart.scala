package shoppingcart

object cart extends App {

  private val priceList: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))
  private val allowedList: List[String] = List("apple", "orange")

  def checkout(items: Array[String]): Double = {
    var totalCost = 0.00
    val itemAllowed = items.forall(i => allowedList.contains(i.toLowerCase))

    if(!itemAllowed) {
      println("This Cart accepts only Apples and Oranges, Please remove other items from the cart before checkout")
      totalCost
    }
    else {
      val itemsIgnoreCase = items.map(r => r.toLowerCase).toSet

      for (item <- itemsIgnoreCase) {
        val quantity = items.count(r => r.equalsIgnoreCase(item.trim))
        val totalCostPerItem = getTotalCostPerItem(item.trim, quantity)
        totalCost += totalCostPerItem
      }
      totalCost
    }
  }

  def getPrice(item: String) : Double = {
    val itemPrice = priceList.get(item)
    itemPrice match {
      case Some(i) => i
      case None => 0.00
    }
  }

  def getTotalCostPerItem(item: String, quantity: Int): Double = {
    val itemPrice = getPrice(item)
    itemPrice * quantity

  }

  println("Total Cost = " + cart.checkout(Array("Mango","Orange", "Apple", "Orange")))

 }

