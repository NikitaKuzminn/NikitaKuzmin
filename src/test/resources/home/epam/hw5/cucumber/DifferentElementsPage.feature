Feature: Different elements page check

  Scenario: Check Web elements on Different Elements Page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then I expect username to be "ROMAN IOVLEV"
    And  I Open through the header menu Service and select Different Elements Page
    When I select 'Water' in checkboxes on Different Element Page
    When I select 'Wind' in checkboxes on Different Element Page
    Then 'Water' checkbox is selected
    Then 'Wind' checkbox is selected
    And  I select radio 'Selen'
    Then 'Selen' radio is selected
    And  I select 'Yellow' in dropdown
    Then 'Yellow' is selected in dropdown
    Then Log rows are displayed for each selected web elements containing selected items
