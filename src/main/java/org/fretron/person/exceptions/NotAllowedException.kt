package org.fretron.person.exceptions

class NotAllowedException : FretronException {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
}