package com.springerNature.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage {

    Common common = new Common();

    @FindBy(css = ".product_list .ajax_block_product .ajax_add_to_cart_button")
    private List<WebElement> addToCart;

    @FindBy(css= ".continue")
    private WebElement continueShopping;

    @FindBy(css = "a.button-medium")
    private WebElement proccedToCheckout;

    @FindBy(css=".standard-checkout")
    private WebElement checkOut;

    @FindBy(css= ".product-image-container")
    private  List<WebElement> products;

    @FindBy(css=".product_list .ajax_block_product")
    private List<WebElement> productList;

    @FindBy(css = ".shopping_cart a")
    private  List<WebElement> viewShoppingCart;

    @FindBy(id="email")
    private WebElement signInEmail;

    private By addcart = new By.ByCssSelector(".ajax_add_to_cart_button");

    public void addProductsIntoCart(int numberOfItems) {
        common.waitForPresenceOfElements(addcart);
        for(int i=0;i<numberOfItems;i++) {
            common.moveToElementAndClickUsingJs(addToCart.get(i));
            common.waitForVisibilityOfElement(continueShopping);
            common.moveToElementAndClickUsingJs(continueShopping);
        }
    }

    public void clickOnProceedToCheckout() {
       WebElement element = getElementFromListOfElements(viewShoppingCart,"View my shopping cart","title");
       common.moveToElementAndClickUsingJs(element);
    }

    public void ClickOnCheckOut() {
        common.moveToElementAndClickUsingJs(common.waitForVisibilityOfElement(checkOut));
    }

    private WebElement getElementFromListOfElements(List<WebElement> elements, String category,String attribute) {
        return elements.stream().filter(element -> element.getAttribute(attribute).equalsIgnoreCase(category)).findAny().orElseThrow(()-> new RuntimeException("Element with " + category + " is not found"));
    }

    public Boolean isSignFormDisplayed() {
        return common.waitForVisibilityOfElement(signInEmail).isDisplayed();
    }
}
