package tjcrew.pokerpalv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewGameOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_options);
    }

    public void Confirm(View v){
        Intent intent = new Intent(this, PlayerInformation.class);
        startActivity(intent);
    }
}
