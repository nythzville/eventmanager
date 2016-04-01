define([
    'jquery',
    'angular',
    'angularRoute',
    'angularUIBootstrap',
    'module/events'
], function ($, angular) {

    angular.module('Application', ['ngRoute', 'EventsModule'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.
                otherwise({
                    redirectTo: '/events'
                });
        }]);

    angular.element(document).ready(function () {
        console.log('document ready');
        angular.bootstrap(document, ['Application']);
    });

});
