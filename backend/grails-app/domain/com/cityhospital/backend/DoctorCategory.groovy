package com.cityhospital.backend

/**
 * Created by Slawa on 03.05.2016.
 */
class DoctorCategory {

    String name
    static hasMany = [doctors: Doctor]

    static constraints = {
    }

}
