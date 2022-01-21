fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val moto = Vehicle("B222BBB", VehicleType.MOTORCYCLE)
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS)
    val bus = Vehicle("DD444DD", VehicleType.BUS)

    val car1 = Vehicle("AA555AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val moto1 = Vehicle("B666BBB", VehicleType.MOTORCYCLE)
    val minibus1 = Vehicle("CC777CC", VehicleType.MINIBUS)
    val bus1 = Vehicle("DD888DD", VehicleType.BUS)

    val car2 = Vehicle("AA999AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val moto2 = Vehicle("B101BBB", VehicleType.MOTORCYCLE)
    val minibus2 = Vehicle("CC102CC", VehicleType.MINIBUS)
    val bus2 = Vehicle("DD103DD", VehicleType.BUS)

    val car3 = Vehicle("AA104AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val moto3 = Vehicle("B105BBB", VehicleType.MOTORCYCLE)
    val minibus3 = Vehicle("CC106CC", VehicleType.MINIBUS)
    val bus3 = Vehicle("DD107DD", VehicleType.BUS)

    val car4 = Vehicle("AA108AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val moto4 = Vehicle("B109BBB", VehicleType.MOTORCYCLE)
    val minibus4 = Vehicle("CC121CC", VehicleType.MINIBUS)
    val bus4 = Vehicle("DD122DD", VehicleType.BUS)

    val vehiclesSet = mutableSetOf(car, moto, minibus, bus, car1,
        bus1, moto1, minibus1, car2, moto2, minibus2, bus2,
        car3, moto3, minibus3, bus3, car4, moto4, minibus4, bus4)
    val parking = Parking(mutableSetOf(), 5)
    val parkable = Parkable(vehiclesSet)

    for (vehicle in vehiclesSet) {
        if (parking.addVehicle(vehicle)) {
            println("Welcome to AlkeParking")
        } else {
            println("Sorry, the check-in failed")
        }
    }

    parkable.checkOutVehicle("DD444DD", {it}, {})
    parkable.checkOutVehicle("B222BBB", {it}, {})
    parkable.earningsMessage()
    println(parkable.listVehicle())


}