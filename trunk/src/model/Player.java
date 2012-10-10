package model;

import control.Computer;

public class Player {
	Computer com;
	Match match;
	public MoveInfo runCom(MoveInfo m){
		com.thinking(0);
		return match.newMove;
	}

}