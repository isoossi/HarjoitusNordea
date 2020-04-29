Feature: Amazon Nikon search

  Scenario: search Nikon products from amazon.com
    Given user goes to amazon
    When user search for Nikon

  Scenario: sort search results
    When user clicks sort products from High to Low

  Scenario: select second product from list
    When user clicks second product
