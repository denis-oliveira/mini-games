public class OddsAndEvenGame {
    private static int victories = 0;
    private static int losses = 0;

    public void play(int userMove, String userOddOrEvenChoice) {
        int machineMove = (int) (Math.random() * 5) + 1;
        System.out.println("\n===================================================================");
        System.out.println("User move: " + userMove);
        System.out.println("Computer move: " + machineMove);
        System.out.println("User Odd or Even choice: " + userOddOrEvenChoice);

        int sum = machineMove +  userMove;

        if(sum % 2 == 0) {
            // even number
            System.out.println("Sum result: " + sum + " (even)");
            if(userOddOrEvenChoice.equals("even")) {
                System.out.println("You won!");
                OddsAndEvenGame.victories++;
            } else {
                System.out.println("You lost!");
                OddsAndEvenGame.losses++;
            }
        } else {
            // odd number
            System.out.println("Sum result: " + sum + " (odd)");
            if(userOddOrEvenChoice.equals("odd")) {
                System.out.println("You won!");
                OddsAndEvenGame.victories++;
            } else {
                System.out.println("You lost!");
                OddsAndEvenGame.losses++;
            }
        }
        System.out.println("You won " + OddsAndEvenGame.victories + " time(s).");
        System.out.println("You lost " + OddsAndEvenGame.losses + " time(s).");
        System.out.println("===================================================================");
    }
}
