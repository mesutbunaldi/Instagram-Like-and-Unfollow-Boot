import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class InstagramBoot
{

    private String userName;
    private String password;
    public FirefoxDriver instaDriver;



    InstagramBoot() throws InterruptedException {

        instaDriver=new FirefoxDriver();
        instaDriver.get("https://www.instagram.com/accounts/login/");



        Thread.sleep(2000);


        setUserName("------------"); //set your instagram uname
        setPassword("------------"); //set your pass



        Thread.sleep(2000);




    }


    private void setPassword(String password) {
        this.password = password;
        WebElement pass=instaDriver.findElements(By.tagName("input")).get(1);
        pass.sendKeys(password);

    }

    private void setUserName(String userName) {
        this.userName = userName;
        WebElement usrName=instaDriver.findElements(By.tagName("input")).get(0);
        usrName.sendKeys(userName);


    }

    private void login() throws InterruptedException {

        Thread.sleep(2000);
        WebElement btnLogin=instaDriver.findElements(By.tagName("button")).get(1);
        btnLogin.click();
    }


    public void like() throws InterruptedException {

        Thread.sleep(100);

        WebElement search=instaDriver.findElement(By.xpath("/html/body/span/section/nav/div[2]/div/div/div[3]/div/div[1]/a"));
            search.click();
        Thread.sleep(2000);

        WebElement element=instaDriver.findElement(By.xpath("/html/body/span/section/main/div/article/div[1]/div/div[1]/div[1]"));
        element.click();


        for (int i=1;i<100000;i++) {
            Thread.sleep(2000);

            if (i % 20 == 0)
                Thread.sleep(5000);


            try {
                WebElement likeBtn = instaDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/article/div[2]/section[1]/span[1]/button"));
                likeBtn.click();
            }catch (NoSuchElementException e){
                System.out.println("go on");
                WebElement next;
                if (i == 1)
                    next = instaDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/a"));
                else
                    next = instaDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/a[2]"));

                next.click();
                Thread.sleep(2000);
            }



            Thread.sleep(20);

        try {
            WebElement follow = instaDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/article/header/div[2]/div[1]/div[2]/button"));
            if (!follow.getText().equals("Following")) {
                follow.click();
            }
        }catch  (NoSuchElementException e){
            System.out.println("go on");
            WebElement next;
            if (i == 1)
                next = instaDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/a"));
            else
                next = instaDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/a[2]"));

            next.click();
            Thread.sleep(2000);
        }


            WebElement next;
            if (i == 1)
                next = instaDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/a"));
            else
                next = instaDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/a[2]"));

            next.click();
        }

    }


    public void run() throws InterruptedException {

        login();

        Thread.sleep(10000);

        instaDriver.switchTo().activeElement();
        WebElement page=instaDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]"));
        page.click();
        Thread.sleep(4000);



    }


    public void unfollowAll() throws InterruptedException {
        WebElement profileLink=instaDriver.findElement(By.xpath("/html/body/span/section/main/section/div[3]/div[1]/div/div[2]/div[1]/a"));
        profileLink.click();
        Thread.sleep(4000);

        profileLink=instaDriver.findElement(By.xpath("/html/body/span/section/main/div/header/section/ul/li[3]/a"));
        profileLink.click();
        instaDriver.switchTo().activeElement();
        Thread.sleep(4000);


        for (int i=1;i<=100;i++) {

            profileLink = instaDriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/ul/div/li["+i+"]/div/div[2]/button"));
                profileLink.click();

                instaDriver.switchTo().activeElement();

                profileLink=instaDriver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/button[1]"));
                profileLink.click();

        }




    }
}
