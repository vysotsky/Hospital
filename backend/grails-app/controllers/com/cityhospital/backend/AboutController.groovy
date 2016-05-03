package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController

/**
 * Created by Slawa on 03.05.2016.
 */
class AboutController extends AbstractController {

    def index() {
        def info = HospitalInfo.aboutHospital.get()
        json status: 200, source: [
                title: info.title,
                about: info.about
        ]
    }

}
