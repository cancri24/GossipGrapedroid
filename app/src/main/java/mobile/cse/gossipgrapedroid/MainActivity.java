package mobile.cse.gossipgrapedroid;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Random rand = new Random();
    private String gossipType = "both";
    String theNews;
    TextView txView;
    int imageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txView = (TextView) findViewById(R.id.gossipBox);

        final ImageView imageView = (ImageView)findViewById(R.id.ivImage);
        Button btnImageChanger = (Button)findViewById(R.id.btnImageChanger);

        btnImageChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageNum == 1) {
                    imageView.setImageResource(R.drawable.btnomb2);
                } else if (imageNum == 2) {
                    imageView.setImageResource(R.drawable.btnomb3);
                } else if (imageNum == 3) {
                    imageView.setImageResource(R.drawable.btnomb4);
                } else if (imageNum == 4) {
                    imageView.setImageResource(R.drawable.nomorerip);
                } else if (imageNum == 5) {
                    imageView.setImageResource(R.drawable.btnomb);
                }
                if (imageNum < 5) {
                    imageNum++;
                } else  {
                    imageNum = 1;
                }


            }
        });
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
        theNews = Gossip.getGossip(gossipType);
        txView.setText(theNews);
    }

}
