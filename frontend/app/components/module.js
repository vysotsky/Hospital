/**
 * Created by Slawa on 04.05.2016.
 */
(function (angular) {
    "use strict";
    angular.module('hospitalFrontend', [])
        .config(['$httpProvider', function ($httpProvider) {
            $httpProvider.defaults.useXDomain = true;
            delete $httpProvider.defaults.headers.common['X-Requested-With'];
        }])
        .factory("Comments", ['$http', function ($http) {
            return {
                list: function () {
                    return $http.get('http://localhost:8080/comments');
                }
            };
        }])
        .controller('commentsController', ['$scope', 'Comments', function ($scope, Comments) {
            $scope.loadComments = function () {
                Comments.list().then(function (res) {
                    $scope.allComments = res.data;
                });
            };
        }]);
})(window.angular)