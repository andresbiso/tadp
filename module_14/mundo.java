import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class mundo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isInputValid = false;
		String userInput;
		do {
			System.out.println("¿Es usted mayor de Edad?");
			userInput = scanner.nextLine();
			if (userInput != null && userInput.trim().length() != 0) {
				userInput = userInput.trim();
				if (userInput.equalsIgnoreCase("si") || userInput.equalsIgnoreCase("no")) {
					isInputValid = true;
				}
			}
			if (!isInputValid) {
				System.out.println("Responda Si o No");
			}
		} while (!isInputValid);
		
		if (userInput.equalsIgnoreCase("no")) {
			System.out.println("Debe ser mayor de edad para registrarse");
			return;
		}
		

		isInputValid = false;
		userInput = null;
		do {
			System.out.println("Indique su país de origen: ");
			userInput = scanner.nextLine();
			if (userInput != null && userInput.trim().length() != 0) {
				isInputValid = true;
			}
		} while (!isInputValid);
		
		scanner.close();

		boolean isCountryInAmerica = false;
		String[] countryList = { "Anguilla", "Antigua and Barbuda", "Argentina", "Aruba", "Bahamas", "Barbados",
				"Belize", "Bermuda", "Bolivia", "Brazil", "British Virgin Islands", "Canada", "Caribbean Netherlands",
				"Cayman Islands", "Chile", "Colombia", "Costa Rica", "Cuba", "Curaçao", "Dominica",
				"Dominican Republic", "Ecuador", "El Salvador", "French Guiana", "Greenland", "Grenada", "Guadeloupe",
				"Guatemala", "Guyana", "Haiti", "Honduras", "Jamaica", "Martinique", "Mexico", "Montserrat",
				"Nicaragua", "Panama", "Paraguay", "Peru", "Puerto Rico", "Saint Kitts and Nevis", "Saint Lucia",
				"Saint Martin", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Sint Maarten",
				"Suriname", "Trinidad and Tobago", "Turks and Caicos Islands", "United States of America", "Uruguay",
				"Venezuela", "Virgin Islands" };
		for (String country : countryList) {
			isCountryInAmerica = country.toLowerCase().contains(userInput);
			if (isCountryInAmerica) {
				break;
			}
		}

		if (isCountryInAmerica) {
			System.out.println("¡Bievenido!");
		} else {
			System.out.println("Por el momento no ofrecemos servicios fuera de América");
		}
	}

}
