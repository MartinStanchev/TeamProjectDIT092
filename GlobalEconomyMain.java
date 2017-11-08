package test;
//you may need to change the package to match your project's package.

import java.util.Scanner;

public class GlobalEconomyMain {
	
	private static final int REGISTER_COUNTRY = 1;
	private static final int PRINT_COUNTRIES = 2;
	private static final int PRINT_COUNTRY = 3;
	private static final int INJECT_MONEY = 4;
	private static final int PAY_DEBT = 5;
	//private static final int QUIT = 6000;
		
	private Country[] countries;
	private int registeredCountries;
	private Scanner input;
	
	/*
	 * Constructor to initialize your data set of countries.
	 * It begins empty. The default size is 5 countries. 
	 */
	public GlobalEconomyMain() {
		final int MAX_COUNTRIES = 5;
		this.countries = new Country[MAX_COUNTRIES];
		this.registeredCountries = 0;
		input = new Scanner(System.in);
	}
	
	/*
	 * This method will retrieve a country from the array based on a specified name.
	 * If the country was not created and added to the array, it will return NULL,
	 * meaning that the country does not exist in the system.
	 * 
	 */
	public Country retrieveCountry(String countryName) {
		for (int i = 0; i < this.countries.length; i++) {
			//ask yourself, why do I check null first?
			if(countries[i] != null && countries[i].getName() == countryName) {
				//I found the country, return it then.
				return countries[i];
			}
		}
		
		//example of a null... if no country 
		//   with the give name exists, the 
		//   object does not exist (i.e. "nothing").
		return null;
	}
	
	public Country createCountry() {		
		//TODO: Add logic to this method.
		//
		//1. read the country's name, population and GDP.
		//2. use that information to create the country.
		//3. change the null below to the 
		// right reference that you need to return!!
		return null; //<--- change this.
	}	
	
	public void run() {
		
		int option;
		do {
			printMenuOptions();
			System.out.print(" Type the option number: ");
			
			option = input.nextInt();
			input.nextLine(); //this skips the enter 
							  //that the user types after 
							  //typing the integer option.
			
			switch (option) {
			case REGISTER_COUNTRY:
				
				Country newCountry = createCountry();
				this.countries[registeredCountries] = newCountry;
				this.registeredCountries = this.registeredCountries + 1;
				
				break;
	
			case PRINT_COUNTRIES:
				printAllCountries();
				break;
	
			case PRINT_COUNTRY:
				printOneCountry();				
				break;
	
			case INJECT_MONEY:
				injectMoney();
				break;
	
			case PAY_DEBT:
				payDebt();
				break;
	
			case QUIT:
				System.out.println("Thank you for using Global Economy Solutions. See you soon!");
				System.out.println();
				break;
	
			default:
				System.out.println("Option "+option+" is not valid.");
				System.out.println();
				break;
			}
		} while (option != QUIT);
	}

	//This method is private because it should be used only by
	// this class since the menu is specific to this main.
	private void printMenuOptions() {
		System.out.println(" === Welcome to Global Economy === ");
		System.out.println(" Choose an option below: ");
		System.out.println(" ");
		System.out.println(" 1. Register a country. ");
		System.out.println(" 2. Print all countries. ");
		System.out.println(" 3. Print a country's information. ");
		System.out.println(" 4. Inject money to a country. ");
		System.out.println(" 5. Pay a country's debt. ");
		System.out.println(" 6. Quit this program. ");
		System.out.println();
	}
	
	public void printAllCountries() {
		// TODO: Add the code for the logic below
		// 1. Iterate through all countries and print each one of them
		//    if they are not null!
		// BE CAREFUL! avoid printing nulls by checking:
		// if( country[i] != null ) { ... print it ... }		
	}
	
	public void printOneCountry() {		
		String countryName = readCountryName();
		
		Country foundCountry = retrieveCountry(countryName);
		// TODO: Add the code for the logic below
		// 1. Print the found country, according to assignment's format (Task 2)
		// 2. Remember that the country may not exist, so...
		//    print only if the foundCountr is NOT null.		
	}
	
	/*
	 * This method only reads a String that here, will be the name
	 * of a country that you want to use 
	 * (for printing, injecting money, paying debt, etc.) 
	 */
	public String readCountryName() {
		System.out.print("Type the name of the country that you want to use: ");
		String countryName = input.nextLine();
		return countryName;
	}

	public void injectMoney() {
		String countryName = readCountryName();		
		Country foundCountry = retrieveCountry(countryName);
		
		//TODO: write code for the following logic:
		// 1. Read a double value for the amount to be injected.
		// 2. IF the country was really found, inject the money into it.
		// 3. Print the message: "<country_name> new GDP is <country_gdp>"
		// 4. Remember to not allow changing the GDP to negative values.		
	}
	
	public void payDebt() {
		String countryName = readCountryName();		
		Country foundCountry = retrieveCountry(countryName);
		
		//TODO: write code for the following logic:
		// 1. Read a double value for the amount to be paid.
		// 2. IF the country was really found, use the reference to pay the countrys' debt.
		// 3. Print the message: "<country_name> new GDP is <country_gdp>"
		// 4. Remember to not allow changing the GDP to negative values.
	}
	
	public static void main(String[] args) {		
		GlobalEconomyMain program = new GlobalEconomyMain();
		program.run();		
	}
}
