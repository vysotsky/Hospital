package com.cityhospital.backend

/**
 * Created by Slawa on 03.05.2016.
 */
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
