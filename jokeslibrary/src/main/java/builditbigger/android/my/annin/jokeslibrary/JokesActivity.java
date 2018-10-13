package builditbigger.android.my.annin.jokeslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity
{
    public static final String JOKE_STRING = "Joke string";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_STRING);
        TextView textView = findViewById(R.id.joke_android);
        textView.setText(joke);
    }
}
