function init() {
	var stage = new createjs.Stage("demoCanvas");
	
	stage.addChild(loadBoard());
	
	var GREEN = "darkgreen";
	var RED = "darkred";
	var BLUE = "darkblue";
	var YELLOW= "yellow";
	
	stage.addChild(getPiece(GREEN, 120,120));
	stage.addChild(getPiece(YELLOW, 120,320));
	stage.addChild(getPiece(RED, 320,120));
	stage.addChild(getPiece(BLUE, 320,320));
	
	stage.addChild(getPiece("darkblue", 34*7,34*3));
	
	stage.addChild(getPiece("darkblue", 34*7,34*5));
	
	stage.addChild(getPiece("darkblue", 34*6, 34*4));
	
	stage.addChild(getPiece("darkblue", 34*6, 34*5));
	
	stage.addChild(getPiece("darkblue", 34*7, 34*13));
	
	
	stage.update();
  }

function loadBoard() {
	var image = new Image();
	image.src = "ludo-board.png";
	var bitmapImage = new createjs.Bitmap(image);
	return bitmapImage
}

function renderInsideHomePiece(color, index) {
	start = 
	return getPiece(color, )
}

function getPiece(color, x, y) {
	var piece = new createjs.Shape();
	piece.graphics.beginFill(color).drawCircle(20,0, 10);
	piece.graphics.beginFill(color).drawPolyStar(20,20, 15, 3, 2, -90);
	piece.x = x -2; // Adjustment
	piece.y = y -1;
	return piece;
}

function rawCanvas() {
	var canvas = document.getElementById('demoCanvas') /// canvas element
    var ctx = canvas.getContext('2d')            /// context
    
}