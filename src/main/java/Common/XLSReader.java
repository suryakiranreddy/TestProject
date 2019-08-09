package Common;

import java.io.File;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XLSReader {

    public final Fillo fillo;
    public final String filePath;

    public Connection connection;

    public XLSReader(String filePath) {
    	System.out.println(filePath);
        fillo = new Fillo();
        this.filePath = filePath;
    }

    public void getTests(String query) {
        try {
        	System.out.println(query);
            connection = fillo.getConnection(this.filePath);
            Recordset recordset = connection.executeQuery(query);
            this.createSuite(recordset);
        } catch (FilloException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void createSuite(Recordset recordset) {
        XmlMapper xmlMapper = new XmlMapper();
        Suite suite = new Suite("TesTautomationGuru");
        try {
            while (recordset.next()) {

                String testName = recordset.getField("TestCaseDescription");
                String className = recordset.getField("ClassName");
                String param = "Data";
                String paramValue = recordset.getField("Data");
                System.out.println(testName);
                suite.addTest(testName, param, paramValue, className);
            }
            xmlMapper.writeValue(new File("./testng1.xml"), suite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            recordset.close();
        }
    }

}
