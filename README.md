# CSD 420 - Advanced Java Programming

## Week One

**Monday, March 23rd, 2026 through Sunday, March 29th, 2026**

### Module One: JavaFX Controls and Event-Driven Programming Item Options

In the last course, CSD 402, you were introduced to the basics of JavaFX. In this module, you will work with JavaFX’s user interfaces and Events. Along with that, you will use Lambda Expressions.

- Explain the ‘what’, ‘how’, and ‘why’ of Java and JavaFX.
- Create an event-driven application.
- Write Lambda anonymous functions.
- Use Lambda expressions.

#### Deliverables

- Review Module Resources.
- Course Introduction Discussion Board - Due by Sunday 11:59 p.m., CST.
- Module 1 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 1 Assignment - Due by Sunday 11:59 p.m., CST.
- Module 1 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapters 15 & 16 in Introduction to Java: Programming and Data Structures.
- Search the web for additional information on JavaFX’s history, current status, and future expectations. One possible helpful resource is JavaFX Tutorial - JavaFX Introduction JavaFX Tutorial (tutorialspoint.com, 2024).
- Search the web for additional information on MouseEvents, KeyEvents, Animation, PathTransition, FadeTransition, and TimeLine. One possible helpful resource is Java Tutorial.
- More JavaFX Video.
    - More_JavaFX_Examples.zip.
- Shapes Video.
    - Shapes_Examples.zip.
- Events Video.
    - Events_Video_Examples.zip.

#### Discussion Board

##### Introductions

Please reintroduce yourself to your cohort by posting an introduction of yourself. If you feel comfortable, tell us a little about where you are from and any hobbies that you enjoy.

##### 1.1 JavaFX Instructions

Select two of the following topics on JavaFX and discuss their features and provide examples for your initial post, along with your code. Include in your code documentation an explanation of how the code functions. You should also include the resources you used.

- JavaFX Line
- JavaFX Rectangle Ellipse
- JavaFX Path
- JavaFX Circle Arc
- JavaFX Polygon Polyline
- JavaFX Curve
- JavaFX Color
- JavaFX Gradient Color
- JavaFX Text

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### 1.2 GitHub Repository Setup

