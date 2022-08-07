Feature: Your Logo Web Page

Scenario: Create a user account
  Given User is at the your logo page
  When User click on Sign In
  And User enters email address
    | email                                  | newuser5@gmail.com            |
  And User clicks on create an account
  And User enters details with below values
    | title                                  | Mrs                |
    | firstName                              | new                |
    | lastName                               | user               |
    | password                               | 12345              |
    | date                                   | 10                 |
    | month                                  | July               |
    | year                                   | 2000               |
    | firstNameAddress                       | new                |
    | lastNameAddress                        | user               |
    | address                                | NewLane            |
    | city                                   | Bangalore          |
    | state                                  | karnataka          |
    | postalCode                             | 10000              |
    | country                                | India              |
    | mobilePhone                            | 1234567890         |
    | assignAnAddressAliasForFutureReference | NewLane            |
  Then User clicks on register

  Scenario: Validate the landing page
    Given User is at the your logo page
    When User click on Sign In
    And User login with below details
      | alreadyRegisteredEmail | newuser2@gmail.com |
      | alreadyRegisteredPwd   | 12345              |

    And Verify correct name and surname are displayed
    And User clicks on signout

    Scenario: Add a product to the cart
      Given User is at the your logo page
      When User click on Sign In
      And User login with below details
        | alreadyRegisteredEmail | newuser2@gmail.com |
        | alreadyRegisteredPwd   | 12345              |
      And User clicks on T-shirt tab and adds the item in cart


