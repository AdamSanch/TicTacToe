/*  Adam Sanchez
    abs15d
    Assignment 3
*/

import java.util.Scanner;


public class TicTacToe2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matrix = new int[3][3];                         //Matrix for board
        int x, y, client, i, turn = 0;                          //'i' and 'turn' are used as loop conditions
        boolean moveCheck, fullCheck;                           //variables that hold method results

        //Initializing matrix with '0'
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++)
                matrix[a][b] = 0;
        }

        //Welcome message, printing board coordinates, and printing empty starting board.
        System.out.println("Welcome to Tic Tac Toe!\nPlease type the x and y coordinate for an empty space to enter a move.");
        System.out.println("Board coordinates are as follows:");
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++)
                System.out.print("(" + a + "," + b + ") ");
            System.out.println();
        }
        System.out.println("Enter '0' to force quit the game.\n");
        System.out.println("Starting board:");
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++)
                System.out.print(matrix[a][b] + " ");
            System.out.println();
        }

        //First while loop runs until 9 turns have been played
        while (turn < 9) {
            i=0;

            //determines who's turn is up, alternates every turn
            if (turn % 2 == 0)
                client = 1;
            else
                client = 2;

            /*Loop takes in users move, and uses methods to determine if move can be made. If so, 'i' is changed
                and loop breaks. Otherwise, 'i' stays as 0 and loop continues, asking user for another move.*/
            while(i==0) {
                System.out.println("\nclient " + client + "'s move:");

                //If user enters '0', both loops break and game ends.
                x = input.nextInt();
                if(x==0){
                    turn=9;
                    break;
                }
                y = input.nextInt();

                //Calling move() method.
                moveCheck = move(x, y, client, matrix);

                //If move is successful, print board and break move loop. If not, ask for new input.
                if (moveCheck) {
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++)
                            System.out.print(matrix[a][b] + " ");
                        System.out.println();
                    }
                    i=1;
                }
                else {
                    System.out.print("Invalid move. Please try again:\n");
                }
            }

            //Checking if board is full.
            fullCheck=isFull(matrix);
            if(fullCheck){
                System.out.println("Board is full.");
                turn=9;
            }
            turn++;
        }

        System.out.println("Thanks for playing!");
        input.close();
    }

    //Move method takes in user move location, player number, and board matrix to determines if move is valid.
    private static boolean move(int row, int col, int player, int[][] mat) {

        boolean check;                          //keeps track if move is valid or not

        /*Check which row was called. Then check which column was called. If space is valid and contains '0',
            change space to players number and return true. If space is not valid or does not contain '0',
            return false. */
        if(row==1) {
            if (col == 1) {
                if (mat[0][0] == 0) {
                    mat[0][0] = player;
                    check=true;
                }
                else
                    check=false;
            }
            else if (col == 2) {
                if (mat[0][1] == 0) {
                    mat[0][1] = player;
                    check=true;
                }
                else
                    check=false;
            }
            else if (col == 3) {
                if (mat[0][2] == 0) {
                    mat[0][2] = player;
                    check=true;
                }
                else
                    check=false;
            }
            else
                check=false;
        }
        else if(row==2) {
            if (col == 1) {
                if (mat[1][0] == 0) {
                    mat[1][0] = player;
                    check=true;
                }
                else
                    check=false;
            }
            else if (col == 2) {
                if (mat[1][1] == 0) {
                    mat[1][1] = player;
                    check=true;
                }
                else
                    check=false;
            }
            else if (col == 3) {
                if (mat[1][2] == 0) {
                    mat[1][2] = player;
                    check=true;
                }
                else
                    check=false;
            }
            else
                check=false;
        }
        else if(row==3){
                if (col == 1) {
                    if (mat[2][0] == 0) {
                        mat[2][0] = player;
                        check=true;
                    }
                    else
                        check=false;
                }
                else if (col == 2) {
                    if (mat[2][1] == 0) {
                        mat[2][1] = player;
                        check=true;
                    }
                    else
                        check=false;
                }
                else if (col == 3) {
                    if (mat[2][2] == 0) {
                        mat[2][2] = player;
                        check=true;
                    }
                    else
                        check=false;
                }
                else
                    check=false;
        }
        else
            check=false;
        return check;
    }

    /*isFull method cycles through each space on the board matrix. If there is a '0' found, board is not
        full and method returns false. If no '0' is found, board is full and method returns true.*/
    private static boolean isFull(int[][] mat) {
        boolean check=true;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++){
                if(mat[a][b]==0){
                    check=false;
                    break;
                }
            }
        }
        return check;
    }
}

