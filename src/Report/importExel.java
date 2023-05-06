/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import BUS.khachhangBUS;
import BUS.nhanvienBUS;
import QLKS.DTO.khachhangDTO;
import QLKS.DTO.nhanvienDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class importExel {

    public importExel() {
    }

    public void importkh() throws FileNotFoundException, IOException, Exception {
        JFileChooser fileChooser = new JFileChooser();
        int excelChooser = fileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileInputStream fis = new FileInputStream(file.getPath());
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            Row row;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                formulaEvaluator.evaluateInCell(row.getCell(1)).getCellType();
                khachhangDTO kh = new khachhangDTO();
                int ma_kh = (int) row.getCell(1).getNumericCellValue();
                kh.setMa_kh(String.valueOf(ma_kh));
                kh.setHo(row.getCell(2).getStringCellValue());
                kh.setTen(row.getCell(3).getStringCellValue());
                kh.setSdt(row.getCell(5).getStringCellValue());

                kh.setNgaysinh(row.getCell(5).getStringCellValue());
                kh.setGioitinh(row.getCell(6).getStringCellValue());
                kh.setDiachi(row.getCell(7).getStringCellValue());
                khachhangBUS khbus = new khachhangBUS();
                khbus.insert(kh);
            }
        }
    }
    
    public void importNv() throws FileNotFoundException, IOException, Exception{
                JFileChooser fileChooser = new JFileChooser();
        int excelChooser = fileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileInputStream fis = new FileInputStream(file.getPath());
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            Row row;
             for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                formulaEvaluator.evaluateInCell(row.getCell(1)).getCellType();
                nhanvienDTO nv=new nhanvienDTO();
                int ma_nv = (int) row.getCell(1).getNumericCellValue();
                nv.setMa_nv(String.valueOf(ma_nv));
                nv.setHo(row.getCell(2).getStringCellValue());
                nv.setTen(row.getCell(3).getStringCellValue());
                nv.setGioitinh(row.getCell(4).getStringCellValue());
                nv.setNgaysinh(row.getCell(5).getStringCellValue());
                nv.setChucvu(row.getCell(6).getStringCellValue());
//                System.out.println(row.getCell(6).getStringCellValue());
                nv.setSdt(row.getCell(7).getStringCellValue());
                nv.setDiachi(row.getCell(8).getStringCellValue());
                int luong= (int) row.getCell(9).getNumericCellValue();
                nv.setLuong(luong);
                
                nhanvienBUS nvbus=new nhanvienBUS();
                nvbus.insert(nv);
             }
             }
    }
    
    public static void main(String[] args) throws IOException, Exception {
        importExel a=new importExel();
        a.importNv();
    }
    
}
