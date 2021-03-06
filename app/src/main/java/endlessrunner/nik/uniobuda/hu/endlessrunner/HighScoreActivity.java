package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.GridLayout;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class HighScoreActivity extends AppCompatActivity {

    List<User> Users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_high_score_activity);

        String filename = "DataEndless.txt";

        loadFile();

        Collections.sort(Users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);
        UserRecycleAdapter userRecycleAdapter = new UserRecycleAdapter(Users);
        recyclerView.setAdapter(userRecycleAdapter);





    }

    public void loadFile() {
        if (Users!= null) {
            Users.clear();
        }
        else
        {
          Users  = new ArrayList<>();
        }
        File file = getApplicationContext().getFileStreamPath("DataEndless.txt");
        String LineFromData;
        if (file.exists())
        {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("DataEndless.txt")));
                while ((LineFromData = br.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(LineFromData,"-");
                    User usr = new User(st.nextToken(),Integer.parseInt(st.nextToken()));
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
