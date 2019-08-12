# Project Title

Card Game for TARGET

# Description

A multiplayer card game, where 5 cards will be distributed to each player. The game has 5 rounds. In each round,
each player will draw a card randomly. A player with higher card will win the round and the player who will win maximum rounds will win the game.

## Getting Started

Copy the project and install the dependent jars for JUNIT testing. 
* Game Menu- 
1. Start Game 
2. Shuffle cards 
3. Distribute cards 
4. Start the game 
5. Exit 

### Prerequisites

This is a normal JAVA project. However to run run JUnit Test cases written you need to have the related jars.

## Scenarios handled

* The cards will be shuffled if choosen from the Menu
* The cards will be distributed among 4 players
* No player will get same card
* No more than 3 consecutive cards of the same suite
* No pattern repeating 
* If the user choose a card that is not in his/her deck, then he will be notified to choose from the deck only and the game will resume from the last executed point
* If the user starts the game without shuffling the deck or distributing the cards, then the user will be notified to shuffle the deck and distribute the cards
* The player winning the maximum number of round will be declared as winner


## Test cases

3 test cases were written - 
```
	a.  deriveValueTest
	b.  mostWinsTest
	c.  compileWinnerTest
```

## Built With

* InteliliJ IDEA 
