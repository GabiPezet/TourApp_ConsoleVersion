enum class ShoppingMenu (private val option: String) {
    PURCHASE("*** 1. BUY SELECTED PACKAGE                                 ***"),
    CANCEL_PURCHASE("*** 2. CANCEL PACKAGE PURCHASE                              ***");

    override fun toString(): String {
        return option
    }

}
