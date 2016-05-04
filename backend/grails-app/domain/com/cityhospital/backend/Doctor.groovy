package com.cityhospital.backend

class Doctor {

    String name
    String picture
    DoctorCategory category

    static constraints = {
        name blank: false, nullable: false
        picture blank: false, nullable: false
        category nullable: false
    }

}
