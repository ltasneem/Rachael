
A Simulated Moody Therapist ChatBot, Dr. Rachael

Based on simple Eliza Chat Bot

By: 
Srikant Kumar Kalaputapu
Toma Tadros
Taimur Sohrab
Lubaba Nuzhat Tasneem

Rachael is also a chat-bot like her daughter Eliza. But Rachael is moody! And she jumps around in the conversation.  And she won't let you leave. As a team you will implement a version of Rachael which will do the same thing as Eliza but more.

Add more replacements. See what else you can think of. Come up with at least fifteen.

Add more hedges to come up with at least fifteen.

Add more qualifiers. You should add more on your own to come up with at least fifteen.

Add at least fifteen random questions that can come up at any time.

These are not related to the conversation but can come up at any time. These will help keep the conversation going.For example. Is it going to rain today?

 

Rachael can learn to be moody

Add a class called Sentiment. Sentiment will create two word lists... one is happy and one is sad. If Rachael encounters a word and doesn't know if it's a happy word, a sad word (or neither) then she will ask the user "Does <word> make you happy or sad?". Add the word to the appropriate list. Once Rachael has enough words in her lists she can ask questions like:

What are you so happy/sad about?

 Here are two lists of words you can use:

positive-words-1.txtPreview the documentView in a new window  negative-words-1.txtPreview the documentView in a new window

 

Refer to earlier parts of the conversation

Rachael will randomly ask the user about something the user said earlier  Example, Earlier you said you didn't like your brother. Tell me why. (notice that the last part of this is a qualifier placed at the end, instead of the beginning of the question.

 

Load the previous session

You will be saving all the user entered questions to a file. Name that file after the patient. When that patient comes back then load their previous sessions so Rachael can refer to those questions as well.

 

Don't let them quit

When the user wants to quit Rachael must try to keep the user engaged by asking another question before letting them quit. For example, "So you want to leave. Before you go tell me ..." and refer to something in the conversation. Try to make the user quit three times before letting them leave and then telling them the cost of the bill.

Tell the user the cost of the session

Rachael is expensive. Her time costs $150.00 per 15 minute session. Keep track of how much time your user talks to Rachael and when the user finally quits tell the user the cost of the session.

 

Log your sessions

Keep a diary of the conversation in a file.

 

Create as many classes as you possibly can but no more than you really need. Keep the content of the main procedure as sparse as possible and let the classes do all the work.



