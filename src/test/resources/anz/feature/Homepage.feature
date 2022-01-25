Feature: Home Loan calculator

  Scenario: How much could I borrow
    Given open the homeloan calculator URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When User upadte the Application type as "Single" dependency as "0" buying property as "Home to live in"
    And Enter the annual income as "$80000" and annual othe income as "$10000"
    And update Monthly living expenses as "$500" and home loan monthly repayments as "0" and other loan repayments as "$100"
    And select other commitments as "0" and total credit card limits "$10,000"
    And click on the work out how much I could borrow
    Then Amount should be generated as "$47900"

  Scenario: Error Message
    Given open the homeloan calculator URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When update Monthly living expenses as "$1"
    And click on the work out how much I could borrow
    Then error message should be matched
