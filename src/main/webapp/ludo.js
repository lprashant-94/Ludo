var GREEN = "darkgreen";
var RED = "darkred";
var BLUE = "darkblue";
var YELLOW = "yellow";
function init() {
	var stage = new createjs.Stage("demoCanvas");

	loadPieces(stage);
	
	stage.update();
	
	setTimeout(init, 3000);
	
}

function loadPieces(stage) {
	$.getJSON("/ludogame", function(data) {
		for(var i=0;i<data.length;i++) {
			stage.addChild(getPiece(data[i].Color, 34 * (data[i].X-1), 34* (data[i].Y-1) ))
		}
		stage.update();
	})
}

function loadBoard() {
	var image = new Image();
	image.src = "ludo-board.png";
	var bitmapImage = new createjs.Bitmap(image);
	return bitmapImage
}

function renderInsideHomePiece(color, index) {

}

function getPiece(color, x, y) {
	var piece = new createjs.Shape();
	piece.graphics.beginFill(color).drawCircle(20, 0, 10);
	piece.graphics.beginFill(color).drawPolyStar(20, 20, 15, 3, 2, -90);
	piece.x = x - 2; // Adjustment
	piece.y = y - 1;
	return piece;
}

function rawCanvas() {
	var canvas = document.getElementById('demoCanvas') // / canvas element
	var ctx = canvas.getContext('2d') // / context

}