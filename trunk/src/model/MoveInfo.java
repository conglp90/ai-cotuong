/**
 * 
 */
package model;

/**
 * @author hoangnv
 *
 */
public class MoveInfo {
	private	int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int value;
	public MoveInfo(int fromX,int fromY,int toX, int toY,int value){
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX  = toX;
		this.toY = toY;
		this.value = value;
	}
	public MoveInfo(int toX,int toY){
		this.toX=toX;
		this.toY=toY;
	}
	public int getFromX(){
		return this.fromX;
	}
	public int getFromY(){
		return this.fromY;
	}
	public int getToX(){
		return this.toX;
	}
	public int getToY(){
		return this.toY;
	}
	public int getValue(){
		return this.value;
	}
}
