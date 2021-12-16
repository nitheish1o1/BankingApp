package com.mypack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        Subject subject = new Subject();
        new Message_observer(subject);
        new Mail_observer(subject);
        System.out.println("***hi welcome to banking app***");
        int decider;

        do {
            int input;
            while (true) {
                System.out.printf("enter %d to withdraw\nenter %d to deposit\nenter %d to send\nenter %d to receive\nenter %d to print transaction history\nenter %d to print bank statement", 1, 2, 3, 4, 5, 6);
                input = scanner.nextInt();
                if(1<=input && input <= 6){
                    break;
                }
                else {
                    System.out.println("please enter valid input:(");
                }
            }

            switch (input) {
                case 1 -> {
                    System.out.print("enter amount: ");
                    int amount = scanner.nextInt();
                    Context context = new Context(new Withdraw());
                    context.execute_stratergy(amount);
                    TransactionRepository.transaction_array.add(amount * -1);
                    subject.setState(amount * -1);
                    Proxyfile.is_transaction = true;
                }
                case 2 -> {
                    System.out.print("enter amount: ");
                    int amount = scanner.nextInt();
                    Context context = new Context(new Deposit());
                    context.execute_stratergy(amount);
                    TransactionRepository.transaction_array.add(amount);
                    subject.setState(amount);
                    Proxyfile.is_transaction = true;
                }
                case 3 -> {
                    System.out.print("enter amount: ");
                    int amount = scanner.nextInt();
                    Context context = new Context(new Send());
                    context.execute_stratergy(amount);
                    TransactionRepository.transaction_array.add(amount * -1);
                    subject.setState(amount * -1);
                    Proxyfile.is_transaction = true;
                }
                case 4 -> {
                    System.out.print("enter amount: ");
                    int amount = scanner.nextInt();
                    Context context = new Context(new Receive());
                    context.execute_stratergy(amount);
                    TransactionRepository.transaction_array.add(amount);
                    subject.setState(amount);
                    Proxyfile.is_transaction = true;
                }
                case 5 -> {
                    TransactionRepository transactions = new TransactionRepository();

                    for (Iterator iterator = transactions.getIterator(); iterator.hasnext(); ) {
                        int cost = (int) iterator.next();
                        if (cost < 0) {
                            System.out.println("debeted RS: " + Math.abs(cost));
                        } else {
                            System.out.println("credited RS: " + cost);
                        }

                    }
                }
                case 6 -> {
                    Proxyfile.getfile();
                    Proxyfile.is_transaction = false;
                }
            }
            while (true){
                System.out.println("Enter ----> '1' to continue /// '0' to quit");
                decider = scanner.nextInt();
                if(decider == 0 || decider == 1){
                    break;
                }
                else {
                    System.out.println("please entervalid input:(");
                    }
            }
        } while (decider == 1);

    }
}
