package org.fretron.person.exceptions

open class FretronException : Exception {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
    constructor(msg: String?, e: Exception?) {}
}