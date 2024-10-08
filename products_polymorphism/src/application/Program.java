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
		Scanner sc = new Scanner(System.in);		
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n;i++) {
			sc.nextLine();
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported(c/u/i)? ");
			String type = sc.nextLine();
			if (type.charAt(0) == 'i') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				Double fee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, fee);
				products.add(product);
			} else if (type.charAt(0) == 'c') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				Product product = new Product(name, price);
				products.add(product);
			} else {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				sc.nextLine();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.nextLine());
				Product product = new UsedProduct(name, price, date);
				products.add(product);
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product: products) {
			System.out.println(product.priceTag());
		}
	}

}
