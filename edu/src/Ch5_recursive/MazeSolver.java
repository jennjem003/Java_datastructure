package Ch5_recursive;

import java.util.Scanner;
import java.util.Stack;

class Items {
	int x, y, dir;
	public boolean[][] maze;

	public Items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public String toString() {
		return x + "," + y + "," + dir;
	}
}

class Offsets {
	int a, b;
}

public class MazeSolver {
	static final int N = 0, NE = 1, E = 2, SE = 3, S = 4, SW = 5, W = 6, NW = 7;
	static final Offsets[] moves = new Offsets[8];
	static int[][] maze = new int[100][100];
	static int[][] mark = new int[100][100];

	public static void path(int m, int p) {
		// start at (1,1)
		mark[0][0] = 0;
		Stack<Items> stack = new Stack<Items>();
		Items temp = new Items(1, 1, E);
		stack.push(temp);

		while (!stack.isEmpty()) { // stack not empty
			temp = stack.pop(); // unstack
			int i = temp.x;
			int j = temp.y;
			int d = temp.dir;
			while (d < 8) { // moves forward
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == m) && (h == p)) { // reached exit
					// output path
					System.out.println(stack);
					System.out.println("the term near the exit: " + i + " " + j);
					System.out.println("exit: " + m + " " + p);
					return;
				}

				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					mark[g][h] = 1;
					// push the old temp to the stack, but the direction changes.
					// Because the neighbor in the direction of d has been checked.
					temp.x = i;
					temp.y = j;
					temp.dir = d + 1;
					stack.push(temp); // stack it
					i = g;
					j = h;
					d = N; // moves to (g,h)
				} else
					d++; // try next direction
			}
		}
		// cout << "no path in maze " << endl;

		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {
		int[][] input = { 
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 }, 
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 }, 
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, 
				};
		
		for (int i = 0; i<8; i++)
			moves[i] = new Offsets();
		
		moves[N].a = -1;
		moves[N].b = 0;
		moves[NE].a = -1;
		moves[NE].b = 1;
		moves[E].a = 0;
		moves[E].b = 1;
		moves[SE].a = 1;
		moves[SE].b = 1;
		moves[S].a = 1;
		moves[S].b = 0;
		moves[SW].a = 1;
		moves[SW].b = -1;
		moves[W].a = 0;
		moves[W].b = -1;
		moves[NW].a = -1;
		moves[NW].b = -1;
		// moves[0] = new move(1, 0);

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if (i == 0 || j == 0 || i == 13 || j == 16) {
					maze[i][j] = 1;
				} else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;
			}
		}
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		path(12, 15);

		int end;
		 //Scanner scanner = new Scanner(System.in);
		 //end = scanner.nextInt();
	}
}
