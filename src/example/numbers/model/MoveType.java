package example.numbers.model;

public enum MoveType {
	Up(0,-1), Down(0,1), Left(-1,0), Right(1,0), None(0,0);
	
	final int deltaR;
	final int deltaC;
	
	MoveType(int dc, int dr){
		this.deltaR = dr;
		this.deltaC = dc;
	}
}