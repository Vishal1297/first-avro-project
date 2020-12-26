package org.fretron.person.exceptions

class ResourceNotFoundException : FretronException {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
}