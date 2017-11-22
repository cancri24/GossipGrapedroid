package mobile.cse.gossipgrapedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Random rand = new Random();
    private String gossipType = "both";
    String theNews;
    TextView txView;
    EditText feedbackTxtView;
    TextView feedbackResponse;
    ImageView shockImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txView = findViewById(R.id.gossipBox);
        feedbackTxtView = findViewById(R.id.ugh);
        feedbackResponse = findViewById(R.id.feedbackResponse);
        shockImageView = findViewById(R.id.shockImage);
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
    public void submitButtonClicked(View view){
        String inputText = feedbackTxtView.getText().toString();
        String responseText;
        if (inputText.equals("yes")){
            responseText = "glad you like it my dude";
            feedbackResponse.setText(responseText);
        }
        if (inputText.equals("no")){
            responseText = "well i don't care";
            feedbackResponse.setText(responseText);
        }
    }
    public void switchFeedbackButtonClicked(View view){
        setContentView(R.layout.activity_feedback);
    }
    public void switchMainButtonClicked(View view){
        setContentView(R.layout.activity_main);
    }
    public void generateGossip(View view) {
        theNews = Gossip.getGossip(gossipType);
        txView.setText(theNews);
        Random r = new Random();
        int v = r.nextInt(5);
        if (v == 1){
            shockImageView.setImageResource(R.drawable.shock1);
        }
        if (v == 2){
            shockImageView.setImageResource(R.drawable.shock2);
        }
        if (v == 3){
            shockImageView.setImageResource(R.drawable.shock3);
        }
        if (v == 4){
            shockImageView.setImageResource(R.drawable.shock4);
        }
        if (v == 5){
            shockImageView.setImageResource(R.drawable.shock5);
        }
    }
}
