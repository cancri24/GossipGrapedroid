package mobile.cse.gossipgrapedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Random rand = new Random();
    private String gossipType = "both";
    String theNews;
    TextView txView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txView = (TextView) findViewById(R.id.gossipBox);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    //Person selected
                    gossipType = "person";
                    break;
            case R.id.radioButton2:
                if (checked)
                    //Item Selected
                    gossipType = "item";
                    break;
            case R.id.radioButton3:
                if(checked)
                    //Both selected
                    gossipType = "both";
                    break;
            case R.id.radioButton4:
                if (checked)
                    //Item Selected
                    gossipType = "none";
                    break;
        }
        }

    public void generateGossip(View view) {
        theNews = Gossip.getGossip(gossipType);
        txView.setText(theNews);
    }
}
