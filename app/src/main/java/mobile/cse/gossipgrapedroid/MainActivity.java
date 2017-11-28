package mobile.cse.gossipgrapedroid;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Random rand = new Random();
    private String gossipType = "both";
    private boolean swarmMode = false;
    int counter = 0;
    String theNews = "I have so many juicy secrets. What would you like to know?";
    TextView txView;
    ConstraintLayout screen;
    EditText customName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txView = (TextView) findViewById(R.id.gossipBox);
        customName = (EditText) findViewById(R.id.customName);
        screen = (ConstraintLayout) findViewById(R.id.thescreen);

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(25);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(!txView.getText().equals(theNews)) {
                                    txView.setText(theNews.substring(0, counter));
                                    counter++;
                                }
                                else counter = 0;
                            }
                        });
                    }
                }
                catch (InterruptedException e) {}
            }
        };
        t.start();
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
        }
    }

    public void generateGossip(View view) {
        String name = String.valueOf(customName.getText());
        theNews = Gossip.getGossip(gossipType, swarmMode, name);
    }

    public void toggleSwarmMode(View view) {
        swarmMode = !swarmMode;
        if(swarmMode) screen.setBackgroundColor(Color.YELLOW);
        else screen.setBackgroundColor(Color.WHITE);

    }
}
