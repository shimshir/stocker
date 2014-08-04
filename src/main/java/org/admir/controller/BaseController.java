package org.admir.controller;

import org.admir.common.dao.StockerDAO;
import org.admir.company.employee.model.Employee;
import org.admir.company.model.Company;
import org.admir.security.model.DbUser;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class BaseController {

    @Autowired
    private StockerDAO stockerDAO;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String redirectToWelcome(ModelMap model) {
        return "redirect:welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Stocker Home Page");
        return "welcome";
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String company(Model model) {
        Company c = new Company();
        model.addAttribute("company", c);
        return "company";
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public String addCompany(@ModelAttribute Company company, ModelMap model) {
        model.addAttribute("company", company);
        stockerDAO.save(company);
        return "addCompanyResult";
    }

    @RequestMapping(value = "/company/e{employeeNumber}", method = RequestMethod.GET)
    public String getCompanyWithEmployees(@PathVariable Integer employeeNumber, ModelMap model) {
        Company company = new Company();
        for (int i = 0; i < employeeNumber; i++)
            company.getEmployees().add(new Employee());
        model.addAttribute("company", company);
        return "company";
    }

    @RequestMapping(value = "/company/e{employeeNumber}", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Company company, @PathVariable Integer employeeNumber, ModelMap model) {
        if (!(employeeNumber < 0)) {
            Integer currentEmployeeNumber = company.getEmployees().size();
            while (!currentEmployeeNumber.equals(employeeNumber)) {
                if (employeeNumber > currentEmployeeNumber)
                    company.getEmployees().add(new Employee());
                else if (employeeNumber < currentEmployeeNumber)
                    company.getEmployees().remove(currentEmployeeNumber - 1);
                currentEmployeeNumber = company.getEmployees().size();
            }
        }
        model.addAttribute("company", company);
        return "company";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String user(ModelMap model) {
        model.addAttribute("user", new DbUser());
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserToDB(@ModelAttribute DbUser user, Model model) {
        String encodedPassword = new Md5PasswordEncoder().encodePassword(user.getPassword(), null);
        user.setPassword(encodedPassword);
        stockerDAO.save(user);
        model.addAttribute("user", new DbUser());
        return "addUserSuccess";
    }

    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        try {
            // get your file as InputStream
            File file = new File("C:\\Users\\memicadm\\Documents\\Vuze Downloads\\" + fileName + ".jpg");
            InputStream fis = new FileInputStream(file);
            response.setContentType("application/octet-stream");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + fileName + "\"");

            ServletOutputStream os = response.getOutputStream();
            byte[] bufferData = new byte[1024];
            int read = 0;
            while ((read = fis.read(bufferData)) != -1) {
                os.write(bufferData, 0, read);
            }
            os.flush();
            os.close();
            fis.close();
            System.out.println("File downloaded at client successfully");
        } catch (Exception e) {
            if (!(e instanceof ClientAbortException))
                e.printStackTrace();
        }

    }


}
