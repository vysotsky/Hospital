package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController

/**
 * Created by Slawa on 03.05.2016.
 */
class AboutController extends AbstractController {

    def randomUsersService

    def index() {
        def info = HospitalInfo.aboutHospital.get()
        json(200, [
                title: info.title,
                about: info.about
        ])
    }

    def data() {
        json(200, [
                data: randomUsersService.fetchNewRandomUser()
        ])
    }

}
