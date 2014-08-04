package org.admir.pdf;


import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Font;


import org.admir.company.employee.model.Employee;
import org.admir.pdf.qr.QRHelper;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by memicadm on 13.06.2014.
 */
public class EmployeePdfWriter {
    private static Font catFont = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font tableHeader = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD);
    private static Font tableCell = new Font(FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

    public static void writePdf(List<Employee> employees, String filePath) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(new File(filePath)));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addEmployees(document, employees);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("Employee List");
        document.addSubject("Employee list with QR codes");
        document.addKeywords("employees, employee, QR, pdf");
        document.addAuthor("Admir Memic");
        document.addCreator("Admir Memic");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        Paragraph title = new Paragraph("List of all employees", catFont);
        preface.add(title);
        addEmptyLines(preface, 3);
        preface.setAlignment(Element.ALIGN_CENTER);
        document.add(preface);
    }

    private static void addEmployees(Document document, List<Employee> employees)
            throws DocumentException, WriterException, IOException {
        Paragraph content = new Paragraph();
        for (Employee employee : employees) {

            //Image employeeQRCode = getQRCodeImage(employee);
            PdfPTable table = getEmployeeTable(employee);
            addEmptyLines(content, 1);
            content.add(table);

        }
        document.add(content);
    }

    private static void addEmptyLines(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static Image getQRCodeImage(Employee employee) {
        return null;
    }

    private static PdfPTable getEmployeeTable(Employee employee)
            throws BadElementException, WriterException, IOException {
        PdfPTable table = new PdfPTable(7);

        String qrCode = ";" + employee.getEmployeeId() + ";" + employee.getFirstName() + ";"
                + employee.getLastName() + ";" + employee.getBirthDate() + ";" + employee.geteMail()
                + ";" + employee.getCompanyId() + ";";

        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        Image image = Image.getInstance(QRHelper.getQRImage(qrCode, 50, hintMap), Color.BLACK);
        Chunk chunk = new Chunk(image, 3, 0);
        PdfPCell cell = new PdfPCell();
        cell.addElement(chunk);
        cell.setRowspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Employee ID", tableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("First Name", tableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Last Name", tableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Birth Date", tableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("E-mail", tableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Company ID", tableHeader));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        //table.setHeaderRows(1);

        cell = new PdfPCell(new Phrase(employee.getEmployeeId().toString(), tableCell));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(employee.getFirstName(), tableCell));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(employee.getLastName(), tableCell));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(employee.getBirthDate().toString(), tableCell));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(employee.geteMail(), tableCell));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(employee.getCompanyId().toString(), tableCell));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        return table;
    }
}
