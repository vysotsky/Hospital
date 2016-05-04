package com.cityhospital.backend.base


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AccessInterceptor)
class CommentsInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test comments interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"comments")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
