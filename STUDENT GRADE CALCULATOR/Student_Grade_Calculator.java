package com.codsofttask2.main;

import java.util.Scanner;

public class Student_Grade_Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input: Take marks obtained in each subject
		System.out.println("Enter marks obtained in each subject (out of 100) : ");
		int numberOfSubjects = 8;
		int[] marks = new int[numberOfSubjects];
		
		for (int i = 0; i < numberOfSubjects; i++) {
			System.out.print("Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
		}
		
		//Calculate Total Marks
		int totalMarks = calculateTotalMarks(marks);
		
		//Calculate Average Percentage
		double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
		
		//Calculation Grade
		char grade = calculateGrade(averagePercentage);
		
		//Display Results
		displayResults(totalMarks, averagePercentage, grade);
		
		scanner.close();
	}
	
	//Method to calculate Total Marks 
	public static int calculateTotalMarks(int[] marks) {
		int totalMarks = 0;
		for(int mark :marks) {
			totalMarks += mark;
		}
		return totalMarks;
	}
	
	//Method to calculate Average Percentage
	public static double calculateAveragePercentage(int totalMarks,int numberOfSubjects) {
		return (double) totalMarks / numberOfSubjects;
	}
	
	//Method to calculate Grade
	public static char calculateGrade(double averagePercentage) {
		if (averagePercentage >= 85) {
			return 'A';
		}
		else if(averagePercentage >= 70) {
			return 'B';
		}
		else if(averagePercentage >= 55) {
			return 'C';
		}
		else if(averagePercentage > 40) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	
	//Method to display Results
	public static void displayResults(int totalMarks , double averagePercentage , char grade) {
		System.out.println("\nResults : ");
		System.out.println("Total Marks : " + totalMarks);
		System.out.println("Average Percentage : " + averagePercentage + "%.");
		System.out.println("Grade : " + grade);
	}
}