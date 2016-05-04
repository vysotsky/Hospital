package com.cityhospital.backend

class Comment {

    String username
    String picture
    Date date = new Date()
    String title
    String body

    static constraints = {
        username blank: false, nullable: false, notEqual: 'admin'
        picture blank: false, nullable: false
        title blank: false, nullable: false, minSize: 25
        body blank: false, nullable: false
    }

}
