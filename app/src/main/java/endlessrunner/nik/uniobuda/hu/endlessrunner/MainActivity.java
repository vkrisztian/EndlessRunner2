package endlessrunner.nik.uniobuda.hu.endlessrunner;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void StartGame(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Name: ")
                .setTitle("New Game");
        builder.setView(R.layout.dialog);
        final AlertDialog dialog1 = builder.create();

        dialog1.show();
        Button OKButton = (Button) dialog1.findViewById(R.id.okbutton);
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = (EditText) dialog1.findViewById(R.id.userName);
                username = et.getText().toString();
                dialog1.dismiss();
                Intent game = new Intent(MainActivity.this,GameActivity.class);
                game.putExtra("usrname",username);
                startActivityForResult(game,1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode == RESULT_OK)
            {
                String usrName = data.getStringExtra("usr");
                Integer highscore = data.getIntExtra("high",0);
                Toast tt = Toast.makeText(getApplicationContext(),"New Score : "+highscore+" Congrats:  "+usrName,Toast.LENGTH_LONG);
                tt.show();
            }
        }

    }

    public void HighScore(View view) {
       Intent hs = new Intent(this,HighScoreActivity.class);
        startActivity(hs);

    }
}
