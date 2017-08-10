angular.module('ponyslayer.services',[])
    .factory('psAPI',function($http){
	var result={};

	// ============ Adventure requests ============ //
	
	result.removeAdventure = function(id){
		var my_url='/adventure/'+id
		alert(my_url);
		return $http({
	    	method: 'DELETE',
	    	url: my_url
	    });
	};
	
	//get request returns http request
	result.getAdventures = function(){
	    var my_url = '/adventure';
	    return $http({
		method: 'GET',
		url: my_url
	    });
	};
	
	result.addAdventure = function(adventure){
	    var my_url = '/adventure';
	    return $http({
	    	'headers': {'Content-Type' : 'application/json'},
	    	method: 'POST',
	    	url: my_url,
	    	data: adventure
	    });
	};
//	
//	
//	//get request for auth credentials.
//	result.getAuth = function(){
//	    var my_url = 'auth/checkAuth'
//	    return $http({method: 'GET', url: my_url});
//	}
//	
//	
//
//	//add player to adventure
//	result.addPlayer = function(adventureID,playerName){
//	    var payload = { "_id":adventureID,"player":playerName};
//	    var my_url = 'rest/adventure/player/add';
//	    return $http({
//		method: 'POST',
//		url: my_url,
//		data: payload
//	    });
//	};
//
//	//remove player
//	result.removePlayer = function(adventureID,playerName){
//	    var payload = { "_id":adventureID,"playerName":playerName};
//	    var my_url = 'rest/adventure/player/remove';
//	    return $http({
//		method: 'POST',
//		url: my_url,
//		data: payload
//	    });
//	};
//
//	result.deleteAdventure = function(adventureID){
//	    var my_url = 'rest/adventure/remove'
//	    var payload = {"_id":adventureID};
//	    return $http({
//		method: 'POST',
//		url: my_url,
//		data: payload
//	    });
//
//	};
//	
//	//creates or edits adventure.
//	result.addAdventure = function(adventure){ 
//	    if(typeof adventure._id !== "undefined"){
//		var my_url='rest/adventure/edit'; 
//	    }else{
//		var my_url='rest/adventure/create';
//	    }
//	    
//	    return $http({
//		method: 'POST',
//		url: my_url,
//		data: adventure
//	    })
//	};

	return result;
});