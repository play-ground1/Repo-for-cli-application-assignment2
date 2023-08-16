import java.util.Scanner;

public class Cli_assignment2 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";

        final String RESET = "\033[0m";

        final String DASHBOARD = " Welcome to Smart Banking";
        final String CREATE_ACCOUNT = "Create New Account";
        final String DEPOSIT = "Deposit";
        final String WITHDRAWS="Withdraws";
        final String TRANSFER="Transfer";
        final String CHECK_ACCOUNT_BALANCE="Check Account Balance ";
        final String DELETE_ACCOUNT="Delete Account";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);


        String[][] customers = new String[0][];
        //double[] balances = new double[0];
        //String[] customerIds = new String[0];
        String screen = DASHBOARD;

        do {
            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("-".repeat(30));
            System.out.println(" ".repeat((30 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));
            System.out.println("-".repeat(30));

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\n[1]. Create New Account ");
                    System.out.println("[2]. Deposit");
                    System.out.println("[3]. Withdraw");
                    System.out.println("[4]. Transfer");
                    System.out.println("[5]. Check Accounnt Balance");
                    System.out.println("[6]. Delete");
                    System.out.println("[7]. Exit\n");
                    System.out.print("Enter an option to continue > ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen = CREATE_ACCOUNT; break;
                        case 2: screen = DEPOSIT; break;
                        case 3: screen = WITHDRAWS; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                        case 6: screen = DELETE_ACCOUNT; break;


                        case 7: System.exit(0); break;
                        default: continue;
                    }
                    break;
                    case CREATE_ACCOUNT:

                    boolean valid;
                    String name;
                    double deposit;
                    String id = "SDB-" + String.format("%05d", (customers.length + 1)); 

                    System.out.printf("New Customer ID: %s \n", id);
                

                   
                    do{
                        valid = true;
                        System.out.print("Name: ");
                        name = SCANNER.nextLine().strip();
                        if (name.isBlank()){
                            System.out.printf("%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf("%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    do{

                        System.out.print("Initial Deposit (Rs.): ");
                        deposit =SCANNER.nextDouble();SCANNER.nextLine();

                        if(!(deposit>=5000.00)){
                            valid = false;
                            System.out.printf("%sInsufficient Amount. Initial deposit should be more than Rs.5000.00%s \n",COLOR_RED_BOLD, RESET);
    
                    }

                    }while(!valid);


                    String[][] newCustomers = new String[customers.length + 1][3];
                  
                    for (int i = 0; i < customers.length; i++) {
                        newCustomers[i] = customers[i];
                    }
                    newCustomers[newCustomers.length -1][0] = id;
                    newCustomers[newCustomers.length -1][1] = name;
                    newCustomers[newCustomers.length -1][2] = Double.toString(deposit);;
                    
                   
                    customers = newCustomers;
                    

                    System.out.println();
                    System.out.print(name + " added sucessfully. Do you want to add new customer (Y/n)? ");
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;


                    case DEPOSIT:
                
                    // do {
                    //     valid = true;
                    //     System.out.print("\tEnter New Customer ID: ");  // C-ac
                    //     id = SCANNER.nextLine().toUpperCase().strip();
                    //     if (id.isBlank()){
                    //         System.out.printf(ERROR_MSG, "ID can't be empty");
                    //         valid = false;
                    //      }else if (!(id.startsWith("SDB-") || id.length() < 5)){
                    //          System.out.printf(ERROR_MSG, "Invalid ID format");
                    //          valid = false;
                    //     }else{
                    //         String number = id.substring(2);
                    //         for (int i = 0; i < number.length(); i++) {
                    //             if (!Character.isDigit(number.charAt(i))){
                    //                 System.out.printf(ERROR_MSG, "Invalid ID format");
                    //                 valid = false;
                    //                 break;
                    //             }
                    //         }
                            
                    //     }
                    // }while (!valid);


                }



            }while(true);

        }

    }