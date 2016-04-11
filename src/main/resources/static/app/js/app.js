define([
    'jquery',
    'angular',
    'angularRoute',
    'angularUIBootstrap',
    'module/events',
    'module/user'
], function ($, angular) {

    angular.module('Application', ['ngRoute', 'EventsModule', 'UserModule'])

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
