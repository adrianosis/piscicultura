angular.module("Piscicultura").config(function ($routeProvider) {
    
    $routeProvider.when("/animais", {
        templateUrl: "app/views/AnimalListView.html", 
        controller: "AnimalListCtrl"
    });
    $routeProvider.when("/animal", {
        templateUrl: "app/views/AnimalAddView.html", 
        controller: "AnimalAddCtrl"
    });
    $routeProvider.when("/animal/:id", {
        templateUrl: "app/views/AnimalView.html", 
        controller: "AnimalCtrl",  
        resolve: {
            animal: function(AnimalService, $route){
                return AnimalService.find($route.current.params.id);
            },
            medicoes: function(MedicaoService, $route){
                return MedicaoService.find($route.current.params.id);
            }
        }
    });
    $routeProvider.when("/animal/:id/medicao", {
        templateUrl: "app/views/MedicaoAddView.html", 
        controller: "MedicaoAddCtrl",  
        resolve: {
            animal: function(AnimalService, $route){
                return AnimalService.find($route.current.params.id);
            }
        }
    });
    
    $routeProvider.when("/cruzamento", {
        templateUrl: "app/views/CruzamentoAddView.html", 
        controller: "CruzamentoAddCtrl"
    });
    $routeProvider.when("/cruzamentos", {
        templateUrl: "app/views/CruzamentoListView.html", 
        controller: "CruzamentoListCtrl"
    });
    
    var validate = function (){
        console.log("ok ok ok");
    };
    validate();
});