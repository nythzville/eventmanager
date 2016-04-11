define([
    'jquery',
    'angular',
    'angularResource',
    'angularRoute'
], function ($, angular) {

    angular.module('UserModule', ['ngRoute', 'ngResource'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
            // Show the list of all users
                .when('/users', {
                    templateUrl: 'view/user/user_list.html',
                    controller: 'UserListCtrl',
                    resolve: {
                        users: ['UserResource', function (UserResource) {
                            return UserResource.query().$promise;
                        }]
                    }
                })

                // Form for new user
                .when('/user/form', {
                    templateUrl: 'view/user/user_form.html',
                    controller: 'UserSaveCtrl',
                    // resolve: {
                    //     greeting: [function () {
                    //         return {};
                    //     }]
                    // }
                })

                // Edit form for user
                .when('/user/edit/:id', {
                    templateUrl: 'view/user/user_form.html',
                    controller: 'UserSaveCtrl',
                    resolve: {
                        greeting: ['$route', 'UserResource', function ( $route, UserResource) {
                            return UserResource.get({id: $route.current.params.id}).$promise;
                        }]
                    }
                })
                .when('/user/:id', {
                    templateUrl: 'view/user/user_details.html',
                    controller: 'UserDetailsCtrl'
                })
                /*.when('/user/:id/participants', {
                    templateUrl: 'view/user/user_participants.html',
                    controller: 'UserParticipantsCtrl'

                })*/;

        }])


        /* -----------------------*/
        /* Controller for Users  */
        /* -----------------------*/
        
        // Create / Update User
        .controller('UserSaveCtrl', ['$scope', '$location', '$routeParams', 'UserResource',
            function ($scope, $location, $routeParams, UserResource) {
                $scope.user =  $routeParams.id == null? null : UserResource.get({id: $routeParams.id});
                $scope.saveUser = function () {
                    UserResource.save($scope.user, function (data) {
                        alert("Saved with ID: " + data.id);
                        $location.path('/users');
                    });
                }
            }])

        // User List Controller
        .controller('UserListCtrl', ['$scope', 'UserResource', 'users',
            function ($scope, UserResource, users) {
                $scope.users = users;

                $scope.removeUser = function (id, index) {
                    UserResource.remove({id: id});
                    $scope.users.splice(index, 1);
                }
            }])


        .controller('UserDetailsCtrl', ['$scope', '$routeParams', 'UserResource',
            function ($scope, $routeParams, UserResource) {
                $scope.user = UserResource.get({id: $routeParams.id});
            }])
        .factory('UserResource', ['$resource', function ($resource) {
            return $resource('/user/:id');
        }]);

});