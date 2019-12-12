This is a game for 2 players and 1 deck of 52 standard cards.

Rules are easy - deck is being shuffled, then deck is being dealt between 2 players.

You can see how many rounds are needed to finish a game, and print all rounds.

At very beginning each player has 26 cards, cards behave like queue.

1st player takes one card (peek of his queue), put on a table.

2nd player takes one card (peek of his queue), put on 1st player's card.

/Higher ranked card won (suit doesn't matter), then player who won, takes cards, and add them into his queue at 
the end.(first card added  is 1st player's card, then 2nd player's card).

If cards are equal (have the same rank), it is time for a WAR!

Players create "fighting cards" list:
'#1 and #2 cards - already laying on a table.
'#3 card: 1st player takes next card (peek of his queue), put on #2 card.
'#4 card: 2nd player takes next card (peek of his queue), put on #3 card.
'#3 and #4 cards do not fight.
'#5 card: 1st player takes next card (peek of his queue), put on #4 card.
'#6 card: 2nd player takes next card (peek of his queue), put on #5 card.

We compare #5 to #6: if player1 win, he takes whole "fighting cards" list from a table and add to hid queue at the end.
(card #1 is added firstly, then #2, then #3 etc. If player2 win, he takes whole "fighting cards" list from a table and add to hid queue at the end.

It is possible, we have WAR again, so process needs to be repeated.

Player who collect all deck of cards is a WINNER!

In case if on of players have 1 or 2 cards, and this is a WAR time, this players automatically looses.

In case when both players have the same deck of 26 cards in hand sorted in the same order. It is DRAW.

If there is still no winner, game is finished after playing 1,0000,000 rounds, and winner is player with more cards in hand