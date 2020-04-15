package com.snorri.travelguide

class User {
    var Login: String? = null
    var Password: String? = null
    var userNativeName: String? = null

    constructor(login: String, pass: String, nameNative: String ) {
        this.Login = login
        this.Password = pass
        this.userNativeName = nameNative
    }

    constructor() {}
}
