package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.StringTokenizer;

public class HighScoreActivity extends AppCompatActivity {

    List<User> Users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_high_score_activitz);

        String filename = "DataEndless.txt";
        String string = "Név-1111;";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write(string);
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadFile();

        TextView tv = (TextView) findViewById(R.id.User1);
        User us = Users.get(0);
        tv.setText(us.getUserName()+" "+us.getHighscore());



    }

    public void loadFile() {
        Users.clear();
        File file = getApplicationContext().getFileStreamPath("DataEndless.txt");
        String LineFromData;
        if (file.exists())
        {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("DataEndless.txt")));
                while ((LineFromData = br.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(LineFromData,"-");
                    User usr = new User(st.nextToken(),Integer.getInteger(st.nextToken()));
                    Users.add(usr);
                }
                br.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
