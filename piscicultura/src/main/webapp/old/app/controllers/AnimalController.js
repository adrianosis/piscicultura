angular.module("Piscicultura").controller("AnimalCtrl", function ($scope, $location, animal, medicoes) {

    $scope.animal = animal.data;
    $scope.medicoes = medicoes.data;

    $scope.adicionarMedicao = function () {
        console.log("ok");
        $location.path("/animal/" + $scope.animal.id + "/medicao");
    };

});