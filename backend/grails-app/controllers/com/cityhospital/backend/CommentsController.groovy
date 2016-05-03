package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController

/**
 * Created by Slawa on 03.05.2016.
 */
class CommentsController extends AbstractController {

    static allowedMethods = ['GET', 'PUT']

    def index() {
        json status: 200, source: Comment.all
    }

    def addNewComment() {

    }
}
