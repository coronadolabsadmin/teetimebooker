package com.ForeUpBot.book.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

@Service
public class BookingTypeSelectPage {

    public void selectBookingType(WebDriver webDriver){
        WebElement selectButton = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Resident Adult (0 - 7 Days)']")));
        selectButton.click();
    }


}
