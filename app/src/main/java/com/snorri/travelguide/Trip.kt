package com.snorri.travelguide

// class for save new trip into DB v.0.6.6.1
class Trip {
    var trName:String? = null
    var trStartDate:String? = null
    var trEndDate:String? = null
    var trFromCity:String? = null
    var trToCity:String? = null
    var trVehicle:String? = null
    var trHotel:String? = null
    var trPlannedSpendings:String? = null

    constructor(name:String,sDate:String,eDate:String,fCity:String,
                 tCity:String, tVehicle:String,tHotel:String,trSpending:String) {
        this.trName = name
        this.trStartDate = sDate
        this.trEndDate = eDate
        this.trFromCity = fCity
        this.trToCity = tCity
        this.trVehicle = tVehicle
        this.trHotel = tHotel
        this.trPlannedSpendings = trSpending
    }

    constructor() {}
}
// ... //