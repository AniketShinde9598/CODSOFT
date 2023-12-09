package com.codsofttask3.main;

import java.util.Scanner;

class BankAccount {
	private double balance;

	public BankAccount(double initialBalance){
		this.balance = initialBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		else {
			return false;
		}
	}
}

public class ATM {
	private BankAccount userAccount;

	public ATM(BankAccount userAccount) {
		this.userAccount = userAccount;
	}

	public void withdraw(double amount) {
		if(userAccount.withdraw(amount)) {
			System.out.println("Withdrawal Successful. Remaining Balance: Rs." + userAccount.getBalance());
		}
		else {
			System.out.println("Insufficient Balance. Withdrawal failed.");
		}
	}

	public void deposit(double amount) {
		userAccount.deposit(amount);
		System.out.println("Deposit Successful. New balance: Rs." + userAccount.getBalance());
	}

	public void checkBalance() {
		System.out.println("Current Balance: Rs." + userAccount.getBalance());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount userAccount = new BankAccount(3100);
		ATM atmMachine = new ATM(userAccount);

		while(true) {
			System.out.println("Choose an option:");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");

			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Enter Withdrawal amount:");
					double withdrawAmount = sc.nextDouble();
					if(withdrawAmount > 0) {
						atmMachine.withdraw(withdrawAmount);
					}
					else {
						System.out.println("Invalid amount. Please enter a positive value.");
					}
					break;
					
				case 2:
					System.out.println("Enter deposit amount:");
					double depositAmount = sc.nextDouble();
					if(depositAmount > 0) {
						atmMachine.deposit(depositAmount);
					}
					else {
						System.out.println("Invalid amount. Please enter a positive value.");
					}
					break;

				case 3:
					atmMachine.checkBalance();
					break;
				
				case 4:
					System.out.println("Exiting ATM. Thank you for using Aniket's ATM.");
					sc.close();
					return;

				default:
					System.out.println("Invalid choice. Please choose a valid option.");
			}
		}
	}
}