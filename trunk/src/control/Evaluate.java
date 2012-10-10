package control;

import model.Match;

public class Evaluate {
	private int BaseValue[] ={0,10,20,20,25,45,50,100,10000};
	public int Eval(int type){
		int res = 0;
		for (int i = 1; i<= Match.count[type]; i++) 
			if (Match.Chess[type][i].getIsAlive()) res = res + BaseValue[Match.Chess[type][i].getPiece()];
		for (int i = 1; i<= Match.count[1-type]; i++) 
			if (Match.Chess[1-type][i].getIsAlive()) res = res - BaseValue[Match.Chess[1-type][i].getPiece()];	
		return res;
	}
}
