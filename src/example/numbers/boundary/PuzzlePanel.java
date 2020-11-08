package example.numbers.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import example.numbers.model.Coordinate;
import example.numbers.model.Model;
import example.numbers.model.Puzzle;
import example.numbers.model.Tile;

public class PuzzlePanel extends JPanel {
	Model model;
	public static final int tileSize = 120;
	public static final int offset = 2;
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computeRectangle(Tile t) {
		int col = t.getCol();
		int row = t.getRow();
		int width = t.width;
		int height = t.height;
		Rectangle rect = new Rectangle((col*tileSize) + offset, (row*tileSize) + offset, t.width*tileSize - 2*offset, t.height*tileSize - 2*offset);
		return rect;
	}
	
	public Coordinate pointToCoordinate(Point p) {
		return new Coordinate(p.x/tileSize, p.y/tileSize);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(model == null) {return;} //only here for window builder
		
		Tile selectedTile = model.getSelTile();
		Puzzle puzzle = model.getPuzzle();
		model.isGameWon();
		
		for(Tile t : puzzle) {
			
			if(t.equals(selectedTile)) {
				g.setColor(Color.green);
			}
			else if(t.isBlank()) {
				g.setColor(Color.LIGHT_GRAY);
			}
			else if(model.getGameOver()) {
				g.setColor(Color.yellow);
			}
			else g.setColor(Color.gray);
			
			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);
			g.setColor(Color.black);
			
			if(t.isBlank() == false) {
				g.drawString("" + t.getNumber(), r.x + r.width/2, r.y + (r.height/2));
			}
			
		}
		
	}
	
}