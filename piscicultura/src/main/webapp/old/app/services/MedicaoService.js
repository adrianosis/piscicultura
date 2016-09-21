angular.module("Piscicultura").factory("MedicaoService", function ($http, config) {
    return {
        adicionar: function (animalId, medicao) {
            return $http.post(config.baseUrl + "/animal/" + animalId + "/medicao", medicao);
        },
        find: function (animalId) {
            return $http.get(config.baseUrl + "/animal/" + animalId + "/medicao");
        }
    };
});