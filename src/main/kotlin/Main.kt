import data.*
import repositories.*
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.enums.EnumEntries

fun main() {
    val menuLogin = LoginMenu.entries
    var selectedLoginOption: Int
    var loginOption: LoginMenu

    do {
        showLoginMenu(menuLogin)
        selectedLoginOption = evaluateEnteredOption(2)
        loginOption = LoginMenu.entries[selectedLoginOption - 1]
        when (loginOption) {
            LoginMenu.LOGIN -> {
                val currentUser: User? = logIntoTheSystem()
                    if (currentUser != null) {
                        operateWithUserMenu(currentUser)
                    }else {
                        showMessage("*** ERROR, wrong username or password *** \n")
                    }
            }

            LoginMenu.EXIT -> showMessage("Goodbye!")
        }
    } while (loginOption != LoginMenu.EXIT)
}

private fun operateWithUserMenu(currentUser: User) {
    var currentPackage: TourPackage? = null
    do {
        val menu = UserMenu.entries
        showUserMenu(menu)
        val selectedOption: Int = evaluateEnteredOption(6)
        val option: UserMenu = UserMenu.entries[selectedOption - 1]
        when (option) {
            UserMenu.VIEW_ACCOUNT_MONEY -> showUserMoney(currentUser)
            UserMenu.VIEW_SELECT_TOUR_PACKAGES -> selectTouristPackage().also { currentPackage = it }
            UserMenu.VIEW_SHOPPING_CART -> seeSelectedDestination(currentPackage)
            UserMenu.VIEW_HISTORY -> listPurchaseHistory(currentUser)
            UserMenu.MAKE_A_PURCHASE -> currentPackage = optionsTourPackage(currentUser, currentPackage)
            UserMenu.LOG_OUT_USER -> showMessage("*** SUCCESSFUL SYSTEM LOGOUT, SEE YOU LATER!!! ***")
        }

    } while (option != UserMenu.LOG_OUT_USER)
}

private fun optionsTourPackage(currentUser: User, currentPackage: TourPackage?): TourPackage? {
    var actualCurrentPackage = currentPackage
    if ((actualCurrentPackage != null)) {
    val totalAmountToPay : Double
    val commission :Double
        val pair = calculateAmountToPayForThePackage(actualCurrentPackage)
        totalAmountToPay = pair.first
        commission = pair.second
        showMessage("\n*** The cost of your selected package is ${actualCurrentPackage.price} ***")
        showMessage("*** The commission percentage that your selected package has is $commission % .***")
        showMessage("*** The total amount payable for your commission package is $totalAmountToPay ***\n")
        val shoppingMenu = ShoppingMenu.entries
        showShoppingMenu(shoppingMenu)
        val selectedPurchaseOption = evaluateEnteredOption(2)
        val option = ShoppingMenu.entries[selectedPurchaseOption - 1]
        when (option) {
            ShoppingMenu.PURCHASE -> {
                if (currentUser.money >= totalAmountToPay) {
                    val newPurchase:Purchase=buildNewPurchase(currentPackage, currentUser,totalAmountToPay)
                    PurchaseRepository.addNewPurchase(newPurchase)
                    UserRepository.modifyMoney(currentUser,totalAmountToPay)
                    showMessage("*** Purchase made successfully! , have a nice trip !!!")
                    actualCurrentPackage = null
                } else {
                    showMessage("\n*** You don't have enough money to make the purchase. Select another package.***\n")
                }
            }
            ShoppingMenu.CANCEL_PURCHASE -> {
                showMessage(" *** SUCCESSFUL PURCHASE CANCELLATION *** ")
                actualCurrentPackage = null
            }
        }

    }else{
        showMessage("*** Error, you do not have any package selected. ***\n")
        showMessage("*** Select a package with option number 2 from the menu and try again . ***\n")
    }
    return actualCurrentPackage
}

private fun showShoppingMenu(shoppingMenu: EnumEntries<ShoppingMenu>) {
    showMessage("**** OPTIONS MENU: Do you want to confirm your purchase ? *****")
    for (i in shoppingMenu.indices) {
        showMessage(shoppingMenu[i].toString())
    }
    showMessage("***************************************************************")
}

fun calculateAmountToPayForThePackage(currentPackage: TourPackage): Pair<Double, Double>  {
    val transportType : TransportType = currentPackage.transport
    val currentDateAndTime : LocalDateTime = LocalDateTime.now()
    var totalAmountToPay = 0.0
    var commissionTotal = 0.0
    when(transportType){
        TransportType.BUS -> {
            val bus = BUS(currentPackage.price,currentDateAndTime)
            totalAmountToPay = bus.calculateAmountToPay()
            commissionTotal = bus.getCommission()
        }
        TransportType.TRAIN -> {
            val train = TRAIN(currentPackage.price,currentDateAndTime)
            totalAmountToPay = train.calculateAmountToPay()
            commissionTotal = train.getCommission()
        }
        TransportType.AIRPLANE -> {
            val airplane = AIRPLANE(currentPackage.price,currentDateAndTime)
            totalAmountToPay = airplane.calculateAmountToPay()
            commissionTotal = airplane.getCommission()
        }
        TransportType.FERRY -> {
            val ferry = FERRY(currentPackage.price,currentDateAndTime)
            totalAmountToPay = ferry.calculateAmountToPay()
            commissionTotal = ferry.getCommission()
        }
    }
    return Pair(totalAmountToPay , commissionTotal)
}

