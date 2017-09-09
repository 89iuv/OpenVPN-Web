var openVpnWeb = angular.module("otho", []);

openVpnWeb.controller("StatusClientsController", ["$scope", "$http", "$interval", function($scope, $http, $interval){
    $scope.clients = [];

    (function main(){
        updateClients();
        $interval(updateClients, 60*1000);

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