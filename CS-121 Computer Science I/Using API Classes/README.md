****************
* Project 2: Using API Classes
* CompSci 121
* 5 October 2014
* Eric Miller
**************** 

PROJECT OVERVIEW:

This Java application collects information about 3 songs from the user and
creates 3 Song objects by using the Song class provided. This information
is displayed in a playlist while a snippet from each song is played.

INCLUDED FILES:

 * README - this file
 * PlayList.java - main class
 * Song.java - Song class
 * input.txt - used for checking with automatic input
 * classical.wav - sound files used for checking
 * newAgeRythm.wav
 * westernBeat.wav


BUILDING AND RUNNING:

All project files should be in the same directory.

From the directory containing the .java source code, compile the program:
    $ javac PlayList.java

For auto input, run the program from the directory containing PlayList.class:
    $ java PlayList < input.txt 

The Playlist will display with song info, and one song snippet will play at a time.


PROJECT DESIGN NOTES:

The Song class was provided and only needed adjustment for the Extra Credit. The PlayList
class first initializes the variables needed for a Song object. Then the program requests
input from the user to define each variable using a Scanner. After all of the info for one
song has been collected and assigned to a variable, a new Song object is created from the 
given info. Since the playTime input is given in minutes and seconds (mm:ss) and needed to 
be converted to seconds, I used the indexOf() method to identify the index of the colon, 
then determined the playTime in seconds by substring() and parseInt() to extract out the
minutes and seconds portions separately and convert those strings to integers. Additionally,
the program multiplies the minutes integer by 60 to convert to seconds.

After creating the three Song objects, the program determines the average song length by 
adding each of their playTimes up and dividing by 3. Each respective playTime was gotten
by using the getPlayTime() method provided in the song class. DecimalFormat was used to 
format the average play time as a double value rounded to two decimal places.

To find the song with a play time closest to 4 minutes, the program determines the absolute
value of the difference between 240 seconds and each playTime. Then, using the min method
from the Math class, the program determines the lowest difference. Then, if statements are
used to check if the difference of each song is equal to this lowest difference. If it is,
then that respective song title is printed out.

Similar if statements were used to print the actual playlist out in increasing playTime. 
I used nested if statements to account for each of 6 possible orders of the songs. This is
also the portion of the program where the play() method that I created in the Song class
is used to play a snippet of each song in the correct order while displaying the song info.
The actual method for playing the music was mostly provided for us. The only thing I altered
was how the method chooses which file to play and what to display.


TESTING:

The testing for this program was simple enough. Since I'm on Windows, I had to use a
different command to use the provided input.txt file to automate the program input. 
(Get-Content input.txt | java PlayList) I had to google how to do this part, though I
can't recall the exact source I used. I quickly noticed that one of the sound files
was misspelled, so I just changed the spelling in the input.txt file to make it find
the file.

I tested the program manually several times with different scenarios, such as having
multiple songs with the same amount of time. It seemed that this could pose a problem,
so I altered my code a bit to allow for multiple song titles to display as being the
closest to 4 minutes, or the shortest song. I also tried running the program with a 
few sound files from my own library, just to confirm that it would work.

This program doesn't have a nice error message when given bad input, it just has a
run-time error.

DISCUSSION:

Before starting this project, it seemed pretty daunting. I didn't even fully grasp what
the program was supposed to do. But, taking things one step at a time, I realized that
it wasn't too hard to work the problems out. The biggest stumbling block I faced was just
finally deciding to implement the solutions that came to mind. For instance, with the 
nested if statements, I spent a good period of time trying to think of another way to 
complete the task. For some reason I was thinking that doing it with if statements would
just take way too long. For all I know, it might not be the most efficient solution, but 
once I actually just decided to go with it, it was really easy and a much smaller amount 
of code than I expected. 

I hadn't been familiar with parseInt() or indexOf() before this project, so that was a 
good learning experience.

EXTRA CREDIT:

I created the play() method in the Song class using the code provided in PlayMusic.java
to play the sound files in order of least play time to greatest, while displaying info
about the song as it plays. I just tacked the play method() to the end of each nested 
if statement with the proper order of songs.
