package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController
import groovy.json.JsonBuilder

/**
 * Created by Slawa on 03.05.2016.
 */
class DoctorsController extends AbstractController {

    def index() {
        def users = Doctor.findAll()
        json(200, [
                data: users.size()
        ])
    }

}
