package testpages;

import base.CommonAPI;
import datasources.ExcelDataSource;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageMystore;

public class TestHomePage extends CommonAPI {

    HomePageMystore homepage;
    ExcelDataSource excelData = new ExcelDataSource();
    String path = "../mystore/src/test/resources/teststeps.xls";

    @BeforeMethod
    public void initialize() {
        homepage = PageFactory.initElements(this.driver, HomePageMystore.class);
    }

    //@Test
    public void testSearchBox() {
        homepage.setSearchBox("shirts");
        System.out.println(driver.getTitle());
    }

    //@Test
    public void testContactUsLink() {
        homepage.contactUsLink();
        System.out.println(driver.getTitle());
    }

    @Test
    public void selectSteps() {
        String[] testSteps = excelData.getExcelData(path, 0);
        for (String str : testSteps) {
            switch (str) {
                case "search":
                    testSearchBox();
                    break;
                case "navigate":
                    testContactUsLink();
                    break;
                default:
                    throw new InvalidArgumentException("Invalid choice");
            }
        }
    }
}
