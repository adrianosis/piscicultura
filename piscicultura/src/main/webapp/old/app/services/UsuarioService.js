angular.module("Piscicultura").factory("UsuarioService", function ($http, config) {
    return {
        logout: function () {
            return $http.get(config.baseUrl + "/user/logout");
        }
    };
});