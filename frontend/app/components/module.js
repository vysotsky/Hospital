/**
 * Created by Slawa on 04.05.2016.
 */
(function (angular) {
    "use strict";
    angular.module('hospitalFrontend', [])
        .factory("Comments", ['$http', function ($http) {
            return {
                list: function () {
                    return $http.get('http://localhost:8080/comments');
                },
                send: function (username, title, body) {
                    return $http.put('http://localhost:8080/comments/add', {
                        "username": username,
                        "title": title,
                        "body": body
                    })
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
                Comments.send(comment.username, comment.title, comment.body).then(function () {
                    $scope.loadComments();
                });
            };
        }]);
})(window.angular)