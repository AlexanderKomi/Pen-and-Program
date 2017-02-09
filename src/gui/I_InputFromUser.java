package gui;

import java.awt.event.KeyListener;

public interface I_InputFromUser extends KeyListener {

	
	/* When a dice should be rolled
	 * */
	public int onClick();
	
	public int onKeyBoardUsed();
	
	public int setPlayerName();
	
}
