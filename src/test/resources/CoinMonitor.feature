@coins
Feature: Monitor bullion coins prices

  Background:
    Given I am using "Chrome" browser

  Scenario: Check metal base prices
    Given I am on mennica page
    Then I check if gold price is lower than 8000
    And I check if silver price is lower than 80

# Scenario Outline is not used due to performance issue
#  Scenario: Monitor gold coins
#    Given I am on goldenmark page
#    Then I check current "Kangaroo" coin price at "https://goldenmark.com/pl/australijski-kangur-1-uncja-zlota/"
#    Then I check current "Leaf" coin price at "https://goldenmark.com/pl/kanadyjski-lisc-klonowy-1-uncja-zlota/"
#    Then I check current "Britannia" coin price at "https://goldenmark.com/pl/britannia-1-uncja-zlota-2929/"
#
#  Scenario: Monitor silver coins
#    Given I am on goldenmark page
#    Then I check current "Kangaroo" coin price at "https://goldenmark.com/pl/australijski-kangur-1-uncja-srebra/"
#    Then I check current "Leaf" coin price at "https://goldenmark.com/pl/kanadyjski-lisc-klonowy-1-uncja-srebra/"
#    Then I check current "Britannia" coin price at "https://goldenmark.com/pl/britannia-1-uncja-srebra-3039/"
