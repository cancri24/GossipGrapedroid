package mobile.cse.gossipgrapedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

//TODO: add at one more control and text input

public class MainActivity extends AppCompatActivity {
    public static Random rand = new Random();
    private String gossipType = "both";
    private boolean swarmMode = false;
    TextView txView;
    EditText customName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txView = (TextView) findViewById(R.id.gossipBox);
        customName = (EditText) findViewById(R.id.customName);
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
        String name = customName.getText();
        txView.setText(Gossip.getGossip(gossipType, swarmMode, name));
    }

    public void toggleSwarmMode(View view) {
        swarmMode = !swarmMode;
    }
}
