Feature: Home Loan calculator

  Scenario Outline: How much could I borrow
    Given open the homeloan calculator URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When User upadte the Application type as "<Application_type>" dependency as "<Number_of_dependants>" buying property as "<Property_you_would_like_to_buy>"
    And Enter the annual income as "<Your_annual_income_before_tax>" and annual othe income as "<Your_annual_other_income_optional_Tooltip>"
    And update Monthly living expenses as "<Monthly_living_expenses_Tooltip>" and home loan monthly repayments as "<Current_home_loan_monthly_repayments_Toolti>" and other loan repayments as "<Othe_loan_monthly_repayments_Tooltip>"
    And select other commitments as "<Other_monthly_commitments>" and total credit card limits "<Total_credit_card_limits>"
    And click on the work out how much I could borrow
    Then Amount should be generated as "<I_Could_borrow>"

    Examples: 
      | Your_annual_income_before_tax | Your_annual_other_income_optional_Tooltip | Monthly_living_expenses_Tooltip | Current_home_loan_monthly_repayments_Tooltip | Othe_loan_monthly_repayments_Tooltip | Other_monthly_commitments | Total_credit_card_limits | I_Could_borrow |
      | $80,000                       | $10,000                                   | $500                            |                                            0 | $100                                 |                         0 | $10,000                  | $479,000       |

  Scenario Outline: Error Message
    Given open the homeloan calculator URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When update Monthly_living_expenses as "<Monthly_living_expenses>"
    And click on the work out how much I could borrow
    Then error message should be matched

    Examples: 
      | Monthly_living_expenses |
      | $1                      |

  Scenario Outline: Field clear check
    Given open the homeloan calculator URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When User upadte the Application type as "<Application_type>" dependency as "<Number_of_dependants>" buying property as "<Property_you_would_like_to_buy>"
    And Enter the annual income as "<Your_annual_income_before_tax>" and annual othe income as "<Your_annual_other_income_optional_Tooltip>"
    And update Monthly living expenses as "<Monthly_living_expenses_Tooltip>" and home loan monthly repayments as "<Current_home_loan_monthly_repayments_Toolti>" and other loan repayments as "<Othe_loan_monthly_repayments_Tooltip>"
    And select other commitments as "<Other_monthly_commitments>" and total credit card limits "<Total_credit_card_limits>"
    And click on the StartOver button
    Then All the fields should be clear

    Examples: 
      | Your_annual_income_before_tax | Your_annual_other_income_optional_Tooltip | Monthly_living_expenses_Tooltip | Current_home_loan_monthly_repayments_Tooltip | Othe_loan_monthly_repayments_Tooltip | Other_monthly_commitments | Total_credit_card_limits | I_Could_borrow |
      | $80,000                       | $10,000                                   | $500                            |                                            0 | $100                                 |                         0 | $10,000                  | $479,000       |
