package org.admir;

import org.admir.common.dao.StockerDAO;
import org.admir.company.employee.model.Employee;
import org.admir.company.model.Company;
import org.admir.company.stock.model.Stock;
import org.admir.pdf.EmployeePdfWriter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

        StockerDAO stockerDAO = (StockerDAO) appContext.getBean("stockerDAO");
/*      Session session = ((SessionFactory) appContext.getBean("sessionFactory")).openSession();

        Stock stock = new Stock();
        stock.setStockCode("GS2");
        stock.setStockName("Google Stock2");
        stock.setStockValue((float) 900);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alvin2", "Abdagic2", new Date(), "alvin2@dmc.de", null));

        Company company = new Company();
        company.setCompanyCode("google2");
        company.setCompanyName("google inc2");
        company.setStock(stock);
        company.setEmployees(employees);

        //modelService.getCompanyDao().save(company);
        //List<Company> companies = modelService.getCompanyDao().getCompanies();


        int i = 0;
*/
        EmployeePdfWriter.writePdf(stockerDAO.getEmployees(), "c:/temp/emps.pdf");
    }
}
