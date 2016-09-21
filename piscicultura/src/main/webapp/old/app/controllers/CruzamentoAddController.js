angular.module("Piscicultura").controller("CruzamentoAddCtrl", function ($scope, $location, CruzamentoService) {
   
    $scope.adicionar = function () {
        CruzamentoService.adicionar($scope.cruzamento).success(function (data) {
            $location.path("/cruzamentos");
        });
    };

});