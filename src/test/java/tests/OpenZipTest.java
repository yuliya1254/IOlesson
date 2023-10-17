package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class OpenZipTest {
    private final ClassLoader cl = OpenZipTest.class.getClassLoader();

    @Test
    void zipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("resources.zip");
             ZipInputStream zis = new ZipInputStream(stream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertEquals("PDF Test File \n" +
                            "Hi qa.guru :] \n" +
                            " \n" +
                            " \n", pdf.text);
                } else if (entry.getName().contains(".xls")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals("Парфюмерия >> Нишевая парфюмерия >> Parfums De Marly",
                            xls.excel.getSheetAt(0).getRow(46).
                                    getCell(0).getStringCellValue());
                } else if (entry.getName().contains(".csv")) {
                    Reader reader = new InputStreamReader(zis);
                    CSVReader csvReader = new CSVReader(reader);
                    List<String[]> content = csvReader.readAll();

                    Assertions.assertEquals(2, content.size());

                    final String[] first = content.get(0);
                    final String[] second = content.get(1);

                    Assertions.assertArrayEquals(new String[]{"Mancera", "Hindu kush"}, first);
                    Assertions.assertArrayEquals(new String[]{"Xerjoff", "Naxos"}, second);



                }

            }
        }
    }


}
