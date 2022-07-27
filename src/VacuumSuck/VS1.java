package VacuumSuck;

import java.awt.Point;
import java.util.ArrayList;

public class VS1 
{
	ArrayList<Point> moves=new ArrayList<Point>();
	
	static int[][] mat= {{1, 0, 0},
			  	  {1, 1, 1},
			  	  {1, 0, 0}};
	
	static int x=(int) (Math.random()*mat.length);
	static int y=(int) (Math.random()*mat[x].length);
	static Agent agent=new Agent(x, y);
	
	public static void main(String[] args)
	{
		printMatrix();
		
		
		vacuum();
	}
	
	public static void vacuum()
	{
		while(containsDirty())
		{
			if(mat[agent.getY()][agent.getX()]==1)
			{
				System.out.println(agent.getY()+" "+agent.getX());
				System.out.println();
				mat[agent.getY()][agent.getX()]=0;
			}
			else
			{
				System.out.println(agent.getY()+" "+agent.getX());
				System.out.println();
				move();
			}
			
			printMatrix();
		}
	}
	
	public static void move()
	{
		ArrayList<Integer> bestMove=new ArrayList<Integer>();
		ArrayList<Integer> possibleMoves=new ArrayList<Integer>();
		for(int i=0; i<4; i++)
		{
			if(i==0)
			{
				if(agent.getX()>0)
				{
					if(containsDirty(agent.getX()-1, agent.getY()))
					{
						//agent.setX(agent.getX()-1);
						bestMove.add(i);
						break;
					}
					else
					{
						possibleMoves.add(i);
					}
				}
			}
			else if(i==1)
			{
				if(agent.getX()<mat.length-1)
				{
					if(containsDirty(agent.getX()+1, agent.getY()))
					{
						//agent.setX(agent.getX()+1);
						bestMove.add(i);
						break;
					}
					else
					{
						possibleMoves.add(i);
					}
				}
			}
			else if(i==2)
			{
				if(agent.getY()>0)
				{
					if(containsDirty(agent.getX(), agent.getY()-1))
					{
						//agent.setY(agent.getY()-1);
						bestMove.add(i);
						break;
					}
					else
					{
						possibleMoves.add(i);
					}
				}
			}
			else if(i==3)
			{
				if(agent.getX()<mat.length-1)
				{
					if(containsDirty(agent.getX(), agent.getY()+1))
					{
						//agent.setY(agent.getY()+1);
						bestMove.add(i);
						break;
					}
					else
					{
						possibleMoves.add(i);
					}
				}
			}
		}
		
		if(bestMove.size()>0)
		{
			int rand=(int)(Math.random()*bestMove.size());
			
			if(bestMove.get(rand)==0)
			{
				agent.setX(agent.getX()-1);
			}
			else if(bestMove.get(rand)==1)
			{
				agent.setX(agent.getX()+1);
			}
			else if(bestMove.get(rand)==2)
			{
				agent.setY(agent.getY()-1);
			}
			else if(bestMove.get(rand)==3)
			{
				agent.setY(agent.getY()+1);
			}
		}
		else
		{
			int rand=(int)(Math.random()*possibleMoves.size());
			
			if(possibleMoves.get(rand)==0)
			{
				agent.setX(agent.getX()-1);
			}
			else if(possibleMoves.get(rand)==1)
			{
				agent.setX(agent.getX()+1);
			}
			else if(possibleMoves.get(rand)==2)
			{
				agent.setY(agent.getY()-1);
			}
			else if(possibleMoves.get(rand)==3)
			{
				agent.setY(agent.getY()+1);
			}
		}
	}
	
	public static void moveLeft()
	{
		agent.setX(agent.getX()-1);
	}
	
	public static void moveRight()
	{
		agent.setX(agent.getX()+1);
	}
	
	public static void moveUp()
	{
		agent.setY(agent.getY()-1);
	}
	
	public static void moveDown()
	{
		agent.setY(agent.getY()+1);
	}
	
	public static void printMatrix()
	{
		for(int x=0; x<mat.length; x++)
		{
			for(int y=0; y<mat.length; y++)
			{
				System.out.print(mat[y][x]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean containsDirty()
	{
		boolean dirty=false;
		
		for(int x=0; x<mat.length; x++)
		{
			for(int y=0; y<mat.length; y++)
			{
				if(mat[y][x]==1)
				{
					dirty=true;
				}
			}
		}
		
		return dirty;
	}
	
	public static boolean containsDirty(int x, int y)
	{
		if(mat[y][x]==1)
		{
			return true;
		}
		
		return false;
	}
}
