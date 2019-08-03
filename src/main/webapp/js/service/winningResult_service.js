app.service('winningResultService', function ($http) {

    this.getAll = function () {
        return $http.get('../WinningResultController/getAll');
    };


    this.insert = function (entity) {
        return $http.post('../WinningResultController/insert', entity)
    };

    this.update = function (entity) {
        return $http.post('../WinningResultController/update', entity)
    };

    this.delete = function (ids) {
        return $http.post('../WinningResultController/delete?ids=' + ids)
    };

    this.deleteAll = function () {
        return $http.post('../WinningResultController/deleteAll')
    };


});
