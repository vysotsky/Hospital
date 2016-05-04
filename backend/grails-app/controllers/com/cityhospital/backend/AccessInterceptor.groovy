package com.cityhospital.backend

/**
 * Created by Slawa on 03.05.2016.
 */
class AccessInterceptor {

    AccessInterceptor() {
        matchAll()
    }

    boolean before() {
        header("Access-Control-Allow-Origin", "http://localhost:8000")
        boolean options = ("OPTIONS" == request.method)
        if (options) {
            header("Access-Control-Allow-Origin", "http://localhost:8000")
            header("Access-Control-Allow-Credentials", "true")
            header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
            header("Access-Control-Max-Age", "3600")
            response.status = 200
        }
        true
    }

    boolean after() { true }

    void afterView() { }

}
