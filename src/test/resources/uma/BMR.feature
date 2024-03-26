@tag
Feature: Basal Metabolic Rate
    As a user I want to calculate my basal metabolic rate (BMR) so that I can control my weight and take steps to be healthier 

    @tag1
    Scenario Outline: I give the program the correct parameters
        Given my gender <g>, weight <w>, height <h> and age <age> correctly
        When I calcule my BMR
        Then the system return my BMR <value> 

        Examples:
            |  w  |  h  |  g  | age  |  value    | 
            | 40  | 165 | 'm' |  15  |  1361.25  |      
            | 35  | 165 | 'm' |  15  |  1311.25  |            
            | 80  | 175 | 'm' |  30  |  1748.75  |            
            | 90  | 180 | 'w' |  50  |  1614     |            
      


    @tag2
    Scenario Outline: I give the program incorrect parameters
        Given at least my gender <g>, weight <w>, height <h> or age <age> incorrectly
        When I calcule my BMR
        Then the system raises an exception

        Examples:
            |  w  |  h  |  g  | age  |
            | -40 | 165 | 'm' |  15  |      
            | 35  | -165| 'm' |  15  |           
            | 80  | 175 | 'h' |  30  |             
            | 90  | 180 | 'w' |  -50 |