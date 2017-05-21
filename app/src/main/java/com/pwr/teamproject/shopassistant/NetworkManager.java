package com.pwr.teamproject.shopassistant;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mokry on 21-May-17.
 */

public class NetworkManager {

    private String API_URL = null;

    public NetworkManager()
    {
        API_URL = "http://shopassistantapi.azurewebsites.net/api/";
    }

    public boolean isAccountValid(String username, String password){
        try {
            URL url = new URL(API_URL + "users?login=" + username + "&pass=" + password);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            // if response is 200 account exist
            if(responseCode == 200){
                return true;
            }
            else return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
