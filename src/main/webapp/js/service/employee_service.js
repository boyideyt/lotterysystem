app.service('employeeService',function($http){


    this.getAll=function(){
        return $http.get('../EmployeeController/getAll');
    };

    this.getOne=function(empno){
        return $http.get('../EmployeeController/getOne?empno=' + empno);
    };

    this.insert=function(entity){
        return $http.post('../EmployeeController/insert',entity);
    };

    this.dele=function(selectIds){
        if(confirm("你确认要删除么")) {
            return $http.get('../EmployeeController/delete?ids=' + selectIds);
        }
    };

    this.update=function(entity){
        return $http.post('../EmployeeController/update',entity);
    }
});