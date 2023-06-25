@CERTIFICATE
Feature: Certificate Check

  Scenario Outline: Verify Certificate Check
    Given I open the certificate check page
    When I enter the certificate number "<CertificateNumber>"
    Then I should see the message "<ExpectedMessage>"

    Examples:
      | CertificateNumber | ExpectedMessage        |
      | 236589            | Сертифікат не знайдено |
      | 456877            | Сертифікат не знайдено |
      | 458744            | Сертифікат не знайдено |
      | 212121            | Сертифікат не знайдено |
      | 919191            | Сертифікат не знайдено |
