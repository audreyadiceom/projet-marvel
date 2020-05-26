#Author: audrey adiceom

Feature: US_001 Un Avenger veut combattre un Super Méchant
  En tant que Avenger, Iron Man
  Je veux pouvoir combattre le Super Mechant Thanos
  Afin de sauver le monde

  Scenario Outline: Ajouter un Super Méchant à combattre
    Given <nom_avenger> se rend compte que <nom_mechant> veut détruire le monde
    When Le <nombre_pierre_mechant> est inférieur à 6
    And  Il veut pouvoir le combattre
    Then Le monde est sauvé
    
    Examples: 
      | nom_avenger    | nom_mechant   | nombre_pierre_mechant  | monde_sauvé   |
      | "Iron Man"		 |     "Loki" 	 |        	2 						| 		"oui" 		|
      | "Iron Man"		 |     "Thanos"  |        	4 						| 		"oui" 		|
     

  Scenario Outline: Impossible de battre un Super Méchant
    Given <nom_avenger> se rend compte que <nom_mechant> veut détruire le monde
    When Le <nombre_pierre_mechant> est égal à 6
    And  Il veut pouvoir le combattre
    Then Le monde n'est pas_sauvé

    Examples: 
      | nom_avenger    | nom_mechant   | nombre_pierre_mechant  | monde_sauvé   |
      | "Iron Man"		 |     "Thanos"  |        	6 					  | 		"non" 		|
