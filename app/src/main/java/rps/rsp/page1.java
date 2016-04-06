package rps.rsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitypage1);

        Button advanceToPage2 = (Button) findViewById(R.id.continue_button);
        // set the button to the button in the view with id "continue_button"
        assert advanceToPage2 != null;
        advanceToPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page1.this, page2.class);
                //we are in page1 and want to get into page2
                startActivity(intent);
                //execute
            }
        });
    }


}
