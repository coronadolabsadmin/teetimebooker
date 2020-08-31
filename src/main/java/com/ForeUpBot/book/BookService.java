package com.ForeUpBot.book;

import com.ForeUpBot.book.pages.BookingPage;
import com.ForeUpBot.book.pages.BookingTypeSelectPage;
import com.ForeUpBot.book.pages.SignInPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class BookService {

    @Value("${webdriver.hostUrl}")
    private String hostUrl;

    @Autowired
    private SignInPage signInPage;

    @Autowired
    private BookingTypeSelectPage bookingTypeSelectPage;

    @Autowired
    private BookingPage bookingPage;

    public WebDriver getWebDriver() throws MalformedURLException {
        Capabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL(hostUrl), capabilities);
        return driver;
    }

    @PostConstruct
    public void postConstruct() throws MalformedURLException, InterruptedException {
        WebDriver webDriver = getWebDriver();
        signInPage.login(webDriver);
        bookingTypeSelectPage.selectBookingType(webDriver);
        bookingPage.selectDate(webDriver);
        try{
            webDriver.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
