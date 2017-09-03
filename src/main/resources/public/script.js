var openVpnWeb = angular.module("otho", []);

openVpnWeb.controller("StatusClientsController", ["$scope", "$http", function($scope, $http){
    $scope.clients = [];

    (function main(){
        updateClients();

    })();

    function updateClients(){
        $http.get("/otho/status/clients").then(function(response){
            $scope.clients = response.data;
            $scope.clients = _.sortBy($scope.clients, [function(client){ return client.commonName; }]);
            $scope.clients = _.sortBy($scope.clients, [function(client){ return !client.connected; }]);

        }, function(response){
            console.log(response);
        })
    }
}]);