<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta chrset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script type="text/javascript">
//Simple GET request example:

  
	angular.module('etDay',[])
    .filter('Search', Search)
    .controller('MemoryCtrl', MemoryCtrl);


function MemoryCtrl($scope, $http){
	var result = "";
	$http({
		  method: 'GET',
		  url: '/json'
	}).then(function successCallback(response) {
	    // this callback will be called asynchronously
	    // when the response is available
	    
	    result = response.data;
	    alert(result);
	    $scope.memories = result;
	  }, function errorCallback(response) {
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	  });

	/*$scope.memories = result; [
      {
        "title": "기억1",
        "body": "사람들은 그대로 멈췄으나 기계는 작동한다.",
        "active": false
      },
      {
        "title": "기억2",
        "body": "그는 돈을 벌기 위해 온 일용직 노동자였다.",
        "active": false
      },
      {
        "title": "기억3",
        "body": "지구는 4년에 한 번씩 멈춘다.",
        "active": false
      },
      {
        "title": "기억4",
        "body": "신장은 178 cm 정도이다.",
        "active": false
      },
      {
        "title": "기억5",
        "body": "버터구이 오징어를 매우 좋아한다.",
        "active": false
      },
      {
        "title": "기억6",
        "body": "가까이 다가갔을 때 은은한 풀내음이 났다.",
        "active": false
      }
    ]; */
    
}

function Search(){
    return function(arr, text){
        if(!text){
           return arr;   
        }
        searchText = text.toLowerCase();
        var result = [];

        arr.forEach(function(data){
            if(data.body.toLowerCase().indexOf(searchText) !== -1){
                result.push(data)   
            }
        });
        return result;
    }
}
</script>
</head>
<body>
<div ng-app="etDay">
    <div ng-controller="MemoryCtrl" class="wrap">
    <span>외계인일용직노동자 앵귤러 JS 시리즈</span>    
    <h1>Information</h1>
        <div class="search">
            <input type="text" ng-model="text" placeholder="검색어를 입력하세요." class="searchField"/>
        </div>
    <ul>
        <li ng-repeat="memory in memories | Search:text" ng-mouseover="memory.active = true" ng-mouseleave="memory.active = false" ng-class="{active:memory.active}">
        <span class="title">{{memory.title}}</span>
        <span>{{memory.body}}</span>
        </li>
    </ul>
    </div>    
</div>
</body>
</html>