package CucumberTest;

import DriverFactory.DriverProvider;
import com.lab.selenium.page.HomePage;
import com.lab.selenium.page.ItemPage;
import com.lab.selenium.page.SearchResultPage;
import com.lab.selenium.page.ShoppingCartPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinition {
    WebDriver driver = DriverProvider.getDriver();
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ItemPage itemPage = new ItemPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

   @Before
    public void testSetup(){
       driver.manage().window().maximize();
    }
    @Given("User opens {string} page")
    public void openPage(final String url){
        driver.get(url);
    }
    @And("User search {string} product")
    public void searchProductByName(final String keyword){

       homePage.searchByKeyword(keyword);

    }
    @When("User selects the first product from the list")
    public void choseFirstItem(){
       searchResultPage.chooseFirstItemFromTheList();
    }

    @And("User add item to the shopping cart")
    public void addItemToShoppingCart() throws InterruptedException {
       itemPage.clickOnAddToCartButton();
       Thread.sleep(30);
       shoppingCartPage.closeShoppingCart();
       Thread.sleep(20);
    }

    @Then("User have to have {string} of product in the shopping cart")
    public void userHaveToHaveEqualsNumberOfProductInTheShoppingCart(String expected ) throws InterruptedException {

        int quantityOfAddedItems =itemPage.getAmountOfProductsInTheShoppingCart();
        Assert.assertEquals(itemPage.getAmountOfProductsInTheShoppingCart(),Integer.parseInt(expected));
    }
}
