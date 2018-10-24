package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import builditbigger.android.my.annin.jokesdepository.JokesFetch;
import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint
{

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name)
    {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    /**
     * An endpoint method that returns a joke; modeled after the sayHi method above and public void tellJoke(View view)
     * in app MainActivity
     */
    @ApiMethod(name = "getJokeFromRepository")
    public MyBean getJokeFromRepository()
    {
        MyBean response = new MyBean();
        JokesFetch myJokesFetch = new JokesFetch();
        response.setData(myJokesFetch.getRandomJoke());
        return response;
    }
}