import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class TicTacToeServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9001);
		System.out.println("Tic Tac Toe ¼­¹ö°¡ ½ÃÀÛµÇ¾ú½À´Ï´Ù. ");

		try {
			while (true) {
				Game game = new Game();

				Player player1 = new Player(game, ss.accept(), 'X');
				Player player2 = new Player(game, ss.accept(), 'O');

				player1.setOther(player2);
				player2.setOther(player1);

				player1.start();
				player2.start();
				System.out.println("Æä¾î°¡ ¸¸µé¾îÁ³½À´Ï´Ù.");
			}
		} finally {
			ss.close();
		}
	}
}

class Game {
	char[][] boards = new char[5][5];

	public void setBoard(int i, int j, char playerMark) {
		boards[i][j] = playerMark;
	}

	public char getBoards(int i, int j) {
		return boards[i][j];
	}

	public void printBoard() {
		for (int k = 0; k < 5; k++) {
			System.out.println("  " + boards[k][0] + "|  " + boards[k][1] + "|  " + boards[k][2] +"|  " +boards[k][3] + "|  " + boards[k][4]  );
			if (k != 4) {
				System.out.println("---|---|---|---|---");
			}
		}
	}
	
	public void winner(){
		
	}
}

class Player extends Thread {
	Game game;
	Socket socket;
	BufferedReader input;
	PrintWriter output;
	char playerMark;
	Player other;

	public Player(Game g, Socket s, char p) {
		this.game = g;
		this.socket = s;
		this.playerMark = p;
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			output.println("START " + playerMark);
			output.println("PRINT ´Ù¸¥ °æ±âÀÚ¸¦ ±â´Ù¸³´Ï´Ù.");
		} catch (IOException e) {
			System.out.println("¿¬°áÀÌ ²÷¾îÁ³½À´Ï´Ù." + e);
		}
	}
	
	public void setOther(Player other){
		this.other = other;
	}
	
	public void run() {
		try {
			output.println("PRINT ¸ðµç °æ±âÀÚ°¡ ¿¬°áµÇ¾ú½À´Ï´Ù. ");
			
			if (playerMark == 'X') {
				output.println("PRINT ´ç½Å Â÷·ÊÀÔ´Ï´Ù.");
			}
			
			while(true){
				String command = input.readLine();
				if(command == null)
					continue;
				if(command.startsWith("MOVE")) {
					int i = Integer.parseInt(command.substring(5, 6));
					int j = Integer.parseInt(command.substring(7, 8));
					game.setBoard(i,j, playerMark);
					game.printBoard();
					other.output.println("OTHER "+i+" "+j);
					for(int k = 0; k < 5; k++){
						if(game.getBoards(k, 0) == 'O' && game.getBoards(k, 1) == 'O' && game.getBoards(k, 2) == 'O' && game.getBoards(k, 3) == 'O' && game.getBoards(k, 4) == 'O') {
							output.println("PRINT O´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT O´ÔÀÇ ½Â¸® !");
							break;
						} else if(game.getBoards(0, k) == 'O' && game.getBoards(1, k) == 'O' && game.getBoards(2, k) == 'O' && game.getBoards(3, k) == 'O' && game.getBoards(4, k) == 'O'){
							output.println("PRINT O´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT O´ÔÀÇ ½Â¸® !");
							break;
						} else if(game.getBoards(0, 0) == 'O' && game.getBoards(1, 1) == 'O' && game.getBoards(2, 2) == 'O' && game.getBoards(3, 3) == 'O' && game.getBoards(4, 4) == 'O'){
							output.println("PRINT O´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT O´ÔÀÇ ½Â¸® !");
							break;
						} else if(game.getBoards(0, 4) == 'O' && game.getBoards(1, 3) == 'O' && game.getBoards(2, 2) == 'O' && game.getBoards(3, 1) == 'O' && game.getBoards(4, 0) == 'O'){
							output.println("PRINT O´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT O´ÔÀÇ ½Â¸® !");
							break;
						} else if (game.getBoards(k, 0) == 'X' && game.getBoards(k, 1) == 'X' && game.getBoards(k, 2) == 'X' && game.getBoards(k, 3) == 'X' && game.getBoards(k, 4) == 'X') {
							output.println("PRINT X´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT X´ÔÀÇ ½Â¸® !");
							break;
						} else if(game.getBoards(0, k) == 'X' && game.getBoards(1, k) == 'X' && game.getBoards(2, k) == 'X' && game.getBoards(3, k) == 'X' && game.getBoards(4, k) == 'X'){
							output.println("PRINT X´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT X´ÔÀÇ ½Â¸® !");
							break;
						} else if(game.getBoards(0, 0) == 'O' && game.getBoards(1, 1) == 'X' && game.getBoards(2, 2) == 'X' && game.getBoards(3, 3) == 'X' && game.getBoards(4, 4) == 'X'){
							output.println("PRINT X´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT X´ÔÀÇ ½Â¸® !");
							break;
						} else if(game.getBoards(0, 4) == 'X' && game.getBoards(1, 3) == 'X' && game.getBoards(2, 2) == 'X' && game.getBoards(3, 1) == 'X' && game.getBoards(4, 0) == 'X'){
							output.println("PRINT X´ÔÀÇ ½Â¸® !");
							other.output.println("PRINT X´ÔÀÇ ½Â¸® !");
							break;
						} else {
							output.println("PRINT ±â´Ù¸®¼¼¿ä!");
							other.output.println("PRINT ´ç½ÅÂ÷·ÊÀÔ´Ï´Ù.");
						}
					}	
				} else if (command.startsWith("QUIT")){
					return;
				}
			}
		} catch(IOException e) {
			System.out.println("¿¬°áÀÌ ²÷¾îÁ³½À´Ï´Ù."+e);
		} finally{
			try{
				socket.close();
			} catch (IOException e) {

			}
		}
	}
}
