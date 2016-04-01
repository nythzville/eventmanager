define([
    'jquery',
    'angular',
    'angularResource',
    'angularRoute'
], function ($, angular) {

    angular.module('EventsModule', ['ngRoute', 'ngResource'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                // Show the list of all events
                .when('/events', {
                    templateUrl: 'view/event/event_list.html',
                    controller: 'EventListCtrl',
                    resolve: {
                        events: ['EventResource', function (EventResource) {
                            return EventResource.query().$promise;
                        }]
                    }
                })

                // Form for new event
                .when('/event/form', {
                    templateUrl: 'view/greeting/greeting_form.html',
                    controller: 'GreetingSaveCtrl',
                    resolve: {
                        greeting: [function () {
                            return {};
                        }]
                    }
                })

                // Edit form for event
                .when('/event/edit/:id', {
                    templateUrl: 'view/greeting/greeting_form.html',
                    controller: 'GreetingSaveCtrl',
                    resolve: {
                        greeting: ['$route', 'GreetingResource', function ($route, GreetingResource) {
                            return GreetingResource.get({id: $route.current.params.id}).$promise;
                        }]
                    }
                })


                .when('/event/:id', {
                    templateUrl: 'view/greeting/greeting_detail.html',
                    controller: 'GreetingDetailsCtrl'
                });
        }])


        /* -----------------------*/
        /* Controller for Events  */
        /* -----------------------*/

        // .controller('GreetingSaveCtrl', ['$scope', '$location', '$routeParams', 'GreetingResource', 'greeting',
        //     function (a, $location, $routeParams, GreetingResource, greeting) {
        //         $scope.greeting = greeting;
        //         $scope.saveGreeting = function () {
        //             GreetingResource.save($scope.greeting, function (data) {
        //                 alert("Saved with ID: " + data.id);
        //                 $location.path('/greetings');
        //             });
        //         };
        //     }])

        // Event List Controller
        .controller('EventListCtrl', ['$scope', 'EventResource', 'events',
            function ($scope, EventResource, events) {
                $scope.events = events;
                $scope.removeGreeting = function (id, index) {
                    
                    EventResource.remove({id: id});
                    $scope.events.splice(index, 1);
                }

                $scope.convertToDate = function (stringDate) {
                    var dateOut = new Date(stringDate);
                    dateOut.setDate(dateOut.getDate());
                    return dateOut;
                };
            }])


        // .controller('GreetingDetailsCtrl', ['$scope', '$routeParams', 'GreetingResource',
        //     function ($scope, $routeParams, GreetingResource) {
        //         $scope.greeting = GreetingResource.get({id: $routeParams.id});
        //     }])
        .factory('EventResource', ['$resource', function ($resource) {
            return $resource('/event/:id');
        }]);

});