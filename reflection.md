## Reflection: MinHeap Assignment (Week 02) 
In this assignment, I was asked to implement the `heapifyUp()` method for the `MinHeap` class. My first idea for the coding was  that a newly inserted element should be compared with its parent and swapped if the min-heap property was violated. However, my version was more complicated and not as clean as Professor Leo's posted solution.

Leo’s version showed was ompact and showed how a clearly-commented loop can be. His method uses a simple while-loop that checks for violations and repeatedly swaps the child and parent until the property is restored. I also noticed that his code avoids multiple returns, uses clear variable names like `index`, and keeps comments concise but effective—all which I'm going to try to do as 
he did. 

One thing I didn’t account for at first was proper guarding of index boundaries or assuming the tree starts from a valid usage point. Reviewing the full class taught me how crucial `this.usage - 1` is and why the helper methods like `parent()` or `swap()` keep things modular.

Going forward, I plan to spend more time reviewing what I’ve written and comparing it to known-good examples. I’ll also start earlier to give myself time for deeper testing and reflection. Finally, I’ll make sure my comments not only explain what the code does but also why it does it that way adding more depth to it. 
