package Lab7;

import java.util.Stack;
import java.util.ArrayList;
/*
public class DFS 
{
    private int moveCounter = 0;
    private Stack<Node> fringe = new Stack<Node>();
    private Node startState, goalState, currentState = new Node();
    private ArrayList<Node> closed = new ArrayList<Node>();

    public DFS(int start[][], int goal[][]) 
    {
        startState = new Node(start);
        goalState = new Node(goal);
        fringe.push(startState);
    }

    private void succesor(Node currentState) 
    {
        Node newState = new Node();
        Puzzle p = new Puzzle();

        newState = p.moveUp(currentState);

        if (newState != null) 
        {
            fringe.push(newState);
        }

        newState = p.moveRight(currentState);

        if (newState != null) 
        {
            fringe.push(newState);
        }

        newState = p.moveDown(currentState);

        if (newState != null) 
        {
            fringe.push(newState);
        }

        newState = p.moveLeft(currentState);

        if (newState != null) 
        {
            fringe.push(newState);
        }
    }

    public void search() 
    {
        boolean found = false, exist = false, checkElement = true;
        Node tmpNode = new Node();

        currentState = fringe.pop();
        closed.add(currentState);
        succesor(currentState);

        for (int x = 1; x < 2 ; x++) 
        {
            while (!found) 
            {
                try 
                {
                    currentState = fringe.pop();

                    for (int i = 0; i < closed.size(); i++)
                    {
                        tmpNode = closed.get(i);

                        if (currentState.toString().equals(tmpNode.toString())) 
                        {
                            exist = true;
                            break;
                        }                        
                    }

                    if (!exist) 
                    {
                        moveCounter++;

                        if (currentState.getX(x) == goalState.getX(x) && currentState.getY(x) == goalState.getY(x)) {
                            found = true;
                            break;
                        }
                        else {
                            closed.add(currentState);
                            succesor(currentState);
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println("No solutions found!");
                    break;
                }
            }
        }

        System.out.println("Number of step(s): " + moveCounter);
    }
}

public class Node {
    int state[][] = new int[3][3];
    
    public Node() {
    }
    
    public Node(int state[][]) {
        this.state = state;
    }
    
    public int getNum(int posX, int posY) {
        return state[posX][posY];
    }
    
    public void setNum(int num, int x, int y) {
        state[x][y] = num;
    }
    
    public int getX(int num) {
        int positionX = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == num) {
                    positionX = x;
                    break;
                }
            }
        }

        return positionX;
    }
    
    public int getY(int num) {
        int positionY = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == num) {
                    positionY = y;
                    break;
                }
            }
        }

        return positionY;
    }
    
    public void getCoordinate(int coordinate[], int num) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == num) {
                    coordinate[0] = x;
                    coordinate[1] = y;
                    break;
                }
            }
        }
    }
    
    public void getState(int state[][]) {
        state = this.state;
    }
    
    public String toString() {
        String output = "";

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                output += state[x][y];
            }
            output += "\n";
        }

        return output;
    }
}

public class Puzzle {    
    public Puzzle() {
    }
    
    private void swap(Node newState, int newPosition[]) {
        int emptyTile[] = new int[2], tmpNum;                

        newState.getCoordinate(emptyTile, 0);
        tmpNum = newState.getNum(newPosition[0], newPosition[1]);
        
        newState.setNum(0, newPosition[0], newPosition[1]);
        newState.setNum(tmpNum, emptyTile[0], emptyTile[1]);
    }
        
    public Node moveUp(Node currentState) {
        Node newState = new Node();
        newState = null;
        int newPosition[] = new int[2];

        if (currentState.getX(0) - 1 >= 0) {
            newState = currentState;
            newPosition[0] = newState.getX(0) - 1;
            newPosition[1] = newState.getY(0);

            swap(newState, newPosition);
        }

        return newState;
    }        
        
    public Node moveRight(Node currentState) {
        Node newState = new Node();
        newState = null;
        int newPosition[] = new int[2];

        if (currentState.getY(0) + 1 <= 2) {
            newState = currentState;
            newPosition[0] = newState.getX(0);
            newPosition[1] = newState.getY(0) + 1;

            swap(newState, newPosition);
        }

        return newState;
    }        
        
    public Node moveDown(Node currentState) {
        Node newState = new Node();
        newState = null;
        int newPosition[] = new int[2];

        if (currentState.getX(0) + 1 <= 2) {
            newState = currentState;
            newPosition[0] = newState.getX(0) + 1;
            newPosition[1] = newState.getY(0);

            swap(newState, newPosition);
        }

        return newState;
    }        
        
    public Node moveLeft(Node currentState) {
        Node newState = new Node();
        newState = null;
        int newPosition[] = new int[2];

        if (currentState.getY(0) - 1 >= 0) {
            newState = currentState;
            newPosition[0] = newState.getX(0);
            newPosition[1] = newState.getY(0) - 1;

            swap(newState, newPosition);
        }

        return newState;
    }        
}

public class Test 
{
    public Test() 
    {
    }

    public static void main(String args[]) {
        int startState[][] = {{6,2,5}, {1,8,0}, {7,4,3}}, goalState[][] = {{7,6,5}, {8,0,4}, {1,2,3}};

        System.out.println("Solving puzzle using DFS...");
        DFS dfs = new DFS(startState, goalState);
        dfs.search();
    }
}
*/

