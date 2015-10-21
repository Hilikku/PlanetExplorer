package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:119
// Finish time:16.39
public class PlanetExplorer {
	private int x;
	private int y;
	private String obstacles;
	private String command;
	private String facing;


	

	public PlanetExplorer(int x, int y, String obstacles){
		this.setX(x);
		this.setY(y);
		this.setObstacles(obstacles);
		
		
		
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)"
	 *   with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two
		 obstacles at coordinates (5,5) and (7,8) 
	 */
	}
	
	public String executeCommand(String command){
		this.setCommand(command);
		int face = 0;
		int pos_y=0;
		int pos_x=0;
		for(int i=0; i < command.length(); i++){
			if(command.charAt(i) == 102) {
				if(face == 0) {
					pos_y++;
				} else if(face == 1 && face == -3) {
					pos_x++;
				} else if (face == 2 && face == -2) {
					pos_y--;
				} else if (face==3 && face == -1){
					pos_x--;
				}
				//forward
				
			}
			if(command.charAt(i) == 98) {
				if(face == 0) {
					pos_y--;
				} else if(face == 1 && face == -3) {
					pos_x--;
				} else if (face == 2 && face == -2) {
					pos_y++;
				} else if (face==3 && face == -1){
					pos_x++;
				}
				
				//backward 
			}
			if(command.charAt(i) == 114) {
				face++;
			}
			if(command.charAt(i) == 108) {
				face--;
			}
			if(face < -3 || face > 3) {
				face =0;
			}
			switch (face) {
			case 0: facing = "N";
				break;
			case 1: facing = "E";
				break;
			case 2: facing = "S";
				break;
			case 3: facing = "W";
				break;
			case -1: facing = "W";
				break;
			case -2: facing = "S";
				break;
			case -3: facing = "E";
				break;
				
			} 
			
		}
		String position = "(" + pos_x + "," + pos_y + "," + facing + ")";
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer
		 *  is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles.
		 *  No white spaces.
		 */
		
		return position;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getObstacles() {
		return obstacles;
	}

	public void setObstacles(String obstacles) {
		this.obstacles = obstacles;
	}
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
}
