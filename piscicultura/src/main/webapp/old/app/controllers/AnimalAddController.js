angular.module("Piscicultura").controller("AnimalAddCtrl", function ($scope, $location, AnimalService) {
    
    $scope.sexos = [
        {id: "M", nome: "Masculino"},
        {id: "F", nome: "Feminino"}
    ];

    $scope.adicionar = function () {
        AnimalService.adicionar($scope.animal).success(function (data) {
            $location.path("/animais");
        });
    };

});