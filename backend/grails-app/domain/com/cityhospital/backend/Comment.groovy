package com.cityhospital.backend

/**
 * Created by Slawa on 03.05.2016.
 */
class Comment {

    String username
    String picture
    Date date = new Date()
    String title
    String body

    static constraints = {
        username blank: false, nullable: false, notEqual: 'admin'
        picture blank: false, nullable: false
        title blank: false, nullable: false
        body blank: false, nullable: false
    }

}
