package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;


public class Revenue_Calculator_Page {

   WebDriver driver;

    //Constrctor
    public Revenue_Calculator_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators

    String value;

    @FindBy(xpath = "//*[contains(@class, \"satoshi MuiBox-root css-5ty6tm\")][text() = \"Revenue Calculator\"]")
    private WebElement revenue_calculator;

    @FindBy(xpath ="//span[@class =\"MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh\"]")
     private WebElement slider;

    @FindBy(xpath ="//body/div[@class='MuiBox-root css-3f59le']/div[@class='MuiBox-root css-rfiegf']/div[@class='MuiBox-root css-1p19z09']/div[1]/label[@class=\"MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg\"]")
    private WebElement cpt_code1;


    @FindBy(xpath ="//body/div[@class='MuiBox-root css-3f59le']/div[@class='MuiBox-root css-rfiegf']/div[@class='MuiBox-root css-1p19z09']/div[2]/label[@class=\"MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg\"]")
    private WebElement cpt_code2;

    @FindBy(xpath ="//body/div[@class='MuiBox-root css-3f59le']/div[@class='MuiBox-root css-rfiegf']/div[@class='MuiBox-root css-1p19z09']/div[3]/label[@class=\"MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg\"]")
    private WebElement cpt_code3;

    @FindBy(xpath ="//body/div[@class='MuiBox-root css-3f59le']/div[@class='MuiBox-root css-rfiegf']/div[@class='MuiBox-root css-1p19z09']/div[8]/label[@class=\"MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg\"]")
    private WebElement cpt_code4;

    @FindBy(xpath ="/header[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorDefault MuiAppBar-positionFixed mui-fixed css-nq2yav\"]/div/p[4]")
    private WebElement total_recurring_emburstment;

    @FindBy(xpath ="//header/div/p[4]/p")
    private WebElement total_recurring_emburstment_value;

    @FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-129j43u\"]")
    private WebElement sliderInputBox;

    By scroll_webpage = By.xpath("//div[@class=\"MuiBox-root css-79elbk\"]");
    By scroll_webpage2 =By.xpath("//p[@class=\"MuiTypography-root MuiTypography-body1 inter css-14mlo9v\"]");


    //Methods

    public void navigateToPage() {

        driver.get("https://www.fitpeo.com/");
        revenue_calculator.click();
    }

    public void scrollDown() {

        // Scroll to the element using JavaScript
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                driver.findElement(scroll_webpage));
    }

    public void setSlider(){

        int sliderWidth = slider.getSize().getWidth();
        int min = 0;
        int max = 2000;
        int value = 940;

        // Calculate the desired offset based on the value
        double xOffset = ((sliderWidth * (value - min))*10 / (max - min));

        // Print out the calculated yOffset and slider width
        System.out.println("Slider width: " + sliderWidth);
        System.out.println("Calculated offset for value " + value + ": " + xOffset);

        // Use Actions to move the slider
        Actions action = new Actions(driver);
        action.clickAndHold(slider)
                .moveByOffset((int)xOffset, 0) // Moving the slider horizontally
                .release()
                .perform();
    }

    public void setSlider_input_box() throws InterruptedException {
        //Using Action class to enter values element
        Actions action = new Actions(driver);
        action.moveToElement(sliderInputBox).click();
        action.moveToElement(sliderInputBox).doubleClick().sendKeys("560").perform();

    }

    public void validateSliderValue(){

        // Locate the input element
        WebElement sliderInput = driver.findElement(By.xpath("//input[@type='range']"));

        // Get the aria-valuenow attribute
        String ariaValueNow = sliderInput.getAttribute("aria-valuenow");

        // Get the value attribute
        String sliderValue = sliderInput.getAttribute("value");

        // Print the values
        System.out.println("Aria-ValueNow: " + ariaValueNow);
        System.out.println("Value: " + sliderValue);
        String value1 = ariaValueNow;

        if (value1.equals(ariaValueNow)){
            System.out.println("The sliders position is updated");
        }
        else{
            System.out.println("The values are different");
        }
    }

    public void selectCPTCodes(){

        //click on the specified CPT Codes
        cpt_code1.click();
        cpt_code2.click();
        cpt_code3.click();
        cpt_code4.click();
    }

    public void validateRecurringReimbursement(){

        //Entering specific value using action class
        Actions action = new Actions(driver);
        action.moveToElement(sliderInputBox).click();
        action.moveToElement(sliderInputBox).doubleClick().sendKeys("820").perform();
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                driver.findElement(scroll_webpage2));

        //To get the Total Recurring Reimbursement
        String reccuringEmburstment = total_recurring_emburstment_value.getText();

        System.out.println(reccuringEmburstment);
        if(reccuringEmburstment.equals (total_recurring_emburstment_value)){
            System.out.println("The value has been verified successfully"); }
            else{
                System.out.println("Not same");
            }
       }


    }
