package rps.rsp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class page2 extends AppCompatActivity implements View.OnClickListener {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set what xml page style to display
        setContentView(R.layout.activitypage2);

        //setContentView(R.layout.popupwindow);

        ImageButton one = (ImageButton) findViewById(R.id.imageButtonRock);
        one.setOnClickListener(this); // calling onClick() method
        ImageButton two = (ImageButton) findViewById(R.id.imageButtonScissors);
        two.setOnClickListener(this);
        ImageButton three = (ImageButton) findViewById(R.id.imageButtonPaper);
        three.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onClick(View v) {
        //method for handling what happens when you click buttonImage.
        Random randomNum = new Random();
        int cpuMov;
        switch (v.getId()) {

            case R.id.imageButtonRock:
                // number between 1-3 inclusive (max-min+1)+1
                cpuMov = randomNum.nextInt(3-1+1)+1;
                buildAlert(cpuMov, "imageButtonRock");
                break;

            case R.id.imageButtonScissors:
                // number between 1-3 inclusive (max-min+1)+1
                cpuMov = randomNum.nextInt(3-1+1)+1;
                buildAlert(cpuMov, "imageButtonScissors");
                break;

            case R.id.imageButtonPaper:
                // number between 1-3 inclusive (max-min+1)+1
                cpuMov = randomNum.nextInt(3-1+1)+1;
                buildAlert(cpuMov, "imageButtonPaper");
                break;

            default:
                break;
        }

    }

    //builds the message that will be displayed
    void appendMessage(AlertDialog.Builder myAlert, String cpuMove, String result) {
        myAlert.setMessage("Computer selects " +cpuMove+ ", you " +result+ "!");
        myAlert.show();
        myAlert.setCancelable(true);

    }

    public void buildAlert(int move, String btnPressed) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        String cpuMove;
        String result;
        if (btnPressed.equals("imageButtonRock")) {
            //Toast.makeText(this, "hooray "+move, Toast.LENGTH_SHORT).show();
            if (move == 1) {
                cpuMove = "Rock";
                result = "tied";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert, cpuMove, result);
            }
            if (move == 2) {
                cpuMove = "Scissors";
                result = "won";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
            if (move == 3) {
                cpuMove = "Paper";
                result = "lost";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
        } else if (btnPressed.equals("imageButtonScissors")) {
            if (move == 1) {
                cpuMove = "Rock";
                result = "lost";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
            if (move == 2) {
                cpuMove = "Scissors";
                result = "tied";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert, cpuMove, result);
            }
            if (move == 3) {
                cpuMove = "Paper";
                result = "won";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
        } else { //imageButton is Scissors
            if (move == 1) {
                cpuMove = "Rock";
                result = "won";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
            if (move == 2) {
                cpuMove = "Scissors";
                result = "lost";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
            if (move == 3) {
                cpuMove = "Paper";
                result = "tied";
                //call appendMessage to append vars and display the message
                appendMessage(myAlert,cpuMove,result);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "page2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://rps.rsp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "page2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://rps.rsp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
