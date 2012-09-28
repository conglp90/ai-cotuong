package view;

import model.Constant;

public class Main {
	public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.pack();
        f.setSize(Constant.MAIN_WIDTH,Constant.MAIN_HEIGHT);
        f.setLocation(200, 2);
        f.setVisible(true);
    }

}
