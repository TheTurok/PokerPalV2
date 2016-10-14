package tjcrew.pokerpalv2.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tjcrew.pokerpalv2.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void newGame(View v){
        Intent intent = new Intent(this, NewGameOptions.class);
        startActivity(intent);
    }

}
