enum class UserMenu (private val option: String) {
    VIEW_ACCOUNT_MONEY("*** 1. See balance available for purchases            ***"),
    VIEW_SELECT_TOUR_PACKAGES("*** 2. View and select available tour package         ***"),
    VIEW_SHOPPING_CART("*** 3. See selected destination in your shopping cart ***"),
    VIEW_HISTORY("*** 4. View purchase history                          ***"),
    MAKE_A_PURCHASE("*** 5. Make purchase of the selected destination      ***"),
    LOG_OUT_USER("*** 6. Log out                                        ***");

    override fun toString(): String {
        return option
    }


}