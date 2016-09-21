angular.module("Piscicultura").controller("UsuarioCtrl", function ($scope, $window, UsuarioService) {

    $scope.logout = function () {
        UsuarioService.logout().success(function (data) {
            $window.location.href = 'login.html';
        });
    };

});