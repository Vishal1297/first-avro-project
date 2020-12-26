package org.fretron.person.exceptions

class MongoDBException : FretronException {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
    constructor(msg: String?, e: Exception?) {}
}