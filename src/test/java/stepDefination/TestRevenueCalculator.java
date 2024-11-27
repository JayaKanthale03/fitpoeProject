package stepDefination;

import Base.BaseTest;
import org.testng.annotations.Test;
import pageObject.Revenue_Calculator_Page;
import java.time.Duration;

public class TestRevenueCalculator extends BaseTest {


    public void user_navigate_to_the_fit_peo_homepage() {

        setupDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(priority = 1)
    public void navigate_to_revenue_calculator_page() {
        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.navigateToPage();
    }

    @Test(priority = 2)

    public void user_scroll_down_to_the_slider_section() {
        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.scrollDown();
    }

    @Test(priority = 3)

    public void adjust_the_slider_at_820 (){
        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.setSlider();
    }

    @Test(priority = 4)

    public void update_the_text_field() throws InterruptedException {

        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.setSlider_input_box();
    }

    @Test(priority = 5)
    public void validate_slider_value() {
        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.validateSliderValue();

    }
    @Test(priority = 6)
    public void select_cpt_codes_cpt_cpt_cpt_and_cpt() {
        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.selectCPTCodes();
    }

    @Test(priority = 7)
    public void validate_the_total_recurring_reimbursement() {
        Revenue_Calculator_Page rCP = new Revenue_Calculator_Page(driver);
        rCP.validateRecurringReimbursement();

    }

}
