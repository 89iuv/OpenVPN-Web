var openVpnWeb = angular.module("otho", []);

openVpnWeb.controller("StatusClientsController", ["$scope", "$http", function($scope, $http){
    $scope.clients = [];

    (function main(){
        updateClients();

    })();

    function updateClients(){
        $http.get("/otho/status/clients").then(function(response){
            var clients = response.data;
            $scope.clients = _.sortBy(clients, [function(client){ return client.commonName; }]);

        }, function(response){
            console.log(response);
        })
    }
}]);