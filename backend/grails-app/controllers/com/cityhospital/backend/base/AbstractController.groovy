package com.cityhospital.backend.base

/**
 * Created by Slawa on 03.05.2016.
 */
abstract class AbstractController {

    def json(int status, Object source) {
        response.status = status
        render(contentType: "text/json") { source }
    }

    def json(Object source) {
        json(200, source)
    }

}
