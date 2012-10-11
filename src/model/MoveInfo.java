/**
 * 
 */
package model;

/**
 * @author hoangnv
 *
 */
public class MoveInfo {
	private	int x;
	private int y;
	private int xx;
	private int yy;
	private int id;
	private int piece;
	public MoveInfo(int x,int y,int xx, int yy,int piece,int id){
		this.x = x;
		this.y = y;
		this.xx  = xx;
		this.yy = yy;
		this.piece = piece;
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	public int getxx(){
		return this.xx;
	}
	public int getyy(){
		return this.yy;
	}
	public int getx(){
		return this.x;
	}
	public int gety(){
		return this.y;
	}
	public int getpiece(){
		return this.piece;
	}
}
