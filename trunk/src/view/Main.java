package view;

import model.Constant;

public class Main {
	public static void main(String[] args) {
		
        MainFrame f = new MainFrame();
        f.pack();
        f.setSize(Constant.MAIN_WIDTH,Constant.MAIN_HEIGHT);
        f.setLocation(Constant.LOCATEX, Constant.LOCATEY);
        f.setVisible(true);
        f.setResizable(false);
    }

}
