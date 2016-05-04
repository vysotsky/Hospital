package com.cityhospital.backend

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
