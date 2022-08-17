package com.revature.ui;

import java.util.Scanner;

import com.revature.models.Products;
import com.revature.service.ProductService;

public class ProductCart
{
	/*
	 * this one will ask about looking at video games
	 * see the list
	 * add to cart
	 * checkout cart
	 * delete product from cart
	 * create menu that goes inside the addCustomer function
	 * 
	 * */
	Scanner sc = new Scanner(System.in);
	
	public void videoGameCart()
	{
		ProductService productService = new ProductService();
		Products products = new Products();
		
		String userInput = "";
		
		do
		{
			System.out.println();
			System.out.println("========================================================");
			System.out.println("Welcome to your cart");
			System.out.println("[1] Show all inventory");
			System.out.println("[2] Request a game and instantly add it to your cart. "
					+ "\nWe expect  you to add a fair price to the game ;)");
			
			System.out.println("[x] exit ");
			
			userInput = sc.nextLine();
			
			switch(userInput)
			{
			case "1":
				System.out.println("List of games: ");
				Menu.printItem(productService.findAllProducts());
				break;
				
			case "2":
				addGames();
				break;
				
				
			case "x":
				System.out.println("Going back to main menu... ");
				break;
				
			default:
				break;
			}
			
		}while(!userInput.equals("x"));
	}//we have to add games
	//they can add them manually or not. Just for testing
	
	public static void addGames()
	{
		Products products = new Products();
		ProductService productService = new ProductService();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What game do you wish to add? ");
		System.out.println("Enter requested video game info.");
		System.out.println("Game name: ");
		products.setName(sc.nextLine());
		
		System.out.println("==============================");
		
		System.out.println("Enter a fair price: ");
		products.setCost(sc.nextDouble());
		
		System.out.println("==============================");

		System.out.println("Genre not needed ");
		products.setCategory(sc.nextLine());//do not remove this line!
		
		productService.save(products);


	}
}
