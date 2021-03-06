package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController

/**
 * Created by Slawa on 03.05.2016.
 */
class DoctorsController extends AbstractController {

    def index() {
        json Doctor.all.collect {
            [id          : it.id,
             name        : it.name,
             picture     : it.picture,
             categoryId  : it.category.id,
             categoryName: it.category.name]
        }
    }

}
