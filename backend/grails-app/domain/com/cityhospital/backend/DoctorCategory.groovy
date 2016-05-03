package com.cityhospital.backend

class DoctorCategory {

    String name
    static hasMany = [doctors: Doctor]

    static constraints = {
    }
}
