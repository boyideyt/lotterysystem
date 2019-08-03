var app = angular.module('lotterysystem', [])
app.controller('lotteryController', function ($scope, lotteryService, winningResultService, employeeService) {

    $scope.winnerEntity = [];
    $scope.emplyeeList = [];
    $scope.winnerList = [];
    $scope.randomEntity = {};
    $scope.reloadList = function () {
        $scope.getWinnerList();
    };

    // 存储当前的中奖的名单
    $scope.saveWinner = function () {
        lotteryService.saveWinner($scope.winnerEntity).success(
            function (response) {
                if (response.signal) {
                    $scope.emplyeeList = $scope.deleWinner($scope.emplyeeList, $scope.winnerEntity)
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    //去除已经中奖的选手
    $scope.deleWinner = function (bigList, smallList) {
        for (var i = 0; i < smallList.length; i++) {
            for (var j = 0; j < bigList.length; j++) {
                if (bigList[j].empno === smallList[i].empno) {
                    bigList.splice(j, 1);
                    j = j - 1;
                }
            }
        }
        return bigList;
    }

    // 获取右侧已中奖名单
    $scope.getWinnerList = function () {
        winningResultService.getAll().success(
            function (response) {
                // emplyeelist 存储全部员工的容器
                $scope.winnerList = response;
            }
        );
    };

    // 获取
    $scope.getAll = function () {
        $scope.getAllEmp();
        $scope.getWinningSetting();
        $scope.getWinnerList();

    };
    // 获取左侧已全部人员名单
    $scope.getAllEmp = function () {
        employeeService.getAll().success(
            function (response) {
                // emplyeelist 存储全部员工的容器
                $scope.emplyeeList = response;
            }
        );
    };

    // 获取奖品清单
    $scope.getWinningSetting = function () {
        lotteryService.getWinningSetting().success(
            function (response) {
                // emplyeelist 存储全部员工的容器
                $scope.winningSetting = response;
            }
        );
    };


    // 开始抽奖
    $scope.random = function () {
        $scope.myDate = new Date();
        $scope.randomEntity.employeeList = $scope.emplyeeList;
        lotteryService.random($scope.randomEntity).success(
            function (response) {
                $scope.winnerEntity = response;
            }
        );
    };

    // 取消本次抽奖结果
    $scope.cancel = function () {
        $scope.winnerEntity = []
    };
    // 取消全部抽奖结果
    $scope.allCancel = function () {
        $scope.winnerEntity = [];
        $scope.getAllEmp();
        $scope.delAllWinner();
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


    // 删除全部中奖信息(按奖品gid)
    $scope.delAllWinner = function () {
        winningResultService.deleteAll().success(
            function (response) {
                if (response.signal) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }
})