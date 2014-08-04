package org.admir.company.stock.model;

/**
 * Created by memicadm on 16.05.2014.
 */

import org.admir.company.model.Company;

import java.io.Serializable;

public class Stock implements Serializable {

    private Integer companyId;
    private String stockCode;
    private String stockName;
    private Float stockValue;
    private Company company;

    public Stock() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Float getStockValue() {
        return stockValue;
    }

    public void setStockValue(Float stockValue) {
        this.stockValue = stockValue;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
