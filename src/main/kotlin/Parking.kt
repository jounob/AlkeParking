open class Parking(
    open val vehicles: MutableSet<Vehicle>,
    open val maxSpot: Int = 20,
) {

    var totalCar: Int = 0
    var totalFee: Int = 0

    //    var totalCheckOut: Pair<Int, Int> = Pair(0, 0)

    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (this.vehicles.size < this.maxSpot) {
            vehicles.add(vehicle)
            true
        } else {
            false
        }
    }



}
