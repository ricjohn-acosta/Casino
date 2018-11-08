# Casino

<b>Overview:</b><br>
Casino is a java application that contains 3 main, console-based, text games.

<b>Main Classes</b><br>
<b>1. SlotMachine.java (singleplayer)</b>
  - A slot machine that can has the features of pulling lever(generate random numbers and go through a series of logic), top-up machine(in order to use the slot machine the user should input credits), check balance, cash out(cash out earnings), swap slot machines(total of 3 possible slot machines that the user can swap to), show house credit(outputs the total credits inside the slot machines that have been used).
  
<b>2. DrinkingGame.java (multiplayer)</b>
  - A 2-person game that is basically a higher-lower card game. Each player draws a card from a deck. The game will run until there are no more cards in the deck. The player with a "higher" card wins.
  
<b>3. Snap.java (multiplayer)</b>
  - A 2-person, higher-lower card game similar to DrinkingGame but with a twist. Players take turns drawing a card from the main deck and placing them into a pile. If the cards that have been placed in the pile are the same, the first player who "snaps" will take all the cards in the pile. If a player calls a snap incorrectly (when the cards that have been placed do not match) the other player gets to collect the pile.

<b>4. Card.java</b>
  - Card.java creates card objects that will be called in the deck class.

<b>5. Deck.java</b>
  - Deck.java creates a deck filled with 52 card objects. The deck can be shuffled to arrange the card objects in a random order.
