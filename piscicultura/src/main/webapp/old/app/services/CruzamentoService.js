angular.module("Piscicultura").factory("CruzamentoService", function ($http, config) {
    return {
        adicionar: function (cruzamento) {
            return $http.post(config.baseUrl + "/cruzamento", cruzamento);
        },
        find: function () {
            return $http.get(config.baseUrl + "/cruzamento");
        }
    };
});