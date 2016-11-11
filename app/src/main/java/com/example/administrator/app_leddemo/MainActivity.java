package com.example.administrator.app_leddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.example.administrator.hardlibary.*;

public class MainActivity extends AppCompatActivity {

    private boolean ledon = false;
    private Button button = null;
    private CheckBox checkBoxLed1 = null;
    private CheckBox checkBoxLed2 = null;

    class MybuttonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int i;
            ledon = !ledon;
            if(ledon) {
                button.setText("ALL OFF");
                checkBoxLed1.setChecked(true);
                checkBoxLed2.setChecked(true);
                for(i=0;i<2;i++)
                    HardControl.ledCtrl(i,1);
            }
            else {
                button.setText("ALL ON");
                checkBoxLed1.setChecked(false);
                checkBoxLed2.setChecked(false);
                for(i=0;i<2;i++)
                    HardControl.ledCtrl(i,0);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(),"LED1 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(),"LED1 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                break;
            case R.id.LED2:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(),"LED2 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(),"LED2 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;
            // TODO: Veggie sandwich
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BUTTON);

        HardControl.ledOpen();

        checkBoxLed1 = (CheckBox) findViewById(R.id.LED1);
        checkBoxLed2 = (CheckBox) findViewById(R.id.LED2);

        button.setOnClickListener(new MybuttonListener(){

/*
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ledon = !ledon;
                if(ledon)
                    button.setText("ALL OFF");
                else
                    button.setText("ALL ON");
            }
*/
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
