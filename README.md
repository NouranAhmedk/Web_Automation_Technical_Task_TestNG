# Tealiumdemo

> [!IMPORTANT]
> This is the website where you are supposed to perform your automation scenarios using TestNG with the Selenium framework
> https://ecommerce.tealiumdemo.com/

## Add essential required dependencies in ```pom.xml```

1.Search google on: [Selenium maven dependency](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java).

2.Search google on: [TestNG maven dependency](https://mvnrepository.com/artifact/org.testng/testng).

3.Search google on: [Apache Commons IO](https://mvnrepository.com/artifact/commons-io/commons-io).

4.Search google on: [Lombok Maven Plugin maven dependency](https://mvnrepository.com/artifact/org.projectlombok/lombok-maven-plugin).

5.Search google on: [Java Faker maven dependency](https://mvnrepository.com/artifact/com.github.javafaker/javafaker).

6.Search google on: [Allure TestNG maven dependency](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng).

7.Search google on: [AspectJ Weaver maven dependency](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver).

8.Search google on: [JetBrains Java Annotations maven dependency](https://mvnrepository.com/artifact/org.jetbrains/annotations).

> [!Note]
> Best practice is to define the version of the Surefire Plugin that you want to use in either your ```pom.xml``` or a parent ```pom.xml```
>
> + Make sure the version of the AspectJ Weaver matches the one in the Surefire.
> + The used version ```1.9.22.1```

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
            <configuration>
                <argLine>
                    -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/1.9.22.1/aspectjweaver-1.9.22.1.jar"
                </argLine>
            </configuration>
        </plugin>
    </plugins>
</build>
```
> [!TIP]
> **The main reasons for choosing thoes dependencies:**
> 1. ***Apache Commons IO*** : utility classes and methods for handling input/output (IO) in Java. For more detailed information, press this [Link](https://commons.apache.org/proper/commons-io/).
> 2. ***Lombok*** : Its ability to simplify code writing by using annotations such as ```@SneakyThrows```to boldly throw checked exceptions where no one has thrown them before. For more detailed information, press this [Link](https://projectlombok.org/features/).
> 3. ***Java Faker*** : It's useful when you're developing a new project and need some pretty data for showcase. For more detailed information, press this [Link](https://github.com/DiUS/java-faker).
> 4. ***Allure*** : Allure Report is a popular open source tool for visualizing the results of a test run. It can be added to your testing workflow with little to zero configuration. For more detailed information, press this [Link](https://allurereport.org/docs/)
> 5. ***AspectJ Weaver*** : Allure leverages AspectJ for the functionality of ```@Step``` and ```@Attachment``` annotations. Additionally, some framework integrations (such as allure-assertj) rely on AspectJ integration to function correctly.  For more detailed information, press this [Link](https://allurereport.org/docs/testng/).
> 6. ***JetBrains Java Annotations*** : Annotations are pieces of metadata that provide information about code elements. For more detailed information, press this [Link](https://www.jetbrains.com/help/idea/annotating-source-code.html).

## Project Structure 
```
  allure-report
  allure-results
  Screenshots
    |_ FailedScreenshots
    |_ PassedScreenshots  
  src
    |_ main
        |_ java
            |_ data_reader
                |_ Load_Properties.java
            |_ data_writer
                |_ TestData_Writer.java
            |_ web_pages
                |_ dashboard_page
                    |_ Dashboard_Actions.java
                    |_ Dashboard_WebElements.java
                |_ hana_flat_shoes_details_page
                    |_ Hana_Flat_Shoes_Details_Actions.java
                    |_ Hana_Flat_Shoes_Details_WebElements.java
                |_ home_page
                    |_ Home_Actions.java
                    |_ Home_WebElements.java
                |_ login_page
                    |_ Dashboard_Actions.java
                    |_ Dashboard_WebElements.java
                |_ registration_page
                    |_ Registration_Actions.java
                    |_ Registration_WebElements.java
                |_ shoes_page
                    |_ Shoes_Actions.java
                    |_ Shoes_WebElements.java
                |_ Page_Base.java         
    |_ test
        |_ java
            |_ listeners
                  |_ ITestListener_Listener.java
            |_ test_base
                  |_ Add_Product_From_Accessories_To_Shopping_Cart_Test_Base.java
                  |_ Complete_Flow_Test_Base.java
                  |_ Login_Test_Base.java
                  |_ Registration_Test_Base.java
                  |_ Test_Base.java
               |_ tests
                  |_ add_product_from_accessories_to_shopping_cart
                     |_ Add_Product_From_Accessories_To_Shopping_Cart.java
                  |_ complete_flow
                     |_ Complete_Flow.java
                  |_ login
                     |_ Login.java
                  |_ registration
                     |_ Registration.java
                |_ resources
                  |_Properties
                    |_EnvironmentData.properties
                    |_Login.properties

    target
    pom.xml
    regression_testng.xml
    testng.xml
```
## To generate an Allure report in a single HTML page
### 1. You need to install Allure on your device
#### Windows    
+ I used **Scoop** to install **Allure**
    - Incase you don't have **Scoop** in your device you can download **Scoop** by Open a PowerShell terminal (version 5.1 or later) and run
    ```
    Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
    Invoke-RestMethod -Uri https://get.scoop.sh | Invoke-Expression
    ```
    for more details about **Scoop** you can vist this [Link](https://scoop.sh/).
  
+  Make sure Java version 8 or above installed, and its directory is specified in the JAVA_HOME environment variable.
+  Install **Allure**
    -  In a terminal, run this command:
       ```
       scoop install allure
       ```
    -  Run this command to see if it reports the latest version:
       ```
       allure --version
       ```
      for more details about installation of Allure you can visit this link [link](https://allurereport.org/docs/install-for-windows/)    
### 2. Generate a single HTML page Allure report 
 + Open the IntelliJ IDE and run this command in the project terminal
```
allure generate allure-results --clean --single-file
```
 for more details about **Allure Single HTML File** you can vist this [Link](https://allurereport.org/docs/gettingstarted-view-report/#open-a-single-html-file).

### Download the Allure results [link](https://drive.google.com/file/d/1d7i_J1T232v3OlpKAl6LvB0ZGHHKV2f-/view?usp=sharing) to view the results
### Download the Javadoc results [link](https://drive.google.com/file/d/1veVSAUn1kBGzj7CWZF7XWNsc3ExSIASs/view?usp=sharing) to view the generated Javadoc.
      

