package com.cityhospital.backend.base

/**
 * Created by Slawa on 03.05.2016.
 */
abstract class AbstractController {

    def json(int status, Closure closure) {
        response.status = status
        render(contentType: "text/json") { closure() }
    }

    def json(Closure closure) {
        json status: 200, closure: closure
    }

    def json(int status, Map map) {
        response.status = status
        render(contentType: "text/json") { map }
    }

    def json(Map map) {
        json status: 200, map: map
    }

}
