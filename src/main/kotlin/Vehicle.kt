import java.util.*

const val MINUTES_IN_MILISECONDS = 60_000

data class Vehicle(
    val plate: String,
    val vehicleType: VehicleType,
    val checkInTime: Calendar = Calendar.getInstance(),
    val discountCard: String? = null,
    val parkedTime: Long = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS,
) {

}
