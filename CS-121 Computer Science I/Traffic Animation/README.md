****************
* Project 1: TrafficAnimation
* CompSci 121
* 19 September 2014
* Eric Miller
**************** 

PROJECT OVERVIEW:

This Java application displays a simple animation of Bart Simpson skateboarding 
across the screen repeatedly, as well as a few other graphics, including a car, 
background and Homer Simpson (observer).


INCLUDED FILES:

 * README - this file
 * TrafficAnimation.java - source code


BUILDING AND RUNNING:

All project files should be in the same directory.

From the directory containing the .java source code, compile the program:
    $ javac TrafficAnimation.java

Run the program from the directory containing Marshmallow.class:
    $ java TrafficAnimation

The animation will display. No user input is required.


PROJECT DESIGN NOTES:

Just about all of the code needed to animate our drawing was given to us. Almost
the entire project involved using the Graphics class to draw what we wanted to 
animate. We were also able to manipulate the animation to a certain degree by
changing things like direction and speed. After doing a small amount of reading, 
my limited knowledge about the JPanel class in regards to this project is that it 
creates a container in which to use the paintComponent method, which allows you to 
custom paint using methods from the graphics class. As for the rest of the template
that was set up for us, it seems that the program continuously repaints whatever
is inside paintComponent, ultimately creating an animation.

To keep the elements of our drawings proportional to the size of the window, I 
defined all heights and widths of the items in my drawing as a fraction of either 
the height or width of the window. I used a few anchor points as reference for each
of the characters in the drawing (Bart, Homer, the car) to make it easier to
calculate the x and y coordinates needed, and to keep the entire character moving
(as seen with Bart and the car). 

Originally, I had the text centered at the top of the page, but then I realized I
could simply tack it on to Bart's anchor point. I liked this better than having the 
text centered at the top because it made it look more like Bart was saying it.

The actual movement of the "vehicles" was accomplished by initializing an anchor 
point prior to the paintComponent method, and then redefining the variable as a 
modification of itself (x = x + 1). To get the objects to smoothly enter and exit
the panel, I defined another a integer prior to the paintComponent method
for both the car and Bart so that I could develop the cycle of x coordinates I 
needed for each and then apply that cycle of numbers to my anchor points.
I smoothed out the wrapping by having each anchor cycle start outside of the panel 
and making each cycle long enough that it ends outside of the panel.

I included several different methods from the Graphics class, and I also used a 
couple custom colors for the grass and sidewalk.


TESTING:

The testing for this program was relatively straightforward. I made sure the animation 
looked the way that I intended. I resized the window to make sure that the drawings scaled
properly. Since this program is simply an animation with no extra input required from the
user, it seems relatively free of issues.

DISCUSSION:

One mistake I made that ended up working out rather well was using height proportions to 
describe the width of an object in my picture. When I first noticed this, I saw that the
width of Bart and Homer didn't really change with respect to the window's width, but the
height did. I began to remedy this, but realized that the mistake I made was kind of nice
because otherwise, if the window proportions weren't just right, Bart and Homer looked
really strange (too wide or too narrow). So, I allowed for Bart and Homer to change height
but not width so that they would still look the right size regardless of the window height
to width proportion. Their positions of course remained proportional.

One issue I ran into was trying to scale the text, but it was mentioned in class that this 
should not be a concern. I also realized how inefficient and poorly organized some of my 
planning was in getting things positioned and proportioned correctly. I wrote much of the 
paintComponent code while without access to a computer, which inevitably led to some 
unexpected mistakes. However, these mistakes were easily remedied when testing the program.
This experience definitely supported the philosophy of frequently compiling and writing 
code incrementally as discussed in class.

The most common mistakes I made involved mixing up my y-axis signs, though that was an 
easy thing to fix.

The most challenging part of this project was the artistic aspect of making the characters 
look right. I think I've grown pretty comfortable with several of the methods in the Graphics
class. I enjoyed figuring out how to animate the wheels. If I had more time, I think I would
make the car look a little more detailed and add in some more background.

EXTRA CREDIT:

1. I animated the wheels on the car, although the drawing looks kind of poor. 
2. I smoothed out the wrapping of both the car and of Bart Simpson with his "Eat my shorts!" 
line. 
3. I included two "vehicles" (Bart and the car), which are traveling in opposite directions in 
separate lanes.
