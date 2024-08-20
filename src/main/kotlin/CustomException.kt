class CustomException (inputData: String) : Exception(inputData)

fun validateInputOfStringTypeData(stringInput: String):String {
    if (stringInput.isEmpty()) {
        throw CustomException("*** Error, invalid empty entry. Please try again. *** \n")
    }else{
        return  stringInput
    }
}

fun validateInputOfNumericTypeData(numericInput: String): Int {
    if (numericInput.isBlank()){
        throw CustomException("*** Error, invalid empty entry. Please try again. *** \n")
    }else if (!numericInput.matches("[0-9]*".toRegex())){
            throw CustomException("\n *** Error, invalid entry. Please try again. *** \n")

    }else{
        return numericInput.toInt()
    }

}


