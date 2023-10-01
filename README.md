# corrupted-lottery

an app that finds the best numbers for the lottery company (it chooses the ticket(s) with the least hits)
This is a "shower thought" to see how easy or hard it is to cheat at lottery (as the lottery company).

The idea is to check all bought tickets and choose the numbers so:
1. No one wins the jackpot
2. The least amount of people win the 2nd price
    or (even better)
3. the ammount of money that people won is the smallest. (but for this I need to add value to each match for eg.: 5 matches - $1million, 4 matches - $100k, 3 matches - $1000, 2 matches - $10)

The app is still in development, so far it can: 
- generate all possible combinations
- generate x amount of random tickets
- save both list in a .txt file

problems:
- if there are too many combinations:
  - the app runs out of heap memory
  - the .txt files become huge
