package machine;
import java.util.Scanner;


// main class
public class CoffeeMachine {

    public static final String incorrectInput = "Unknown operation. Please, try again.";
    public static String state = "choosing an action";


    // main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            switch (state) {

                case "choosing an action":
                    System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                    Operations.operationProcessing(userInput = scanner.next());
                    break;

                case "choosing a type of coffee":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte," +
                            "3 - cappuccino, " + "back - to main menu:");
                    Operations.commandCoffee(userInput = scanner.next());
                    break;

                case "filling the machine":
                    System.out.println("\nWrite how many ml of water you want to add:");
                    Operations.waterToAdd = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    Operations.milkToAdd = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    Operations.beansToAdd = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    Operations.cupsToAdd = scanner.nextInt();
                    Operations.commandFill();
                    break;
            }
        } while (!userInput.equals("exit"));
    }
}


// class performing operations with the machine
class Operations {

    // the ingredients that are in the coffee machine at the beginning
    static int waterInMachine = 400;
    static int milkInMachine = 540;
    static int beansInMachine = 120;
    static int cupsInMachine = 9;
    static int moneyInMachine = 550;

    // variables used to show costs of producing one cup of coffee
    static int waterForOneCup;
    static int milkForOneCup;
    static int beansForOneCup;
    static int cup;
    static int priceForOneCup;

    // variables used to show ingredients needed to add to the machine
    static int waterToAdd;
    static int milkToAdd;
    static int beansToAdd;
    static int cupsToAdd;


    // method to process a user's operation by the machine
    public static void operationProcessing(String command) {

        switch (command) {

            case "buy":
                CoffeeMachine.state = "choosing a type of coffee";
                break;

            case "fill":
                CoffeeMachine.state = "filling the machine";
                break;

            case "take":
                Operations.commandTake();
                break;

            case "remaining":
                Operations.commandRemaining();
                break;

            case "exit":
                break;

            default:
                System.out.println(CoffeeMachine.incorrectInput);
        }
    }


    // method to choose a type of coffee by a user
    public static void commandCoffee(String command) {

        waterToAdd = 0;
        milkToAdd = 0;
        beansToAdd = 0;
        cupsToAdd = 0;

        boolean canMakeCoffee = true;

        // variants of available coffee
        switch (command) {

            // espresso
            case "1":
                waterForOneCup = 250;
                beansForOneCup = 16;
                cup = 1;
                priceForOneCup = 4;
                if (waterForOneCup > waterInMachine) {
                    System.out.println("Sorry, not enough water!");
                    canMakeCoffee = false;
                }
                if (beansForOneCup > beansInMachine) {
                    System.out.println("Sorry, not enough beans!");
                    canMakeCoffee = false;
                }
                if (cup > cupsInMachine) {
                    System.out.println("Sorry, not enough cups!");
                    canMakeCoffee = false;
                }
                if (canMakeCoffee) {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            // latte
            case "2":
                waterForOneCup = 350;
                milkForOneCup = 75;
                beansForOneCup = 20;
                cup = 1;
                priceForOneCup = 7;
                if (waterForOneCup > waterInMachine) {
                    System.out.println("Sorry, not enough water!");
                    canMakeCoffee = false;
                }
                if (milkForOneCup > milkInMachine) {
                    System.out.println("Sorry, not enough milk!");
                    canMakeCoffee = false;
                }
                if (beansForOneCup > beansInMachine) {
                    System.out.println("Sorry, not enough beans!");
                    canMakeCoffee = false;
                }
                if (cup > cupsInMachine) {
                    System.out.println("Sorry, not enough cups!");
                    canMakeCoffee = false;
                }
                if (canMakeCoffee) {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            // cappuccino
            case "3":
                waterForOneCup = 200;
                milkForOneCup = 100;
                beansForOneCup = 12;
                cup = 1;
                priceForOneCup = 6;
                if (waterForOneCup > waterInMachine) {
                    System.out.println("Sorry, not enough water!");
                    canMakeCoffee = false;
                }
                if (milkForOneCup > milkInMachine) {
                    System.out.println("Sorry, not enough milk!");
                    canMakeCoffee = false;
                }
                if (beansForOneCup > beansInMachine) {
                    System.out.println("Sorry, not enough beans!");
                    canMakeCoffee = false;
                }
                if (cup > cupsInMachine) {
                    System.out.println("Sorry, not enough cups!");
                    canMakeCoffee = false;
                }
                if (canMakeCoffee) {
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            // back to main menu
            case "back":
                break;

            default:
                System.out.println(CoffeeMachine.incorrectInput);
                break;
        }
        if (canMakeCoffee) {
            restCalculating();
        }
        CoffeeMachine.state = "choosing an action";
    }


    // method to fill the machine with the ingredients
    public static void commandFill() {

        waterForOneCup = 0;
        milkForOneCup = 0;
        beansForOneCup = 0;
        cup = 0;
        priceForOneCup = 0;

        restCalculating();
        CoffeeMachine.state = "choosing an action";
    }


    // method to withdraw money from the machine
    public static void commandTake() {

        System.out.println("\nI gave you $" + moneyInMachine);
        moneyInMachine = 0;
        CoffeeMachine.state = "choosing an action";
    }


    // the method to show the rest of the ingredients in the machine
    public static void commandRemaining() {

        // the ingredients that are in the coffee machine after an operation
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterInMachine + " ml of water");
        System.out.println(milkInMachine + " ml of milk");
        System.out.println(beansInMachine + " g of coffee beans");
        System.out.println(cupsInMachine + " disposable cups");
        System.out.println("$" + moneyInMachine + " of money");
        CoffeeMachine.state = "choosing an action";
    }


    // method to calculate the rest of the ingredients in the machine
    public static void restCalculating() {

        waterInMachine = waterInMachine - waterForOneCup + waterToAdd;
        milkInMachine = milkInMachine - milkForOneCup + milkToAdd;
        beansInMachine = beansInMachine - beansForOneCup + beansToAdd;
        cupsInMachine = cupsInMachine - cup + cupsToAdd;
        moneyInMachine = moneyInMachine + priceForOneCup;
    }
}