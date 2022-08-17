package com.revature.models;

import java.util.ArrayList;

public class Orders
{
	private ArrayList<LineItmes> lineItems = new ArrayList<>();
	private StoreFront store = new StoreFront();//get the location for this
	private double totalPrice;
	
}
