public class OddsAndEvenGame {

    public void play(int userMove, String userOddOrEvenChoice) {
        int machineMove = (int) (Math.random() * 5) + 1;
        System.out.println("User move: " + userMove);
        System.out.println("Computer move: " + machineMove);
        System.out.println("User Odd or Even choice: " + userOddOrEvenChoice);

        int sum = machineMove +  userMove;

        if(sum % 2 == 0) {
            // even number
            System.out.println("Sum result: " + sum + " (even)");
            if(userOddOrEvenChoice.equals("even")) {
                System.out.println("You won!");
            } else {
                System.out.println("You lost!");
            }
        } else {
            // odd number
            System.out.println("Sum result: " + sum + " (odd)");
            if(userOddOrEvenChoice.equals("odd")) {
                System.out.println("You won!");
            } else {
                System.out.println("You lost!");
            }
        }
    }
}
