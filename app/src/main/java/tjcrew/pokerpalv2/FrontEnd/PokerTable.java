package tjcrew.pokerpalv2.FrontEnd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import tjcrew.pokerpalv2.R;

public class PokerTable extends AppCompatActivity {

    tableAdapter tableFill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_table);

        //adapter class code
        tableFill = new tableAdapter(this);
        pokerTableListView = (ListView)findViewById(R.id.PlayerListView);
        pokerTableListView.setAdapter(tableFill);

    }

    /** ADAPTER FOR POKER TABLE PLAYERS **/

    ListView pokerTableListView;

    class row{
        String name;
        String stack;
        String bet;
        //Player Status
        boolean out;  //sitting out

        row(String n, String s, String b, boolean o){
            this.name = n;
            this.stack = s;
            this.bet = b;
            this.out = o;
        }
    }

    class tableAdapter extends BaseAdapter{

        ArrayList<row> list;
        Context context;

        tableAdapter(Context c){
            context = c;
            list = new ArrayList<row>();
            String[] names = {"Player","Player","Player","Player","Player","Player","Player","Player","Player"};
            String[] stacks = {"10000","10000","10000","10000","10000","10000","10000","10000","10000"};
            String[] bets = {"1000","1000","1000","1000","1000","1000","1000","1000","1000"};
            //have one for status  ==== change ^ to real values later on
            boolean[] outs = {false, false, false, false, false, false,false, false, true, false};

            for(int i = 0; i < 9; i++){
                list.add(new row(names[i], stacks[i], bets[i], outs[i]));
            }
        }

        @Override
        public int getCount() {
            return 9;
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewRow = inflater.inflate(R.layout.playerpopulate,viewGroup,false);

            TextView viewName = (TextView) viewRow.findViewById(R.id.populateName);
            TextView viewMoney = (TextView) viewRow.findViewById(R.id.populateMoney);
            TextView viewBet = (TextView) viewRow.findViewById(R.id.populateBet);

            row temp = list.get(i);

            viewName.setText(temp.name);
            viewMoney.setText(temp.stack);
            viewBet.setText(temp.bet);

           /* switch(temp.turn)
            {
                case ACTIVE: turnLight.setImageResource(R.drawable.green_light); break;
                case WAITING: turnLight.setImageResource(R.drawable.yellow_light); break;
                case FOLD: turnLight.setImageResource(R.drawable.red_light); break;
                case IDLE: turnLight.setImageResource(R.drawable.red_light); break;
            } */

            /*if(temp.out == true)
                sitImage.setImageResource(R.drawable.sitoutimage);
            else
                sitImage.setImageResource(0); */

            return viewRow;
        }
    }


    /** END OF ADAPTER **/

}
