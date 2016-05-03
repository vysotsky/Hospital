package com.cityhospital.backend

import grails.converters.JSON

class RandomUsersService {

    static transactional = true

    static URL = 'http://api.randomuser.me/'

    def fetchNewRandomUser() {
        def urlConnect = new URL(URL)
        def connection = urlConnect.openConnection()

        if (connection.responseCode == 200) {
            def json = JSON.parse(connection.content.text as String)
            def item = json.results[0]
            def name = item.name
            def picture = item.picture
            [name   : "${name.title} ${name.first} ${name.last}",
             picture: picture.large]
        } else {
            [name   : "mrs john smith",
             picture: null]
        }
    }

}
