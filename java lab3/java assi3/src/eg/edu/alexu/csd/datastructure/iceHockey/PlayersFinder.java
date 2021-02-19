package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder{

     char [][] element;
	boolean [][] visited;
	 int maxsize = 1000;
	 int numOfplayer,area,width,height,leftside,rightside,upperside,lowerside;
	 Point[] center;
	 
	public void setPicturePixel(String[] photo) {
		element = new char[photo.length][photo[0].length()];
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				element[i][j] = photo[i].charAt(j);
			}
		}
	}
	
	public void visited(String[] photo) {
		visited = new boolean [photo.length][photo[0].length()];
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				visited [i][j] = false;
			}
		}	
	}

	public void setwidth(String[] photo) {
		width = photo[0].length();
	}
	
	public void setheight(String[] photo) {
		height = photo.length;
	}
	
     public void setleftside(int width) {
		 this.leftside = width;
	 }
	
     public void setrightside(int x) {
		 this.rightside = x;
	 }
	 
	 public void setupperside(int heidth) {
		 this.upperside = heidth;
	 }
	
     public void setlowerside(int x) {
		 this.lowerside = x;
	 }
 
     public void search(String[] photo, int team, int threshold) {
		 char s = (char)(team+48);
		 int x=0,y=0;
		 for(int i=0;i<photo.length;i++) {
			for(int j=0;j<photo[0].length();j++) {
				area=0;
			if(element[i][j]==s) {
			if(visited[i][j]==false) {
			visited[i][j]=true;
			area++;
			 setleftside(width);
			 setrightside(0);
			 setupperside(height);
			 setlowerside(0);
			 leftside = Math.min(j, leftside);
			 rightside = Math.max(j, rightside);
			 upperside = Math.min(i, upperside);
			 lowerside = Math.max(i, lowerside);
			 depthsearch(i, j, team);
			 if(area *4 >=threshold) {
				 center[numOfplayer] = new Point(x,y);
				 center[numOfplayer].x = rightside + leftside + 1;
				 center[numOfplayer].y = upperside + lowerside + 1;
				 numOfplayer+=1;
			    }
			  }	
			}
		  }
	    }
	  }
     
	 public void depthsearch(int i,int j,int team) {
		 char s = (char)(team+48);
		 if(i-1 >= 0 && j >= 0 && i<height && j<width) {
			 if(element[i-1][j]==s) {
					if(visited[i-1][j]==false) {
					 visited[i-1][j]=true;
					 leftside = Math.min(j, leftside);
					 rightside = Math.max(j, rightside);
					 upperside = Math.min(i-1, upperside);
					 lowerside = Math.max(i-1, lowerside);
					 area++;
					 depthsearch(i-1, j, team);
					 } } }
		 if(i >= 0 && j-1 >= 0 && i<height && j<width) {
			 if(element[i][j-1]==s) {
					if(visited[i][j-1]==false) {
					 visited[i][j-1]=true;
					 leftside = Math.min(j-1, leftside);
					 rightside = Math.max(j-1, rightside);
					 upperside = Math.min(i, upperside);
					 lowerside = Math.max(i, lowerside);
					 area++;
					 depthsearch(i, j-1, team);
					 } } }
		 if(i >= 0 && j >= 0 && i+1<height && j<width) {
			 if(element[i+1][j]==s) {
					if(visited[i+1][j]==false) {
					 visited[i+1][j]=true;
					 leftside = Math.min(j, leftside);
					 rightside = Math.max(j, rightside);
					 upperside = Math.min(i+1, upperside);
					 lowerside = Math.max(i+1, lowerside);
					 area++;
					 depthsearch(i+1, j, team);
					 } } }
		 if(i >= 0 && j >= 0 && i<height && j+1<width) {
			 if(element[i][j+1]==s) {
					if(visited[i][j+1]==false) {
					 visited[i][j+1]=true;
					 leftside = Math.min(j+1, leftside);
					 rightside = Math.max(j+1, rightside);
					 upperside = Math.min(i, upperside);
					 lowerside = Math.max(i, lowerside);
					 area++;
					 depthsearch(i, j+1, team);
					 } } }
		 }
	 
	 public void sortpointsOFcenter(Point[] center) {
		int x=0,y=0;
		Point temp = new Point(x,y);
		for(int i=0;i<numOfplayer;i++) {
		for(int j=0;j<numOfplayer-i-1;j++) {
		if(center[j].x > center[j+1].x) {
			temp.x = center[j].x;
			temp.y = center[j].y;
			center[j].x = center[j+1].x;
			center[j].y = center[j+1].y;
			center[j+1].x = temp.x;
			center[j+1].y = temp.y;
		}
		else if(center[j].x == center[j+1].x) {
			if(center[j].y > center[j+1].y) {
				temp.x = center[j].x;
				temp.y = center[j].y;
				center[j].x = center[j+1].x;
				center[j].y = center[j+1].y;
				center[j+1].x = temp.x;
				center[j+1].y = temp.y;
	      }	
	    } 
	  }
	}	 
  }
	 
	 public Point[] findPlayers(String[] photo, int team, int threshold) {
			// TODO Auto-generated method stub
			if(photo.length==0  || photo == null ) {
			return null;}
			
			else {
				 numOfplayer = 0;
				 center = new Point[maxsize];
				 visited(photo);
				 setPicturePixel(photo);
				 setheight(photo);
				 setwidth(photo);
				 search(photo, team, threshold);
				 sortpointsOFcenter(center);
				 Point[] centerpoint = new Point[numOfplayer];
				if(numOfplayer>0) {
				 for(int i=0;i<numOfplayer;i++) {
					 centerpoint[i]=center[i]; 
				 }
				return centerpoint; 
			}
				else { return null;	}				
		}			
	}
 }