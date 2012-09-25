package view.QuanCo;

import java.awt.Image;
class QuanCo {

    public int row;
    public int col;
    public Image image;
    
    public QuanCo(int row,int col,Image img){
    	this.row=col*67+170;
    	this.col=row*67+15;
    	this.image=img;	
    }
    
    public Image getImg(){
    	return image;
    }

    public int getX() {
    	return row;
    }
    
    public int getY() {
    	return col;
    }


}
