window.onload = function () {
  init();
}


function init(){
  console.log("------- Init");

  var initial_position = new Location();
  initial_position.x = 0;
  initial_position.y = 0;
  
  var goal_position = new Location();
  goal_position.x = 5;
  goal_position.y = 5;

  var star = new AStar();
  star.map = new Map();

  star.initial_position = initial_position;
  star.goal_position = goal_position;

  /**
   * Maps all path in the map
   */
  star.mapper();
  var p = star.path();
  
  /**
   * Show the path
   */
  console.log(p);
  console.log("------- Finish");
}

function AStar(){

  /**
   * Initial position on the map
   */
  this.initial_position;

  /**
   * Position who the algorithm will search
   */
  this.goal_position;

  /**
   * List of locations to process
   */
  this.frontier = new Array();

  /**
   * Map to A* process
   */
  this.map;

  /**
   * Mark as visited the location, to don't process again
   */
  this.came_from = new Array();

  /**
   * Walk the map Picking and removing a location from the frontier
   * @returns {undefined}
   */
  this.mapper = function(){
    
    this.frontier.push(this.initial_position);
    while(this.frontier.length !== 0){
      var current = this.frontier.pop();
      var neighbors = this.lookingNeighbors(current);

      for (var i in neighbors) {
        var next = neighbors[i];
        if (this.came_from[next.x] === undefined){
          this.came_from[next.x] = new Array();
        }
        
        if (this.came_from[next.x][next.y] === undefined){
          this.came_from[next.x][next.y] = new Array();
          this.came_from[next.x][next.y] = current;
          this.frontier.push(next);
        }
      }
      
      if (this.found(current, this.goal_position)){
        break;
      }
      
    }
    
    return this.came_from;

  };
  
  /**
   * Reconstruct the path to goal
   * @returns {Array}
   */
  this.path = function(){
    
    var path = new Array();
    var current = this.goal_position;
    
    while (!this.found(current, this.initial_position)){
      current = this.came_from[current.x][current.y];
      path.push(current);
    }
    
    return path.reverse();
    
  };
  
  /**
   * Verify if current position arrived to goal
   * @param Location current
   * @param Location goal
   * @returns {Boolean}
   */
  this.found = function(current, goal){

    if (
      current.x === goal.x
      &&
      current.y === goal.y
      &&
      current.z === goal.z

    ){
      return true;
    } else {
      return false;
    }

    
  };

  /**
   * Look for the neighbors of the current position
   * @param Location current_position
   * @returns {AStar.lookingNeighbors.neighbors}
   */
  this.lookingNeighbors = function(current_position){

    var up = JSON.parse(JSON.stringify(current_position));
    var down = JSON.parse(JSON.stringify(current_position));
    var left = JSON.parse(JSON.stringify(current_position));
    var right = JSON.parse(JSON.stringify(current_position));

    if (up.y > 0) {
      up.y--;
    }

    if (left.x > 0) {
      left.x--;
    }

    if (down.y < this.map.length -1){
      down.y++;
    }


    if (right.x < this.map.length -1){
      right.x++;
    }

    var neighbors = {
      up : up,
      down : down,
      left : left,
      right : right
    };
    
    return neighbors;

  };

}

function Location(){
  this.x;
  this.y;
  this.z;
}

function Walker(){
  this.walk = true;
  this.location = new Location();
}

/**
 * Generate a map for tests
 * @returns {Map.map}
 */
function Map(){
  var map = Array();
  var width = 100;
  var height = 100;

  for (var x = 0; x < width; x++){
    map[x] = new Array();
    for (var y = 0; y < width; y++){
      map[x][y] = new Walker();
      map[x][y].location.x = x;
      map[x][y].location.y = y;
    }  
  }

  return map;
}
  

