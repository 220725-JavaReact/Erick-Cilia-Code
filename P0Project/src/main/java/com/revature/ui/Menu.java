package com.revature.ui;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.service.CustomerService;
import com.revature.service.ProductService;

public class Menu
{

	public static void main(String[] args)//probably going to call this something else, then called into the driver method
	{
		Scanner sc = new Scanner(System.in);

		// TODO Auto-generated method stub
		CustomerService customerService = new CustomerService();
		Customer customer = new Customer();
		
		String userInput = "";
		
		do
		{
			System.out.println();
			System.out.println("========================================================");
			System.out.println("================>>NOW AT THE MAIN MENU<<================");
			System.out.println("[1] Display store description");
			System.out.println("[2] List all customers");
			System.out.println("[3] Add new customer");
			System.out.println("[4] Delete customer");
			System.out.println("[5] Update customer");
			System.out.println("[x] Exit application");
			
			userInput = sc.nextLine();
			
			switch(userInput)
			{
			case "1":
				System.out.println("We are a fictional video game store in a universe where "
						+ "digital media has not destoyed the sales of physical game copies. "
						+ "\nHappy Shopping!");
				break;
				
			case "2":
				System.out.println("Here is a list of customers: ");
				Menu.printItem(customerService.findAllCustomers());//edit the toString for this one
				break;
				
			case "3":
				addCustomer();//this should take me to their account to purchase video games
				break;
				
			case "4":
				System.out.println("Enter customer name to delete: ");
				customer.setName(sc.nextLine());
				customerService.delete(customer);
				System.out.println("Deleting. . .");
				break;
				
			case "5":
				System.out.println("Not yet implemented");
				break;
				
			case "x":
				System.out.println("Thanks for shopping at Eddie's Game Shop!!");
				break;
				
			default:
				break;
			}

		}while(!userInput.equals("x"));

		// Menu.printItem(customerService.findAllCustomers());
//
//		System.out.println("Enter new user info.");
//		System.out.println("Enter name: ");
//		customer.setName(sc.next());
//
//		System.out.println("==============================");
//
//		System.out.println("Enter address: ");
//		customer.setAddress(sc.next());
//
//		System.out.println("==============================");
//
//		System.out.println("enter email: ");
//		customer.setEmail(sc.next());
//
//		customerService.save(customer);

//		System.out.println();
//		//place delete here
//		System.out.println("enter to delete: ");
//		customer.setName(sc.next());
//		customerService.delete(customer);
//
//		Menu.printItem(customerService.findAllCustomers());


	}

	public static void printItem(Object item)
	{
		if (item instanceof Iterable)
		{
			Iterable iterable = (Iterable) item;
			for (Object o : iterable)
			{
				System.out.println("========================================================");
				System.out.println(o);
			}
		} else if (item instanceof Object[])
		{
			Object[] array = (Object[]) item;
			for (Object o : array)
			{
				System.out.println(o);
			}
		} else
			System.out.println(item);
	}
	
	public static void addCustomer()
	{
		Customer customer = new Customer();
		CustomerService customerService = new CustomerService();
		ProductCart productCart = new ProductCart();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new customer info.");
		System.out.println("Enter name: ");
		customer.setName(sc.nextLine());

		System.out.println("==============================");

		System.out.println("Enter address: ");
		customer.setAddress(sc.nextLine());

		System.out.println("==============================");

		System.out.println("Enter email: ");
		customer.setEmail(sc.nextLine());
		
		
		customerService.save(customer);
		
		//call the menu function for the video game
		productCart.videoGameCart();
		


	}

}