For this module’s assignment, we will be creating a GitHub repository using git and the CLI. The repository we create in this assignment will be used throughout the course to host the coding assignments. If you have not already installed git (https://www.atlassian.com/git/tutorials/install-git), please do so before continuing. Make sure that you include the steps to set the global username and global email address.

**Instructions:**

- Click on each instruction box below to expand the instructions.
- Complete the setup instructions and save the following items into a single Word document:
    - Link to your GitHub repository
    - Screenshot of your GitHub repository
    - Screenshot of your local directory, following the structure format provided in the instructions below.

##### 1.3 Programming Assignment

Follow the directions below:

Write a JavaFX program that displays four images randomly selected from a deck of 52 cards. The AssignmentCards.zip has card files titled 1.png, 2.png, 3.png, 4.png, …, 52.png. For this application:

- Store the images in a “cards” subdirectory.
- Using these cards, randomly select four cards for display.
- Below the cards, there will be a refresh button that will then display four different cards.
- Use Lambda Expressions.
- You may use a different set of images that you either have or decide to make.  

**Assignment Requirements and Grading:**

- This assignment is due by Sunday, 11:59 p.m., CST.
- Add the necessary documentation as described in Documentation Requirements. Click for more options.
- Capture screenshots, combined in a single Word document, demonstrating you have correctly installed and configured Java and JavaFX. Include your name, date, and assignment number.
- Submit your assignment by clicking in the Module Assignment, then use the Attach Files icon from the toolbar (the paperclip). Select your assignment file, add the URL to your GitHub repository in the comments area, and then click on Submit.
    - \<your_last_name\>-\<module_number\>\<course\>.zip.
    - Example: darrell_mod_2_csd420.zip.

#### Summary

- This module was a deeper dive into JavaFX and the different aspects that come with it.
- Specifically, the use of buttons and events that trigger the buttons.
- Events can also be used to trigger when a key is pressed or the mouse is clicked or even moved.
- Triggers call for methods which can perform any programming function you need it to.

## Week Two

**Monday, March 30th, 2026 through Sunday, April 5th, 2026**

### Module Two: Binary I/O and Recursion

In the last module, you learned about Event-Driven programming, working with Events and Event sources, and Lambda Expressions. In this module, you will be introduced to Java’s classes for performing file I/O. We will use both text and binary I/O. Some of the Java classes we will use are RandomAccessFile, BufferedInputStream, BufferedOutputStream, FileInputStream and FileOutputStream. In addition, you will be introduced to Recursion.

- Explain the ‘what’, ‘how’, and ‘why’ of the Java,s Binary I/O and Recursion.
- Understand and use Binary File I/O.
- RandomAccessFile.
- BufferedInputStream.
- BufferedOutputStream.
- FileInputStream.
- FileOutputStream.
- Write and use Recursive Methods.
- Use the GitHub repository.

#### Deliverables

- Review Module Resources.
- Module 2 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 2 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapters 17 & 18 in Introduction to Java: Programming and Data Structures.
- Read the [Java Tutorial](https://www.w3schools.com/java/), including Java Files, Java Create/Write Files, Java Read Files, Java Delete Files, and Java Recursion.
- Print Writer Video.
    - PrintWriter_Video_Examples.zip.
- Random Access File Video.
    - RandomAccessFile_Video_Examples.zip.
- Recursion Examples Video.
    - Recursion_Video_Examples.zip.

#### Discussion Board

Discuss at least two of the following topics on Recursion for your initial post. Provide a code example to elaborate on your thoughts.

- Sort using recursion.
- Binary search using recursion.
- Discuss how recursive method invokes are handled in a call stack.
- How to print a directory structure file list using recursion.

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 2.2 

**Follow the directions below:**

- Write a program that stores:
    - An array of five random integers.
    - An array of five random double values.
- Write the data in a file titled [yourname] datafile.dat.
- If there is no file, the file will be created.
- If there is a file, the data will be appended.
- Write a second program that will read the file and display the data.
- Test the code to ensure the code functions correctly. 

**Assignment Requirements and Grading:**

- This assignment is due by Sunday, 11:59 p.m., CST.
- Add the necessary documentation as described in Documentation Requirements. Click for more options.
- Capture screenshots, combined in a single Word document, demonstrating you have correctly installed and configured Java and JavaFX. Include your name, date, and assignment number.
- Submit your assignment by clicking in the Module Assignment, then use the Attach Files icon from the toolbar (the paperclip). Select your assignment file, add the URL to your GitHub repository in the comments area, and then click on Submit.
    - \<your_last_name\>-\<module_number\>\<course\>.zip.
    - Example: darrell_mod_2_csd420.zip.

#### Summary

This module dealt with recursive functions and writing to files i both binary and text formats.

**Writing to files:**
In a text format, it would be human readable, but it takes up more space (each character is encoded to be read by a text reader). In binary format, text is written directly to it's binary format, which means that it harder to parse.  But it takes up far less physical space on a hard drive so it is preferable to store information this way when possible.

Recursive Functions:
Recursive functions are functions that call themselves.  The classic example is a factorial function.  $f(n) = n * f(n-1)$ 

Another example is a recursive directory function.  The function looks through a directory and prints the information for a file if it is a file, and calls the full directory search function if it is a directory, showing the full directory and subdirectories of a directory.

Recursive functions can be dangerous because if they are not properly executed, they can call themselves indefinitely and cause your program to crash.


## Week Three

**Monday, April 6th, 2026 through Sunday, April 12th, 2026**

### Module Three: Generics

In the last module, you worked with File I/O and Recursion. In this module, you will be introduced to generics. We will address the benefits of using generics, learn to define both generic classes and interfaces, and then how to implement them.

- Create Generics Classes.
- Implement Generic Classes.
- Use the GitHub repository.

#### Deliverables

- Review Module Resources.
- Module 3 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 3 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapter 19 in Introduction to Java: Programming and Data Structures.
- Read the Java Tutorial, including Java Iterator.
- Search the Web for Java information on Generics in Java.
    - One possible helpful resource is Generics in Java (geeksforgeeks.org, 2024).
- Generic Introduction Video.
    - Generic_Intro_Examples.zip.
- Classes and Methods Video.
    - Classes_and_Methods_Examples.zip

#### Discussion Board

Discuss at least two of the following topics on Generics for your initial post. Provide a code example, where necessary, to elaborate on your thoughts.

- Benefits of generics.
- Use and definition of generic classes and interfaces.
- Use of generic methods.
- Raw generic types for allowing backward compatibility.

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 3.2 - Generics

Write a test program that contains a static method that returns a new ArrayList:

- The new ArrayList returned will contain all original values with no duplicates from the original ArrayList.
- Fill the Original ArrayList with 50 random values from 1 to 20.
- `public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)`

**Assignment Requirements and Grading:**

- This assignment is due by Sunday, 11:59 p.m., CST.
- Add the necessary documentation as described in Documentation Requirements. Click for more options.
- Capture screenshots, combined in a single Word document, demonstrating you have correctly installed and configured Java and JavaFX. Include your name, date, and assignment number.
- Submit your assignment by clicking in the Module Assignment, then use the Attach Files icon from the toolbar (the paperclip). Select your assignment file, add the URL to your GitHub repository in the comments area, and then click on Submit.
    - \<your_last_name\>-\<module_number\>\<course\>.zip.
    - Example: darrell_mod_2_csd420.zip.

#### Summary

This module focused on Generics.  A generic is basically a generic type that can be used that gets defined when something gets assigned to it.  The best advantage of it is when making a method to read something, such as Integers, Doubles, ints, floats, etc that can be reused for each, rather than making multiple overloaded methods, you can make one method with a generic type.  It still keeps all the type cast requirements, but allows you to essentially have the type be "any" coming in. 


### Module Four: Generics & Lists, Stacks, and Queues

In the last module, we learned about generics, their benefits, and how to define generic classes. In this module, we will look at Java Collections. We will use List, Stacks, and Queues. For collections, we will also learn to iterate through them using a foreach loop. We will also address ArrayList and LinkedList, when and how to use them.

- Explain the ‘what’, ‘how’, and ‘why’ of Java Collections.
- Write and use Java Collections.
- Lists.
- ArrayList.
- LinkedList.
- Stacks.
- Queues.

#### Deliverables

- Review Module Resources.
- Module 4 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 4 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapter 20 in Introduction to Java: Programming and Data Structures.
- Read the Java Tutorial, including Java ArrayList and Java LinkedList.
- ArrayList Review Video.
    - ArrayList_Review_Examples.zip.
- More on Lists Video.
    - MoreOnLists_2_Examples.zip.

#### Discussion Board

Discuss at least two of the following topics on Lists, Stacks, Queues, and Priority Queues for your initial post. Provide a code example, where necessary, to elaborate your thoughts.

- Using foreach loops to traverse elements in a collection.
- The difference between ArrayList and LinkedList, advantages and disadvantages of each.
- Collection methods for sorting, searching, shuffling a list, and finding the largest and smallest elements.
- Describe Vectors, ArrayList, and Stacks, explaining the differences.

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 4.2:

Write a test program that stores 50,000 integers in a LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method.

- Test your program storing first 50,000 and then 500,000 integers.
- After completing this program and having tested both values, in your comments, explain the results and discuss the time taken using both values and their difference with the get(index) approach.
- Write test code that ensures the code functions correctly.

**Assignment Requirements and Grading:**

- This assignment is due by Sunday, 11:59 p.m., CST.
- Add the necessary documentation as described in Documentation Requirements. Click for more options.
- Capture screenshots, combined in a single Word document, demonstrating you have correctly installed and configured Java and JavaFX. Include your name, date, and assignment number.
- Submit your assignment by clicking in the Module Assignment, then use the Attach Files icon from the toolbar (the paperclip). Select your assignment file, add the URL to your GitHub repository in the comments area, and then click on Submit.
    - \<your_last_name\>-\<module_number\>\<course\>.zip.
    - Example: darrell_mod_2_csd420.zip.

#### Summary

This week focused on the use of ArrayLists and LinkedLists as well as Stacks and Queues.  There are advantages and disadvantages to each.

## Week Four

**Monday, April 13th, 2026 through Sunday,April 19th, 2026**

### Module Five: Sets, Maps, and Sorting

In the last module, we learned about Java Collections such as List, Stacks, and Queues. In this module, we will learn about additional Collections: Sets and Maps. Some of the types of Sets and Maps we will look at are HashSet, LinkedHashSet, TreeSet, HashMap, LinkedHashMap, and TreeMap.

#### Deliverables

- Review Module Resources.
- Module 5 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 5 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapters 21 & 23 in Introduction to Java: Programming and Data Structures.
    - Read the [Java Tutorial](https://www.w3schools.com/java/default.asp), including Java HashSet, Java HashMap, Java Enums, Java RegEx, and Java Wrapper Classes.
- Sets Video.
    - Set_Examples.zip.
- Maps Video.
    - Maps Example.zip

#### Discussion Board

Discuss one of the following topics on Sets and Maps for your initial post. Provide a code example to elaborate on the collection you have selected and your thoughts on that collection type.

- Sets
- Maps

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 5.2

Follow the directions below:

Write a test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.

- The file is to be referenced in the program, not needing to be used as a command-line reference.
- The Word file is to be titled collection_of_words.txt and included in your submission.
- Write test code that ensures the code functions correctly.

#### Summary

This module talked about Sets, Maps, and Sorting.  A set is different from a list or map because it doesn't allow duplicate values, and that is is unordered.  This can be useful in many cases, especially for cases when you want to know if a value is "in" a list.  THe processing time is much faster looking through a set for this than a list.  A map is like a dictionary and one of the most powerful collections in programming.  It allows you to pair a key with a value, and has powerful methods for retrieving those values.  Sorting is a key tool to use, especially when you are unable to use an automatic sorting method.  Several methods for sorting were discussed.

## Week Five

**Monday, April 20th, 2026 through Sunday, April 26th, 2026**

### Module Six: Lists, Stacks, Queues and Priority Queues, Sets & Maps

In this module, we will learn about sorting and implementing List and Queues. Some of the sorts we will learn are insertion, bubble, merge, and binary. We will also learn about interfaces of Collection subtypes, Enums, wrapper classes, and regular expressions.

#### Deliverables

- Review Module Resources.
- Module 6 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 6 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapter 24 in Introduction to Java: Programming and Data Structures.
- Read the [Java Tutorial](https://www.w3schools.com/java/), including Java Enums, Java RegEx, and Java Wrapper Classes.
- Insertion Video.
    - Insertion_Sort_Example.zip.
- Bubble Video.
    - Bubble_Sort_Examples.zip  

#### Discussion Board

The following topics cover Java features. Choose one topic from Group 1 and one topic from Group 2 for your initial post. For each of the topics you have selected, provide code examples to elaborate on your thoughts.

**Group 1**

- Enums
- Wrapper Classes
- Regular Expressions

**Group 2**

- Comparable
- Comparator

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 6.2

Follow the directions below:

- Write a program with the two following generic methods using a bubble sort: Module 6 Programming Assignment Click for more options. The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
- Bubble_Sort.java Click for more options is a solution zip file for your review. Ensure you write your own code, only using the attached solution as an example, and document your code.
- Write test code that ensures your code functions correctly.

#### Summary

This chapter dove deeper under the hood in how Lists, Stacks, Queues and whatnot worked.  It also talked about Comparator and Comparable classes and how and when to use them.  The biggest take away I took from this section is that Enums in Java work differently than they do in most languages.  In most languages, they are a set list of things that a variable can be.  In Java, that act as miniature classes, with each member of the Enum being able to hold different values in the same way a class object can hold values (or attributes).  It can also hold methods like getters and setters.  The issue with this is that it can blur the line between an Enum and a proper Class.

## Week Six

**Monday, April 27th, 2026 through Sunday, May 3rd, 2026**

### Module Seven: More JavaFX

In the last module, we learned about sorting and implementing List and Queues. In this module, we will take another look into JavaFX, going over advanced JavaFX features. One of the additional JavaFX features we will look at is JavaFX CSS. We will also learn about using JavaFX to translate, rotate, and scale node coordinates, in addition to other features such as Menus and Panes.

#### Deliverables

- Review Module Resources.
- Module 7 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 7 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapter 31 in Introduction to Java: Programming and Data Structures.
- Search the web for Java information on Advanced JavaFX and FXML.
    - One possible helpful resource is [Introduction to FXML](https://openjfx.io/) (openjfx.io, 2017).
    - Another possible helpful resource is Creating JavaFX user interfaces using FXML.
- JavaFX-CSS Video.
    - JavaFX-CSS_Examples.zip.
- Translations Rotations Strokes Video.
    - Translations_Rotations_Strokes_Examples.zip.

#### Discussion Board

The following topics cover Advanced JavaFX and FXML. Choose one topic from Group 1 and one topic from Group 2 to discuss for your initial post. Provide a code example, where necessary, to elaborate on your thoughts.

**Group 1**

- Rotations
- Menus
- SplitPane
- TableView
- Controller
- Handling Controller Events

**Group 2**

- FXML Program Development

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 7.2

Follow the directions below:

- Create an external CSS style sheet that defines a class for white fill and black stroke color and an ID for red and green color.
- Write a JavaFX program that displays four circles and uses the style class and ID. The sample run of the program is shown in the following image. Use the mystyle.css found early in Chapter 31, something like the following code and image: Module 7 Programming Assignment.
- Write test code that ensures your code functions correctly.

#### Summary

### Module Eight: Multithreading

In the last module, we learned about advanced JavaFX features. In this module, we will learn about multithreading using Java’s Thread class and Runnable interface. We will cover starting and stopping threads along with handling thread exceptions. Lastly, we will address methods and block synchronization.

#### Deliverables

- Review Module Resources.
- Module 8 Discussion Board Initial Post - Due by Thursday 11:59 p.m., CST.
- Discussion Board Responses - Due by Sunday 11:59 p.m., CST.
- Module 8 Programming Assignment - Due by Sunday 11:59 p.m., CST.

#### Resources

- Read Chapter 32 in Introduction to Java: Programming and Data Structures.
- Search the web for additional information on Multithreading and Parallel Programming using Java.
    - One possible helpful resource is Multithreading in Java.
- Threads Video.
    - Thread_Examples.zip.
- Runnable Video.
    - Runnable_Interface_Examples.zip.
- Join Video.
    - Join_Threads_Example.zip.

#### Discussion Board

The topics for this discussion cover Multithreading and Parallel Programming using Java. Choose one topic from Group 1 and one topic from Group 2 for your initial post. Provide a code example where necessary to elaborate on your thoughts.

**Group 1**

- Runnable Interface, Advantages and Disadvantages
- Thread Class, Advantages and Disadvantages

**Group 2**

- StringBuilder and StringBuffer

**'What', 'How', and 'Why'**

- **What:** What are you writing about? Give the audience a brief overview of the topic by providing them with foundational information (history, background information, etc.).
- **How:** How is the information relevant? Apply personal knowledge (this can be through research or actual practiced knowledge) to build trust with the audience.
- **Why:** Justify your position and/or course of action. The audience needs proof the information you are presenting is creditable and actionable.

#### Assignments

##### Assignment 8.2

Follow the directions below:

- Create a class titled [your first="" name="" here=""] ThreeThreads.
    - In this class, you are to use three threads to output three types of characters to a text area for display.
        - In the first thread, you are to output random letter characters such as a, b, c, d …
        - In the second thread, you are to output random number digits such as 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
        - In the third thread, you are to output random characters such as !, @, #, $, %, &, *
    - Display a minimum of 10,000 for each of the three sets.
- Write test code that ensures all methods function correctly.
- Lastly, do not display all data for each thread together.  Each character is to be displayed as each one is generated.  Example:
    - 179$^fq*fg1k1k2^%1m4

#### Summary
