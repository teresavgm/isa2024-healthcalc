@tag
Feature: idealWeight
    As a user I want to calculate my ideal weight so that from it I can take steps to be healthier 

    @tag1
    Scenario Outline: I give the program the correct parameters
        Given my gender <g> and height <h> correctly
        When I calcule my ideal weight
        Then the system return my ideal weight <value>
       
        Examples:
                |  g  |  h  | value  |
                | 'w' | 165 |   59   |
                | 'm' | 168 |   64   |
                | 'w' | 193 |   75.8 |
                | 'm' | 193 |   83   |
                


    @tag2
    Scenario Outline: I give the program the incorrect parameters
        Given my height <h> in negative or an unrecognizable gender <g>
        When I calcule my ideal weight
        Then the system raises an exception
        
        Examples:
                    |    g    |   h   |
                    |   'w'   | -192  |  
                    |   'i'   |  180  |
                    |   'j'   |  192  |  
                    |   'h'   | -40   |