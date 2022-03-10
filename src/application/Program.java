package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of prodcuts: ");
		int number = scan.nextInt();

		for (int i = 0; i < number; i++) {
			System.out.println("Product #" + (i + 1) + " data: ");
			System.out.print("Common, used or imported (c/u/i)?");
			char pdct = scan.next().charAt(0);
			
			scan.nextLine();

			System.out.print("Name: ");
			String name = scan.nextLine();

			System.out.print("Price: ");
			double price = scan.nextDouble();

			if (pdct == 'i') {
				System.out.print("Customs fee: ");
				double fee = scan.nextDouble();

				Product product = new ImportedProduct(name, price, fee);

				list.add(product);
			} else if (pdct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(scan.next());
				
				Product product = new UsedProduct(name, price, date);
				
				list.add(product);

			} else {
				Product product = new Product(name, price);
				
				list.add(product);
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		scan.close();
	}

}
