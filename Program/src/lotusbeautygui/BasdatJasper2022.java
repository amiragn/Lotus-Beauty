/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lotusbeautygui;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author HP PAVILION
 */
public class BasdatJasper2022 {
    private static String destFileName = "AlulaBeauty.pdf";
    public static void main(String[] args) throws FileNotFoundException, JRException{
        System.out.println("Membuat Jasper Report... ");
        JasperReport jasperReport = getJasperReport();
        Map<String,Object> parameters= getParameters();
        System.out.println("Report Selesai");
        
         String connectionUrl = "jdbc:sqlserver://localhost:1433; integratedSecurity=false; encrypt=false; trustServerCertificate=true;"
                +"DatabaseName=LotusBeauty; user=kelompok3; password=1234;" +
                "loginTimeout=30;";
        try {
            java.sql.Connection connection = DriverManager.getConnection(connectionUrl);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            JasperViewer.viewReport(jasperPrint, false);
            JasperExportManager.exportReportToPdfFile(jasperPrint,  destFileName);    
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }
    }
    private static JasperReport getJasperReport() throws FileNotFoundException, JRException{
        File template = Paths.get("NOTAPEMBELIANFIX.jrxml").toFile();
        return JasperCompileManager.compileReport(template.getAbsolutePath());
    }

    private static Map<String, Object> getParameters() {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("dibuatOleh", "Fathia");
        return parameters;
    }
    
}
