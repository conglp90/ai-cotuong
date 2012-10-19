package model;

import control.Computer;

public class Player {
	Computer com;
	Match match;
	public static boolean kiemtrachieutuong(int a[][],int piece){
		int i,j;
		int x = 0,y = 0,dem,li;
		if (piece<0){
			for (i=0;i<=9;i++)
				for (j=0;j<=8;j++)
					if (a[i][j]==7){
						x=i;
						y=j;
						break;
					}
		}
		if (piece>0){
			for (i=0;i<=9;i++)
				for (j=0;j<=8;j++)
					if (a[i][j]==-7){
						x=i;
						y=j;
						break;
					}
		}
		if (x==0 && y==0) return true;
		//kiem tra xem tuong co bi ma chieu khong
		int Tdx[] = {0,-1,1,2,2,1,-1,-2,-2} ;
		int Tdy[] = {0,-2,-2,-1,1,2,2,1,-1} ;
		int dx[] = {0,0,1,0,-1};
		int dy[] = {0,-1,0,1,0};
		for (int k=1;k<=8;k++){
			int x1=x+Tdx[k];
			int y1=y+Tdy[k];
			if (x1>=0 && y1>=0 &&x1<=9 &&y1<=8)
			if (a[x1][y1]==-4||a[x1][y1]==4)
			if (a[x1][y1]*piece>0){
				return false;
			}
		}
		//kiem tra xem tuong co bi xe chieu khong
		//sang phai
		for (i=y+1;i<=8;i++){
			if (a[x][i]==6||a[x][i]==-6){
				System.out.println("xe"+x+" "+i);
				return false;
			}
			if (a[x][i]!=0) break;
		}
		//xuong
		for (i=x+1;i<=9;i++){
			
			if (a[i][y]==6||a[i][y]==-6){
				return false;
			}
			if (a[i][y]!=0) break;
		}
		//sang trai
		for (i=y-1;i>=0;i--){
			if (a[x][i]==6||a[x][i]==-6){
				return false;
			}
			if (a[x][i]!=0) break;
		}
		//len
		for (i=x-1;i>=0;i++){
			if (a[i][y]==6||a[i][y]==-6){
				return false;
			}
			if (a[i][y]!=0) break;
		}
		//kiem tra xem tuong co bi phao chieu khong
		dem=0; 
		//sang phai
		for (i=y+1;i<=8;i++){
			if (a[x][i]!=0) {
				dem++;
			}
			if (dem==2&&a[x][i]*piece<0){
				if (a[x][i]==5||a[x][i]==-5){
					System.out.println("p3"+x+" "+i+" "+dem);
						return false;
					}
				break;
			}
		}
		//xuong
		dem=0;li=-1;
		for (i=x+1;i<=9;i++){
			if (a[i][y]!=0){
				dem++;
			} 
			if (dem==2&&a[i][y]*piece<0){
				if (a[i][y]==5||a[i][y]==-5){
					System.out.println("p2"+x+" "+i+" "+dem);
					return false;
				}
				break;
			}
		}
		dem=0;
		//sang trai
		for (i=y-1;i>=0;i--){
			if (a[x][i]!=0) {
				dem++;
			}
			if (dem==2&&a[x][i]*piece<0){
				if (a[x][i]==5||a[x][i]==-5){
					System.out.println("p1"+x+" "+i+" "+dem);
						return false;
					}
				break;
			}
		}
		dem=0;
		//len
		for (i=x-1;i>=0;i--){
			if (a[i][y]!=0){
				dem++;
			} 
			if (dem==2&&a[i][y]*piece<0){
				System.out.println("p"+x+" "+i+" "+piece);
				if (a[i][y]==5||a[i][y]==-5){
					return false;
				}
				break;
			}
		}
		
		//kiem tra xem co bi tot chieu khong
		if (piece<0){//kiem tra ben may>0
			if (Math.abs(a[x+1][y])==1||Math.abs(a[x][y-1])==1||Math.abs(a[x][y+1])==1){
				return false;
			}
		}
		if (piece>0){//kiem tra ben ng<0
			if (Math.abs(a[x-1][y])==1||Math.abs(a[x][y-1])==1||Math.abs(a[x][y+1])==1){
				return false;
			}
		}
		
		return true;
	}

}