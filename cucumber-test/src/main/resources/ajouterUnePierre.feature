#Author: Audrey Adiceom

Feature: US_000 Ajouter une Pierre d'Infini
  En tant que SuperMechant Thanos
  Je veux ajouter une nouvelle pierre d'infini à mon compteur
  Afin de savoir si je peux décimer la moitié de la planète

  Scenario Outline: ajout pierre infini avec son nom 
    Given Thanos s approche d une pierre d infini nommée <nom_pierre>
    When Thanos tente de la comptabiliser
    Then le compteur de pierres de l'infini de Thanos doit être incrémenté.
   
  Examples: 
      | nom_pierre   | compteur | 
      | "Âme"        |   +1     | 
      | "Réalité"    |   +1     |  


  Scenario Outline: refus d'ajout de pierre non infini
    Given Thanos s approche d une pierre non d infini nommée <nom_pierre>
    When Thanos tente de la comptabiliser
    Then le compteur de pierre de l infini de Thanosn est pas incrémenté. 

    Examples: 
      | nom_pierre   | compteur |
      | "Pizza"      |   +0     |
      
       
