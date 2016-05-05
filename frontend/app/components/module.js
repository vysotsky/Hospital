/**
 * Created by Slawa on 04.05.2016.
 */
(function (angular) {
    "use strict";
    angular.module('hospitalFrontend', ['angular.filter', 'toastr'])
        .factory("Comments", ['$http', function ($http) {
            return {
                list: function () {
                    return $http.get('http://localhost:8080/comments');
                },
                send: function (req) {
                    return $http.put('http://localhost:8080/comments/add', {
                        "username": req.username,
                        "title": req.title,
                        "body": req.body
                    })
                }
            };
        }])
        .factory("Doctors", ['$http', function ($http) {
            return {
                list: function () {
                    return $http.get('http://localhost:8080/doctors');
                }
            };
        }])
        .factory('Contact', ['$http', function ($http) {
            return {
                send: function (req) {
                    return $http.put('http://localhost:8080/contact', {
                        'name': req.name,
                        'email': req.email,
                        'subject': req.subject,
                        'message': req.message
                    });
                }
            };
        }])
        .controller('commentsController', ['$scope', 'Comments', function ($scope, Comments) {
            $scope.loadComments = function () {
                Comments.list().then(function (res) {
                    $scope.allComments = res.data.reverse();
                });
            };
            $scope.sendComment = function (comment) {
                Comments.send({
                    'username': comment.username,
                    'title': comment.title,
                    'body': comment.body
                }).then(function () {
                    $scope.loadComments();
                });
            };
        }])
        .controller('contactController', ['$scope', 'Contact', 'toastr', function ($scope, Contact, toastr) {
            $scope.sendContactRequest = function (contact) {
                Contact.send({
                    'name': contact.name,
                    'email': contact.email,
                    'subject': contact.subject,
                    'message': contact.message
                }).then(function (res) {
                    var data = res.data;
                    toastr.info('Hello ' + data.name + '! \n We got your message at ' + data.date + ' and we will contact you as soon as possible!', 'We got your request');
                });
            };
        }])
        .controller('doctorsController', ['$scope', '$window', 'Doctors', function ($scope, $window, Doctors) {
            $scope.loadDoctors = function () {
                Doctors.list().then(function (res) {
                    $scope.allDoctors = res.data;
                });
            };
            $scope.itemWidth = (Math.floor($window.innerWidth / 5) - 30) + 'px';
        }]);
})(window.angular)