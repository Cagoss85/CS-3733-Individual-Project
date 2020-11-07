package example.numbers.boundary;

import java.util.List;

import example.numbers.model.MoveType;

public class UpdateButtons {
	
	
	public static void enableButtons(NumberPuzzleApp app, List<MoveType> moves) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		
		for(MoveType m : moves) {
			if(m == MoveType.Up) {
				app.getUpButton().setEnabled(true);
			}
			else if(m == MoveType.Down) {
				app.getDownButton().setEnabled(true);
			}
			else if(m == MoveType.Left) {
				app.getLeftButton().setEnabled(true);
			}
			else if(m == MoveType.Right) {
				app.getRightButton().setEnabled(true);
			}
		}
	}
}
