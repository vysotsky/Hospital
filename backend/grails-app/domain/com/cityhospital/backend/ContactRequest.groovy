package com.cityhospital.backend

/**
 * Created by Slawa on 03.05.2016.
 */
class ContactRequest {

    String name
    String email
    Date date = new Date();
    String subject
    String message

    static constraints = {
        name nullable: false, blank: false
        email nullable: false, blank: false, email: true
        subject nullable: false, blank: false
        message nullable: false, blank: false
    }

}
