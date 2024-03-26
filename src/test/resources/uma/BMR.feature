@tag
Feature: Basal Metabolic Rate
    As a user I want to calculate my basal metabolic rate (BMR) so that I can control my weight and take steps to be healthier 

    @tag1
    Scenario Outline: I give the program the correct parameters
        Given my gender, weight, height and age
        When I run this program
        Then I should see my BMR

        Examples:
            |  w  |  h  |  g  | age  |  value  | 
            | 40  | 165 | 'm' |  15  |  1361   |      
            | 35  | 165 | 'm' |  15  |  1145   |            
            | 80  | 175 | 'm' |  30  |  1749   |            
            | 90  | 180 | 'w' |  50  |  1614   |            
      


    @tag2
    Scenario Outline: I give the program incorrect parameters
        Given at least my gender, weight, height or age incorrectly
        When I run this program
        Then the system raises an exception

        Examples:
            |  w  |  h  |  g  | age  |
            | -40 | 165 | 'm' |  15  |      
            | 35  | -165| 'm' |  15  |           
            | 80  | 175 |'men'|  30  |             
            | 90  | 180 | 'w' |  -50 |