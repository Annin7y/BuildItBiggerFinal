package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import builditbigger.android.my.annin.jokesdepository.JokesFetch;


public class MainActivity extends AppCompatActivity
{
      //  public static final String JOKE_STRING = "Joke string";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   // Intent intent = new Intent(getContext(), JokesActivity.class);
   // intent.setAction(Intent.ACTION_SEND);
     // intent.putExtra( MainActivity.JOKE_STRING, myJokesFetch.getRandomJoke());
  //  startActivity(intent);


    public void tellJoke(View view)
    {
        JokesFetch myJokesFetch = new JokesFetch();
        //default code replaced with the code referencing JokesLibrary
       // Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, myJokesFetch.getRandomJoke(), Toast.LENGTH_SHORT).show();
    }
}
