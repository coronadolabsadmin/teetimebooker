package com.ForeUpBot.book.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Service
public class BookingPage {

    public void selectDate(WebDriver webDriver) throws InterruptedException {
        WebElement dateField = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#date-field")));

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("PST"));
        cal.add(Calendar.DATE, 8);
        Date todate = cal.getTime();
        String daysAhead = dateFormat.format(todate);
        dateField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, daysAhead, Keys.ENTER);

        int i = 0;
        while(i < 20){
            i += 1;
            WebElement activeDay = webDriver.findElement(By.cssSelector("#date .day.active"));
            activeDay.click();
            Thread.sleep(1000);
        }
    }
}
