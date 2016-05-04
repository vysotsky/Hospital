package com.cityhospital.backend

/**
 * Created by Slawa on 03.05.2016.
 */
class HospitalInfo {

    String title
    String about

    static mapping = {
        about column: 'about', sqlType: 'VARCHAR(10000)', nullable: 'true'
    }

    static constraints = {
        title nullable: false, blank: false
        about nullable: false, blank: false
    }

    static namedQueries = {
        aboutHospital {
            findAll().last()
        }
    }
}
