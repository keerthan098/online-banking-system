import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Bank Management ---");
            System.out.println("1. Add User");
            System.out.println("2. Show Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Show All Users");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();
                    ApiClient.addUser(name, bal);
                    break;
                case 2:
                    sc.nextLine(); 

                    System.out.print("Enter user ID: ");
                    String uid = sc.nextLine().trim();

                    double curBal = ApiClient.getBalanceById(uid);
                    if (curBal == -1) {
                        System.out.println("User not found");
                    } else {
                        System.out.println("Current Balance: " + curBal);
                    }
                    break;

                case 3:
                    sc.nextLine();

                    System.out.print("Enter user ID: ");
                    String depId = sc.nextLine().trim();

                    double currentBal = ApiClient.getBalanceById(depId);
                    if (currentBal == -1) {
                        System.out.println("User not found");
                        break;
                    }

                    System.out.print("Enter deposit amount: ");
                    double dep = Double.parseDouble(sc.nextLine().trim());

                    ApiClient.updateBalance(depId, currentBal + dep);
                    break;

                case 4:
                    sc.nextLine();

                    System.out.print("Enter user ID: ");
                    String wid = sc.nextLine().trim();

                    double wBal = ApiClient.getBalanceById(wid);
                    if (wBal == -1) {
                        System.out.println("User not found");
                        break;
                    }

                    System.out.print("Enter withdraw amount: ");
                    double amt = Double.parseDouble(sc.nextLine().trim());

                    if (amt > wBal) {
                        System.out.println("Insufficient balance");
                    } else {
                        ApiClient.updateBalance(wid, wBal - amt);
                    }
                    break;


                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
