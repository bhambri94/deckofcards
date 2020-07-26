### deckofcards

This is a backend automation framework setup for a set of deckofcards apis.

Setup:

```

git clone https://github.com/bhambri94/deckofcards.git

cd deckofcards

mvn test

```


As of now we have three below tests:
1. Generate a new Deck api should give 200 response code with a deck id
2. Using a deck id, user is able to draw cards.
3. After successful drawing 1 of the cards from a 52 card deck, remaining cards in response should be 51
