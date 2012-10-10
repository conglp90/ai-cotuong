/**
 * 
 */
package control;

/**
 * @author hoangnv
 *
 */
public class Position {
	private int x;
	private int y;
	private int piece;
	private int type;
	private boolean isAlive;
	private boolean isPassed;
	private boolean isChecked;
	public	Position(int x, int y, int piece , boolean isPassed, boolean isAlive){
		this.x = x;
		this.y = y;
		this.piece=piece;
		this.isPassed= isPassed;
		this.isAlive = isAlive;
	}
	public int getX(){
		return this.x;
	}
	public boolean getIsAlive(){
		return this.isAlive;
	}
	public void setIsAlive(boolean isAlive){
		this.isAlive = isAlive;
	}
	public int getY(){
		return this.y;
	}
	public int getPiece(){
		return this.piece;
	}
	public int getType(){
		return this.type;
	}
	public boolean getIsPassed(){
		return this.isPassed;
	}
	public boolean getIsChecked(){
		return this.isChecked;
	}
}

