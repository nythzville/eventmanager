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
                    templateUrl: 'view/event/event_form.html',
                    controller: 'EventSaveCtrl',
                    // resolve: {
                    //     greeting: [function () {
                    //         return {};
                    //     }]
                    // }
                })

                // Edit form for event
                .when('/event/edit/:id', {
                    templateUrl: 'view/event/event_form.html',
                    controller: 'EventSaveCtrl',
                    resolve: {
                        greeting: ['$route', 'EventResource', function ( $route, EventResource) {
                            return EventResource.get({id: $route.current.params.id}).$promise;
                        }]
                    }
                })


                .when('/event/:id', {
                    templateUrl: 'view/event/event_details.html',
                    controller: 'EventDetailsCtrl'
                })
                .when('/event/:id/participants', {
                    templateUrl: 'view/event/event_participants.html',
                     controller: 'EventParticipantsCtrl'

                });

        }])


        /* -----------------------*/
        /* Controller for Events  */
        /* -----------------------*/

        .controller('EventSaveCtrl', ['$scope', '$location', '$routeParams', 'EventResource',
            function ($scope, $location, $routeParams, EventResource) {

                $scope.event =  $routeParams.id == null? null : EventResource.get({id: $routeParams.id});

                $scope.saveEvent = function () {
                    EventResource.save($scope.event, function (data) {
                        //alert("Saved with ID: " + data.id);
                        $location.path('/events');
                    });
                    console.log($scope.event);
                }
            }])

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


        .controller('EventDetailsCtrl', ['$scope', '$routeParams', 'EventResource',
            function ($scope, $routeParams, EventResource) {
                $scope.event = EventResource.get({id: $routeParams.id});
            }])

        .controller('EventParticipantsCtrl', ['$scope', '$routeParams', 'EventParticipantsResource','ParticipantsResource','UserResource',
            function ($scope, $routeParams, EventParticipantsResource,ParticipantsResource,UserResource) {
                $scope.event = EventParticipantsResource.get({id: $routeParams.id});
                $scope.users = UserResource.query();
                $scope.addParticipant = function(){
                    $scope.participant.eventId = $routeParams.id;
                    ParticipantsResource.save($scope.participant, function (data) {
                        //alert("Saved with ID: " + data.id);
                        //$location.path('/');
                        console.log('new id: ' + data);
                        $scope.event = EventParticipantsResource.get({id: $routeParams.id});
                    });
                }
            }])

        // Resource for Event
        .factory('EventResource', ['$resource', function ($resource) {
            return $resource('/event/:id');
        }])
        // Resource for Event Participants
        .factory('EventParticipantsResource', ['$resource', function ($resource) {
            return $resource('/event/:id/participants');
        }])

        // Resource for  Participants
        .factory('ParticipantsResource', ['$resource', function ($resource) {
            return $resource('/participant/:id');
        }])

        // Resource for User
        .factory('UserResource', ['$resource', function ($resource) {
            return $resource('/user/:id');
        }]);

});