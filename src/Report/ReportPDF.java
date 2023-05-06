/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author DELL
 */
import BUS.*;
import static BUS.chitiethoadonBUS.cthdList;
import static BUS.dichvuBUS.dvList;
import static BUS.hoadonBUS.hdList;
import QLKS.DTO.chitiethoadonDTO;
import QLKS.DTO.dichvuDTO;
import QLKS.DTO.hoadonDTO;

//import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class ReportPDF {

//    HoaDonBUS hoadonbus = new HoaDonBUS();
//    KhachHangBUS khachhangbus = new KhachHangBUS();
//    NhanVienBUS nhanvienbus = new NhanVienBUS();
//    CTHDBUS cthoadonbus = new CTHDBUS();
//    KhuyenMaiBUS khuyenmaibus = new KhuyenMaiBUS();
//        
    hoadonBUS hdbus = new hoadonBUS();
    khachhangBUS khbus = new khachhangBUS();
    nhanvienBUS nvbus = new nhanvienBUS();
    chitiethoadonBUS cthdbus = new chitiethoadonBUS();
    khuyenmaiBUS kmbus = new khuyenmaiBUS();

//    public ReportPDF(String mahd) throws FileNotFoundException, IOException {
//        init(mahd);
//        File myFile = new File("BillReport/" + mahd + ".pdf");
//
//        Desktop.getDesktop().open(myFile);
//    }
    public ReportPDF(int mahd) throws Exception {
        try {
            init(mahd);
            File myFile = new File("Bill/" + String.valueOf(mahd) + ".pdf");
            System.out.print(myFile.getPath());
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            //Logger.getLogger(ReportPDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Đang tạo hóa đơn");
        }
    }

    public ReportPDF() {
    
    }

    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }

    public void init(int mahd) throws FileNotFoundException, IOException, Exception {

//        HoaDonDTO hd = new HoaDonDTO();
        hoadonDTO hd = new hoadonDTO();
        hdbus.dshd();
        khbus.dskh();
        nvbus.dsnv();
//        cthoadonbus.docCTHDtheoHD(mahd);
        cthdbus.dscthd();
        for (int i = 0; i < hdList.size(); i++) {
            if (mahd == hdList.get(i).getMa_hd()) {
                hd = hdList.get(i);
            }
        }
        chitiethoadonDTO cthd = new chitiethoadonDTO();
        for (int i = 0; i < cthdList.size(); i++) {
            if (hd.getMa_hd() == cthdList.get(i).getMa_hd()) {
                cthd = cthdList.get(i);
            }
        }
        //khuyenmaibus.docDSKMT(); 
        kmbus.dskm();

        PdfWriter writer = new PdfWriter("Bill/" + String.valueOf(mahd) + ".pdf");
        PdfFont font = PdfFontFactory.createFont("font/OpenSans-Regular.ttf", PdfEncodings.IDENTITY_H, true);
//        ?var font1 = new Font("helvetica", 12, Font.BOLD);
//        PdfFont font = PdfFontFactory.createFont("", PdfEncodings.WINANSI, true);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A5);
        PdfPage pdfPage = pdf.addNewPage();

        Paragraph tieude = new Paragraph("Quản Lí Khách Sạn");
        tieude.setTextAlignment(TextAlignment.CENTER).setFont(font);

        document.add(tieude);

        Paragraph row = new Paragraph("----------------------------------------------");
        row.setTextAlignment(TextAlignment.CENTER).setFont(font);
        document.add(row);

        Paragraph phieuthanhtoanct = new Paragraph("Chi Tiết Hóa Đơn");
        phieuthanhtoanct.setTextAlignment(TextAlignment.CENTER).setFont(font);
        document.add(phieuthanhtoanct);

        Paragraph makh = new Paragraph("Mã khách hàng : " + hd.getMa_kh());
        makh.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(makh);

        Paragraph maphong = new Paragraph("Phòng : " + cthd.getMa_phong());
        maphong.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(maphong);

        Paragraph dongia = new Paragraph("Giá phòng : " + cthd.getTien_phong() + "VND");
        dongia.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(dongia);

        Paragraph tongngayo = new Paragraph("Tổng số ngày ở : " + cthd.getTong_ngay_o());
        tongngayo.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(tongngayo);
        dichvuDTO dvDTO = new dichvuDTO();
        dichvuBUS dvbus = new dichvuBUS();
        dvbus.dsdv();
        for (int i = 0; i < dvList.size(); i++) {
            if (cthd.getMa_dv().equalsIgnoreCase(dvList.get(i).getMa_dv())) {
                dvDTO = dvList.get(i);
            }
        }
        Paragraph dichvu = new Paragraph("Dịch Vụ : " + dvDTO.getTen_dv());
        dichvu.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(dichvu);

        Paragraph tiendv = new Paragraph("Tiền dịch vụ : " + dvDTO.getGia_dv() + "VND");
        tiendv.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(tiendv);

        Paragraph tongtien = new Paragraph("Tổng tiền : " + cthd.getThanh_tien() + "VND");
        tongtien.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(tongtien);

        int x = (int) cthd.getTien_khuyen_mai();

        Paragraph tienkm = new Paragraph("Phần trăm Khuyến mãi : " + x + "%");
        tienkm.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(tienkm);

        Paragraph tienthanhtoan = new Paragraph("Tiền cần thanh toán : " + hd.getThienthuc() + "VND");
        tienthanhtoan.setTextAlignment(TextAlignment.LEFT).setFont(font);
        document.add(tienthanhtoan);

        Paragraph row1 = new Paragraph("----------------------------------------------");
        row1.setTextAlignment(TextAlignment.CENTER).setFont(font);
        document.add(row1);
        Paragraph diachi = new Paragraph("ĐC : 273 An Dương Vương, Phường 3, Quận 5, Hồ Chí Minh");
        diachi.setTextAlignment(TextAlignment.LEFT).setFont(font);
        Paragraph ngaylap = new Paragraph("Ngày lập hóa đơn :" + hd.getNgaylap());
        ngaylap.setTextAlignment(TextAlignment.LEFT).setFont(font);
        Paragraph nguoilaphoadon = new Paragraph("Mã nhân viên :" + hd.getMa_nv());
        nguoilaphoadon.setTextAlignment(TextAlignment.LEFT).setFont(font);

        document.add(nguoilaphoadon);
        document.add(ngaylap);
        document.add(diachi);
        
        Paragraph camon = new Paragraph("CẢM ƠN QUÝ KHÁCH ! - HẸN GẶP LẠI !");
        camon.setTextAlignment(TextAlignment.CENTER).setFont(font);
        document.add(camon);
        
//        Paragraph hen = new Paragraph("HẸN GẶP LẠI !");
//        hen.setTextAlignment(TextAlignment.CENTER).setFont(font);
//        document.add(hen);
        
        document.close();

    }

    public static void main(String[] args) throws IOException, Exception {
        //ReportPDF test = new ReportPDF("HD01");
        ReportPDF test = new ReportPDF(1);
    }
}
