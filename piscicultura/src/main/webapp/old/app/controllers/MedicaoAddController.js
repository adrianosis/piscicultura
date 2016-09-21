angular.module("Piscicultura").controller("MedicaoAddCtrl", function ($scope, $location, animal, MedicaoService) {

    $scope.animal = animal.data;

    $scope.adicionar = function () {
        MedicaoService.adicionar($scope.animal.id, $scope.medicao).success(function (data) {
            $location.path("/animal/" + $scope.animal.id);
        });
    };

});