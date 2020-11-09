package example.numbers.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import example.numbers.model.Model;

public class StatusPanel extends JPanel{
	Model model;
	
	
	public StatusPanel(Model m) {
		this.model = m;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(model == null) {return;}
		
		if(model.getGameOver()) {
			g.setFont(new Font("Tahoma", Font.BOLD, 18));
			if(model.getIsWon()) {
				g.setColor(Color.blue);
				g.drawString("You Won!",10,20);
			}
			else {
				g.setColor(Color.red);
				g.drawString("You Lost!",10,20);
			}
		}
	}
	
}