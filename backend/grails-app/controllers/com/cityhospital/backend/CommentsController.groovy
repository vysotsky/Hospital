package com.cityhospital.backend

import com.cityhospital.backend.base.AbstractController

/**
 * Created by Slawa on 03.05.2016.
 */
class CommentsController extends AbstractController {

    def randomUsersService

    static allowedMethods = ['GET', 'PUT']

    def index() {
        json Comment.all.collect {
            [username: it.username,
             picture : it.picture,
             title   : it.title,
             body    : it.body]
        }
    }

    def add() {
        def requestJson = request.JSON
        def randomUser = randomUsersService.fetchNewRandomUser()
        def comment = new Comment([
                username: requestJson.username,
                picture : randomUser.picture,
                title   : requestJson.title,
                body    : requestJson.body
        ])
        if (comment.save()) {
            json([
                    username: comment.username,
                    picture : comment.picture,
                    title   : comment.title,
                    body    : comment.body,
                    date    : comment.date
            ])
        } else {
            json(400, ['status': 'invalid data'])
        }
    }

}
