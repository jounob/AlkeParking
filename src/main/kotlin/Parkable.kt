import kotlin.math.ceil

open class Parkable(
    override val vehicles: MutableSet<Vehicle>,

) : Parking(vehicles) {


    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Int, onError: () -> Unit) {
        val findVehicle = vehicles.filter { it.plate == plate }
        if (findVehicle.isNotEmpty()) {
            val fee = calculateFee(
                findVehicle[0].vehicleType,
                findVehicle[0].parkedTime.toInt(),
                findVehicle[0].discountCard?.isNotEmpty() ?: false
            )

            totalCar++
            totalFee += fee

            var totalCheckOut: Pair<Int, Int> = Pair(totalCar, totalFee)

            onSuccess(fee)
            vehicles.remove(findVehicle[0])

            println("Your fee $$fee. Come back soon.")

        } else {
            onError()
            println("Sorry, the check-out failed")
        }
    }

    private fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        var fee = 0.0
        if (parkedTime < 120) {
            fee = type.price.toDouble()
        } else {
            fee = type.price + ceil((parkedTime.toDouble() - 120)) / 15 * 5
            fee.toInt()
        }
        return when (hasDiscountCard) {
            true -> (fee * 0.85).toInt()
            else -> fee.toInt()
        }
    }

    fun earningsMessage() {
        var totalCheckOut: Pair<Int, Int> = Pair(totalCar, totalFee)
        println("${totalCheckOut.first} vehicles have checked out and have earning 0f $${totalCheckOut.second}")
    }

    fun listVehicle(): List<String> =  vehicles.map { it.plate }
}
