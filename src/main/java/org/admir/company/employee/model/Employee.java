package org.admir.company.employee.model;

import org.admir.company.model.Company;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by memicadm on 20.05.2014.
 */
public class Employee implements Serializable {

    private Integer employeeId;
    private Integer companyId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String eMail;
    private Company company;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Date birthDate, String eMail, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.eMail = eMail;
        this.company = company;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
