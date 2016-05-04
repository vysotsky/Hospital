package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController

/**
 * Created by Slawa on 04.05.2016.
 */
class ContactController extends AbstractController {

    static allowedMethods = ['PUT']

    def index() {
        def requestJson = request.JSON
        def contactRequest = new ContactRequest([
                name   : requestJson.name,
                email  : requestJson.email,
                subject: requestJson.subject,
                message: requestJson.message
        ])
        if (contactRequest.save()) {
            json([
                    name   : contactRequest.name,
                    email  : contactRequest.email,
                    subject: contactRequest.subject,
                    message: contactRequest.message,
                    date   : contactRequest.date
            ])
        } else {
            json(400, ['status': 'invalid data'])
        }
    }

}
