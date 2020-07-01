package com.snorri.travelguide

// Get user GPS objects
class UserLocator {
    var latitude: Double? = null
    var longtitude: Double? = null

    constructor(lat: Double, longt:Double ) {
        this.latitude = lat
        this.longtitude = longt
    }

    constructor() {}
}
// ... //