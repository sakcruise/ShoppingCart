package shoppingcart

object cart {

  val itemsDetails: Map[String, (Double, Int)] = Map(("apple" , (0.60,1)), ("orange", (0.25,2)))
  private val itemsAllowed: List[String] = List("apple", "orange")
  private val offerDetails: Map[Int, String] = Map((0, "noOffers"), (1, "buyOneGetOneFree" ), (2, "threeForTwo"))

  def checkout(items: Array[String]): Double = {
    var totalCost = 0.00
    val itemAllowed = items.forall(i => itemsAllowed.contains(i.toLowerCase))

    if(!itemAllowed) {
      println("This Cart accepts only Apples and Oranges, Please remove other items from the cart before checkout")
      totalCost
    }
    else {
      val itemsIgnoreCase = items.map(r => r.toLowerCase).toSet

      for (item <- itemsIgnoreCase) {
        val quantity = items.count(r => r.equalsIgnoreCase(item.trim))
        val itemPO = getPriceandOffer(item)
        val itemPrice = itemPO._1
        val itemOffer = itemPO._2
        val totalCostPerItem = getTotalCostPerItem(itemOffer , itemPrice , quantity)
        totalCost += totalCostPerItem
      }
      totalCost
    }
  }

  def getPriceandOffer(item: String) : (Double, Int) = {
    val itemPrice = itemsDetails.get(item)
    itemPrice match {
      case Some(i) => i
      case None => (0.00, 0)
    }
  }

  def getOfferDetails(offerId: Int) : String = {
    val itemOffers = offerDetails.get(offerId)
    itemOffers match {
      case Some(i) => i
      case None => "NoOffers"
    }
  }

  def buyOneGetOneFree(quantity: Int) : Double = {
    (quantity / 2) + (quantity % 2)
  }

  def threeForTwo(quantity: Int) : Double = {
    (2 * (quantity / 3)) + (quantity % 3)
  }

  def getTotalCostPerItem(itemOffer: Int, itemPrice: Double, quantity: Int): Double = {

    val offerValue = itemOffer match {
      case 1 => buyOneGetOneFree(quantity)
      case 2 => threeForTwo(quantity)
      case _ => 0.00
    }
    val total = itemPrice * offerValue
    total

  }
 }

