package builditbigger.android.my.annin.jokesdepository;

import java.util.Random;

public class JokesFetch
{
    /*
   Jokes copied and pasted from https://top-funny-jokes.com/
    */
    private static final String[] jokesList = new String[]
            {"Where did Lucy go after the explosion? Everywhere.",
                    "What´s the stupidest animal in the jungle? The polar bear.",
                    "My grandfather had the heart of lion and a lifetime ban from the New your city zoo.",
                    "Two mice chewing on a film roll. One of them says. I think the book was better.",
                    "What kind of bagel can fly? A plain bagel."
            };

    public String getRandomJoke()
    {
        // Code structure below is based on the answer given in this thread:
        // https://stackoverflow.com/questions/13340516/random-element-from-string-array/13340579
        String joke = jokesList[new Random().nextInt(jokesList.length)];
        return joke;
    }
}
