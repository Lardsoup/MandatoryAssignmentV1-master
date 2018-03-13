package com.example.lardman.mandatoryassignmentv1;

/**
 * Created by Lardman on 13-03-2018.
 */

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;

//TODO: kig på den her class og find ud af hvad den laver og om det passer til dit program
public class ReadHttpTask extends AsyncTask<String, Void, CharSequence> {
    @Override
    protected CharSequence doInBackground(String... urls) {
        String urlString = urls[0];
        try {
            CharSequence result = HttpHelper.GetHttpResponse(urlString);
            return result;
        } catch (IOException ex) {
            cancel(true);
            String errorMessage = ex.getMessage() + "\n" + urlString;
            Log.e("BOOK", errorMessage);
            return errorMessage;
        }
    }
}
