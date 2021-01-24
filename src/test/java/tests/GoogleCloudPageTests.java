package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesWithPO.GoogleCloudPage;

public class GoogleCloudPageTests {

    private WebDriver driver;
    protected GoogleCloudPage googleCloudPage;

    @BeforeMethod(alwaysRun = true)// Метод, после аннотации, должен быть выполнен перед выполнением основного метода. Перед каждым методом, который помечен аннотацией @test
    public void BrowserSetup() {

        driver = new ChromeDriver(); // Объект браузера для драйвера
        driver.manage().window().maximize();
        googleCloudPage = new GoogleCloudPage(driver);
    }

    @Test
    public void calculatePriceForComputeEngine() throws InterruptedException {

        googleCloudPage.openPage();
        googleCloudPage.findGooglePricingCalculator("Google Cloud Platform Pricing Calculator");
        googleCloudPage.openGooglePricingCalculator();
        googleCloudPage.ChooseComputeEngineTab();
        googleCloudPage.AddFieldNumberOfInstances("4");
        googleCloudPage.AddFieldOperatingSystem();
        googleCloudPage.AddFieldMachineClass();
        googleCloudPage.AddFieldSeries();
        googleCloudPage.AddFieldMachineType();
        googleCloudPage.AddCheckboxAddGPU();
        googleCloudPage.AddFieldNumberOfGPUs();
        googleCloudPage.AddFieldGPUType();
        googleCloudPage.AddFieldLocalSSD();
        googleCloudPage.AddFieldDatacenter();
        googleCloudPage.AddFieldCommittedUsage();
        googleCloudPage.ClickButtonAddToEstimate();

        googleCloudPage.OpenAndCopyEmailPage();
        googleCloudPage.OpenEmailEstimate();
        googleCloudPage.SendEmailEstimate();
        googleCloudPage.CheckEmailEstimate();


    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        driver=null;
    }
}
