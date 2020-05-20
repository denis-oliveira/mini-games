import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gameSelection = " ";
        String lastGame = " ";
        char cont;

        while (true) {

            if(gameSelection.equals(" ") || gameSelection.equals("menu")) {
                gameSelection = " ";
                while (!gameSelection.equals("movie") && !gameSelection.equals("oae")) {
                    System.out.println("Choose a game to play. Type \"movie\" to play Movie Guess game or \"oae\" to " +
                            "play Odds and Even game.");
                    try {
                        gameSelection = scanner.next().toLowerCase();
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Please type a valid input.");
                    }
                    if(!gameSelection.equals("movie") && !gameSelection.equals("oae")) {
                        System.out.println("Please, type a valid option.");
                    }
                }
                lastGame = gameSelection;
            }

            if(gameSelection.equals("movie") || (gameSelection.equals("again") && lastGame.equals("movie"))) {
                System.out.println("Game: Guess the movie");

                MovieGuessGame movieGame = new MovieGuessGame();

                while(movieGame.getWrongGuesses() < 10 && !movieGame.getWinStatus()){
                    System.out.println("\n===================================================================");
                    System.out.println("You are guessing: " + movieGame.getStringToShow());
                    System.out.println("You have guessed (" + movieGame.getWrongGuesses() + ") wrong letter(s).");
                    System.out.println("Guess a letter: ");
                    // Gets user input (letter to guess)
                    try {
                        // Gets the user input (letter to guess the movie)
                        movieGame.guessLetter(scanner.next().toLowerCase());
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("======================");
                        System.out.println("You must type a letter");
                        System.out.println("======================");
                    }
                    System.out.println("===================================================================");
                }

                // Checks if the user won or lost
                System.out.println("\n===================================================================");
                if(movieGame.getWinStatus()) {
                    System.out.println("You won!");
                    System.out.println("You have guessed \"" + movieGame.getMovieToGuess() + "\" correctly.");
                } else {
                    System.out.println("You lost! The movie to guess was \"" + movieGame.getMovieToGuess() + "\".");
                }
                System.out.println("===================================================================");

            } else if (gameSelection.equals("oae") || (gameSelection.equals("again") && lastGame.equals("oae"))) {

                System.out.println("Game: Odds and Even");
                String userOddOrEvenChoice = " ";
                while(!userOddOrEvenChoice.equals("even") && !userOddOrEvenChoice.equals("odd")) {
                    try {
                        System.out.println("Choose if you want to be even or odd. Type \"even\" or \"odd\".");
                        userOddOrEvenChoice = scanner.next().toLowerCase();
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Please type a valid input.");
                    }
                }

                int userMove = -1;
                System.out.println("Type a number between 0 and 5");
                while (userMove < 0 || userMove > 5) {
                    try {
                        userMove = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Enter a valid input (number between 0 and 5)");
                    }
                }

                OddsAndEvenGame oddsAndEvenGame = new OddsAndEvenGame();
                oddsAndEvenGame.play(userMove, userOddOrEvenChoice);
            }

            gameSelection = " ";
            while (!gameSelection.equals("again") && !gameSelection.equals("menu") && !gameSelection.equals("end")) {
                System.out.println("Type \"menu\" to go to game selection menu or \"again\" to play the same game " +
                        "again or \"end\" to stop playing.");
                try {
                    gameSelection = scanner.next().toLowerCase();
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Please type a valid input.");
                }
                if(!gameSelection.equals("again") && !gameSelection.equals("menu") && !gameSelection.equals("end")) {
                    System.out.println("Please, type a valid option.");
                }
            }

            if(gameSelection.equals("end")) {
                break;
            }
        }
        scanner.close();
    }
}
