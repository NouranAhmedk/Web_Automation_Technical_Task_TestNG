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
