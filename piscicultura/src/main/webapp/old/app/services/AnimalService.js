angular.module("Piscicultura").factory("AnimalService", function ($http, config) {
    return {
        adicionar: function (animal) {
            return $http.post(config.baseUrl + "/animal", animal);
        },
        find: function (animalId) {
            return $http.get(config.baseUrl + "/animal/" + animalId);
        },
        findList: function () {
            return $http.get(config.baseUrl + "/animal");
        }
    };
});