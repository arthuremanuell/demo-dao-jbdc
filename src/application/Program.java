package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("==== TESTE NUMERO 1 ====");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println();
		System.out.println();

		System.out.println("==== TESTE NUMERO 2 ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("==== TESTE NUMERO 3 ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);

		}
		System.out.println("==== TESTE NUMERO 4 ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new Id = " + newSeller.getId());
		
		System.out.println("==== TESTE NUMERO 5 ====");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update Feito");
		
		System.out.println("==== TESTE NUMERO 6 ====");
		System.out.println("ENTRE COM ID PARA DELETAR ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");

	}
	
}
