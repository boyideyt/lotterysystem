app.service('lotteryService', function ($http) {

    this.saveWinner = function (winnerEntity) {
        return $http.post('../LotteryController/saveWinner', winnerEntity);
    };

    this.getWinningSetting = function () {
        return $http.get('../LotteryController/getWinningSetting')
    };

    this.random = function (randomEntity) {
        return $http.post('../LotteryController/random', randomEntity)
    };

    this.update = function (entity) {
        return $http.post('../GoodController/update', entity)
    };

    this.delete = function (ids) {
        return $http.post('../GoodController/delete?ids=' + ids)
    };
});
