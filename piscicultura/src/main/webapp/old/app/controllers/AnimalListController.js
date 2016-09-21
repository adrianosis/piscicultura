angular.module("Piscicultura").controller("AnimalListCtrl", function ($scope, $location, AnimalService) {

    $scope.adicionar = function () {
        $location.path("/animal");
    };

    $scope.detalhar = function (animal) {
        console.log(animal);
        $location.path("/animal/" + animal.id);
    };

    $scope.pesquisar = function () {
        AnimalService.findList().success(function (data) {
            $scope.animais = data;
        });
    };

});