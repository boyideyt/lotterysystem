var app = angular.module('lotterysystem', [])
app.controller('employeeController', function ($scope, employeeService) {

    $scope.reloadList = function () {
        $scope.getAll();
    };

    $scope.getAll = function () {
        employeeService.getAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };


    $scope.getOne = function (empno) {
        employeeService.getOne(empno).success(
            function (response) {
                $scope.entity = response;

            }
        );
    };

    $scope.insert = function () {
        employeeService.insert($scope.entity).success(
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
        employeeService.update($scope.entity).success(
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
        employeeService.delete($scope.selectIds).success(
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
        employeeService.delete(ids).success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    $scope.save = function () {
        $scope.entity.taskStepList = $scope.taskStepList;
        if ($scope.flag === "update") {//如果有ID
            $scope.update($scope.entity);
        } else {
            $scope.insert($scope.entity);
        }
        $("#userModel").modal('hide');
        $scope.clearModel()
    };

    $scope.clearModel = function () {
        $scope.entity = null;
    };

    $scope.toggle = function (empno) {
        if (empno) {
            $scope.getOne(empno)
            $scope.flag = "update"
        }
        $scope.flag = "insert"
        $("#userModel").modal('show');
    }
})