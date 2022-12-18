package tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class day05_JavaFaker {

    /*
    TEST DATA : username, password, URL, test environment, city, ssn,...

    -Where do you get your test data?
    -BA-Business Analyst(Writes the acceptance criteria(AC))
    -Test Lead
    -Manual Tester
    -Tech Lead(Team Lead)
    -Developer
    -We can retrieve data from the database
    -We can retrieve data from API
    -Documentation. For example swagger doc can be used for API

    -If we need mock data(fake data), we can use the Java Faker
    -NOTE: Java Faker generates data randomly.
     */

    @Test
    public void javaFakerTest(){

        //create faker object
        Faker faker = new Faker();

        //generate fake data
        String firstName = faker.name().firstName();
        System.out.println(firstName);

        // lastname
        String lastName = faker.name().lastName();
        System.out.println(lastName);

        //username
        String userName = faker.name().username();
        System.out.println(userName);

        //title
        String title = faker.name().title();
        System.out.println(title);

        //city
        String city = faker.address().city();
        System.out.println(city);

        //fulladdress
        String fullAddress = faker.address().fullAddress();
        System.out.println(fullAddress);

        //cell phone
        String cellPhone = faker.phoneNumber().cellPhone();
        System.out.println(cellPhone);

        //email
        String email = faker.internet().emailAddress();
        System.out.println(email);

        //zip code
        String zipCode = faker.address().zipCode();
        System.out.println(zipCode);

        //random digit number
        String randomDigits = faker.number().digits(10);
        System.out.println(randomDigits);




}
}
