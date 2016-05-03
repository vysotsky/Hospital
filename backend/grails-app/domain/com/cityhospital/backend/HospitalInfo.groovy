package com.cityhospital.backend

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
