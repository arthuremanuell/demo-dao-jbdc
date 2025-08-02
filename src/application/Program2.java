package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TESTE 1: findById ===");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TESTE 2: findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TESTE 3: insert ===");
        Department newDep = new Department(null, "Livros");
        departmentDao.insert(newDep);
        System.out.println("Inserido! Novo ID = " + newDep.getId());

        System.out.println("\n=== TESTE 4: update ===");
        Department depToUpdate = departmentDao.findById(newDep.getId());
        depToUpdate.setName("Papelaria");
        departmentDao.update(depToUpdate);
        System.out.println("Atualizado com sucesso!");

        System.out.println("\n=== TESTE 5: deleteById ===");
        System.out.print("Digite o ID para deletar: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletado com sucesso!");

        sc.close();
    }
}
