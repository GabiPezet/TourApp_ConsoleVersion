enum class LoginMenu (private val option: String) {
    LOGIN("*** 1. LOGIN                                      ***"),
    EXIT("*** 2. EXIT                                       ***");

    override fun toString(): String {
        return option
    }

}