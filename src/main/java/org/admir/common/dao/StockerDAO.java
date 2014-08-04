package org.admir.common.dao;

import org.admir.company.employee.model.Employee;
import org.admir.company.model.Company;
import org.admir.company.stock.model.Stock;
import org.admir.security.model.DbUser;

import java.util.List;

/**
 * Created by memicadm on 23.05.2014.
 */
public interface StockerDAO {

    <T> void save(T object);

    <T> void update(T object);

    <T> void delete(T object);

    Company findByCompanyCode(String companyCode);

    List<Company> getCompanies();

    Employee findByLastName(String lastName);

    List<Employee> getEmployees();

    Stock findByStockCode(String stockCode);

    List<Stock> getStocks();

    DbUser getUserByUsername(String username);
}