private fun listPurchaseHistory(currentUser: User) {
   val purchasesHistoryCurrenUser = PurchaseRepository.getPurchasesHistoryCurrenUser(currentUser)
    if (purchasesHistoryCurrenUser.isNotEmpty()) {
        println("DEAR ${currentUser.name}. THIS IS YOU PURCHASE HISTORY: ")
        for (purchase in purchasesHistoryCurrenUser.indices) {
            showMessage("***********************************************************")
            showMessage("*** PACKAGE PURCHASED: ${PackageRepository.getById(purchasesHistoryCurrenUser[purchase].packageId).name} \n" +
                    "*** PURCHASE CODE: ${purchasesHistoryCurrenUser[purchase].id}  \n" +
                    "*** PURCHASE DATE: ${purchasesHistoryCurrenUser[purchase].createdDate} \n" +
                    "*** TOTAL PRICE: ${purchasesHistoryCurrenUser[purchase].amount}"
                    )
            showMessage("***********************************************************")
        }
    } else {
        showMessage("*** Error, empty history. You have not made any purchases yet. ***\n")
    }
}

private fun seeSelectedDestination(currentPackage: TourPackage?) {
    if (currentPackage != null) {
        showMessage("*** Your shopping cart contains the following destination package ***")
        showMessage("***********************************************************")
        showMessage("*** NAME: ${currentPackage.destination.name} \n" +
                               "*** TRANSPORT: ${currentPackage.transport} \n" +
                               "*** DURATION: ${currentPackage.duration}\n" +
                               "*** STARS: ${currentPackage.stars} \n" +
                               "*** PRICE: ${currentPackage.price} \n" +
                               "*** LOGO: ${currentPackage.logo} \n" +
                               "*** DESCRIPTION: ${currentPackage.destination.description} \n" +
                               "*** PICTURES: ${currentPackage.destination.pictures}")
        showMessage("***********************************************************")

    } else {
        showMessage(" *** Error, empty shopping cart, first select a package with option 2 ***\n")
    }
}

private fun selectTouristPackage(): TourPackage {
    val selectedPackage : TourPackage
        listPackageRepository()
            showMessage("Select the ID of the tourist package you wish to purchase: ")
            val idPackage = evaluateEnteredOption(PackageRepository.getPackagesList().size).toLong()
                PackageRepository.getById(idPackage).also { selectedPackage = it }
                showMessage("""You have selected the following tourist package: """)
                showMessage("NAME: ${selectedPackage.name}")
                showMessage("TRANSPORT: ${selectedPackage.transport}")
                showMessage("DURATION: ${selectedPackage.duration}")
                showMessage("STARS: ${selectedPackage.stars}")
                showMessage("PRICE: ${selectedPackage.price}")
                showMessage("LOGO: ${selectedPackage.logo}")



    return selectedPackage
}

private fun showUserMoney(currentUser: User) {
    showMessage("*** Your available money is ${currentUser.money} *** \n")
}

private fun logIntoTheSystem(): User? {
    val currentUser : User?
    val userName = evaluateEnteredString("Enter username:")
    val userPassword = evaluateEnteredString("Enter password:")

    currentUser = UserRepository.login(userName, userPassword)
    if (currentUser != null) {
        showMessage(" *** SUCCESSFUL LOGIN ***  \n *** Welcome ${currentUser.nickName} ***")
    }
    return currentUser
}

fun evaluateEnteredString(message: String): String {
    var validEntry = false
    var dataEntry  = ""
    do {
        try {
            showMessage(message)
            dataEntry = validateInputOfStringTypeData(readln())
            if (dataEntry.isNotBlank() ){
                validEntry = true
            }
        } catch (exception: CustomException) {
            println(exception.message)
        }
    }while (!validEntry)
    return dataEntry
}

fun showMessage(message: String) = println(message)

private fun listPackageRepository() {
    val list = PackageRepository.getPackagesList()
    for (i in list.indices) {
        showMessage("ID: ${list[i].id}")
        showMessage("NAME: ${list[i].name}")
        showMessage("TRANSPORT: ${list[i].transport}")
        showMessage("DURATION: ${list[i].duration}")
        showMessage("STARS: ${list[i].stars}")
        showMessage("PRICE: ${list[i].price}")
        showMessage("LOGO: ${list[i].logo}")
        showMessage("************************")
    }
}

private fun showUserMenu(menu: EnumEntries<UserMenu>) {
    showMessage("*********************************************************")
    showMessage("******************     OPTION MENU     ******************")
    for (i in menu.indices) {
        showMessage(menu[i].toString())
    }
    showMessage("*********************************************************\n")
}

private fun showLoginMenu(menu: EnumEntries<LoginMenu>) {
    showMessage("*****************************************************")
    showMessage("***  Welcome to the Los borbotones system TourApp ***")
    showMessage("***************    OPTION MENU     ******************")
    for (i in menu.indices) {
        showMessage(menu[i].toString())
    }
    showMessage("*****************************************************\n")
}

private fun evaluateEnteredOption(maximumValue: Int):Int{
    val minimumValue = 1
    var option = 0
    var validEntry = false
        do {
            try {
                showMessage("Enter the desired option: ")
                option = validateInputOfNumericTypeData(readln())
                    if (option in minimumValue..maximumValue){
                            validEntry = true
                    }else{
                            showMessage("\n *** Error, invalid entry out of range. Please try again. *** \n")
                    }
            } catch (exception: CustomException) {
                    println(exception.message)
            }
        }while (!validEntry)
        return option
    }

fun buildNewPurchase(currentPackage: TourPackage?, currentUser: User, totalAmountToPay: Double): Purchase {
    val lastPurchase = PurchaseRepository.getPurchaseslist().last()
    val id = lastPurchase.id + 1
    val purchase : Purchase
    val userId = currentUser.id
    val packageId = currentPackage?.id
    val createdDate= LocalDate.now().toString()

    purchase = Purchase(id,userId, packageId!!,totalAmountToPay,createdDate)

    return purchase
}