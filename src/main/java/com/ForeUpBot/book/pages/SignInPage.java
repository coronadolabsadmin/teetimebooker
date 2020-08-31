package com.ForeUpBot.book.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class SignInPage {
    @Value("${foreup.account.username}")
    private String username;

    @Value("${foreup.account.password}")
    private String password;

    @Value("${foreup.course.torreyPines}")
    private String courseAddress;

    public void login(WebDriver webDriver){
        webDriver.get(courseAddress);
        WebElement firstResult = new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-container")));
        WebElement usernameInput = webDriver.findElement(By.cssSelector("#login_email"));
        WebElement passwordInput = webDriver.findElement(By.cssSelector("#login_password"));
        WebElement submitButton = webDriver.findElement(By.cssSelector("#submit_button input"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
