app.service('goodService', function ($http) {

    this.getAll = function () {
        return $http.get('../GoodController/getAll');
    };

    this.getOne = function (gid) {
        return $http.get('../GoodController/getOne?gid=' + gid)
    };

    this.insert = function (entity) {
        return $http.post('../GoodController/insert', entity)
    };

    this.update = function (entity) {
        return $http.post('../GoodController/update', entity)
    };

    this.delete = function (ids) {
        return $http.post('../GoodController/delete?ids=' + ids)
    };
})
