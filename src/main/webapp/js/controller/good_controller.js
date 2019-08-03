var app = angular.module('lotterysystem', [])

app.controller('goodController', function ($scope, goodService) {

    $scope.reloadList = function () {
        $scope.getAll();
    };

    $scope.getAll = function () {
        goodService.getAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    $scope.getOne = function (gid) {
        goodService.getOne(gid).success(
            function (response) {
                $scope.entity = response;
                $("#userModel").modal('show');
            }
        );
    };

    $scope.insert = function () {
        goodService.insert($scope.entity).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    $scope.update = function () {
        goodService.update($scope.entity).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    $scope.selectIds = [];//用户勾选的id集合

    //选中数组的增减
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id)
        } else {
            $scope.selectIds.splice($scope.selectIds.indexOf(id), 1);
        }
    };

    $scope.delete = function () {
        goodService.delete($scope.selectIds).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    $scope.deleOne = function (id) {
        ids = [id];
        goodService.delete(ids).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    $scope.myVar = true;
    $scope.toggle = function () {
        if ($scope.myVar === false) {
            $scope.entity = {}
        }

        $scope.myVar = !$scope.myVar;
    }
})
