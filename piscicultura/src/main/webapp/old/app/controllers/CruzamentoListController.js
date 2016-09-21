angular.module("Piscicultura").controller("CruzamentoListCtrl", function ($scope, $location, CruzamentoService) {
       
    $scope.adicionar = function () {
        $location.path("/cruzamento");
    };

    $scope.pesquisar = function () {
        CruzamentoService.find().success(function (data) {
            $scope.cruzamentos = data;
        });
    };

});