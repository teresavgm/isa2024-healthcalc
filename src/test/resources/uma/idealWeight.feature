@tag
Feature: idealWeight
    As a user I want to calculate my ideal weight so that from it I can take steps to be healthier 

    @tag1
    Scenario Outline: I give the program the correct parameters
        Given two parameters that correspond to my gender and height
        When I run this program
        Then I should see my ideal weight
       
        Examples:
                |  g  |  h  | value  |
                | 'w' | 165 |   59   |
                | 'm' | 168 |   64   |
                | 'w' | 193 |   76   |
                | 'm' | 193 |   82   |
                


    @tag2
    Scenario Outline: I give the program the incorrect parameters
        Given my height in negative or an unrecognizable gender
        When I run this program
        Then the system raises an exception
        
        Examples:
                    |    g    |   h   |
                    |   'w'   | -192  |  
                    |   'i'   |  180  |
                    | 'women' |  192  |  
                    |  'men'  | -40   |