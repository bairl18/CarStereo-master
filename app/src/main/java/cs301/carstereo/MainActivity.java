package cs301.carstereo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    ToggleButton power;
    ToggleButton amFm;
    TextView stationDisplay;
    Button preset1;
    Button preset2;
    Button preset3;
    Button preset4;
    Button preset5;
    Button preset6;
    SeekBar volume;
    SeekBar tuner;
    TextView printVol;

    int[] amPresets = {550,600,650,700,750,800};

    double[] fmPresets = {90.9,92.9,94.9,96.9,98.9,100.9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        power = (ToggleButton) findViewById(R.id.toggleButton);

        stationDisplay = (TextView)findViewById(R.id.textView);

        volume = (SeekBar) findViewById(R.id.seekBar2);

        tuner = (SeekBar) findViewById(R.id.seekBar);

        amFm = (ToggleButton) findViewById(R.id.toggleButton2);

        tuner.setOnSeekBarChangeListener(new ChangeSeekBarListener());

        preset1 = (Button) findViewById(R.id.button6);

        preset2 = (Button) findViewById(R.id.button7);

        preset3 = (Button) findViewById(R.id.button8);

        preset4 = (Button) findViewById(R.id.button9);

        preset5 = (Button) findViewById(R.id.button10);

        preset6 = (Button) findViewById(R.id.button11);

        preset1.setOnLongClickListener(new ChangePresets());
        preset2.setOnLongClickListener(new ChangePresets());
        preset3.setOnLongClickListener(new ChangePresets());
        preset4.setOnLongClickListener(new ChangePresets());
        preset5.setOnLongClickListener(new ChangePresets());
        preset6.setOnLongClickListener(new ChangePresets());

        printVol = (TextView) findViewById(R.id.textView5);
        volume.setOnSeekBarChangeListener(new ChangeVolumeListener());

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

    public void powerOn(View v)
    {
        if(power.isChecked())
        {
            power.setBackgroundColor(Color.GREEN);

            stationDisplay.setBackgroundColor(Color.GREEN);
            stationDisplay.setTextColor(Color.BLACK);

            volume.setBackgroundColor(Color.WHITE);

            tuner.setBackgroundColor(Color.WHITE);
        }
        else
        {
            power.setBackgroundColor(Color.LTGRAY);

            stationDisplay.setBackgroundColor(Color.BLACK);

            volume.setBackgroundColor(Color.BLACK);

            tuner.setBackgroundColor(Color.BLACK);

        }


    }

    public void changePreset(View v)
    {
        if(amFm.isChecked())
        {
            if (v == preset1)
            {
                stationDisplay.setText((float)fmPresets[0] + "FM");
            }
            else if (v == preset2)
            {
                stationDisplay.setText((float)fmPresets[1] + "FM");
            }
            else if (v == preset3)
            {
                stationDisplay.setText((float)fmPresets[2] + "FM");
            }
            else if (v == preset4)
            {
                stationDisplay.setText((float)fmPresets[3] + "FM");
            }
            else if (v == preset5)
            {
                stationDisplay.setText((float)fmPresets[4] + "FM");
            }
            else if (v == preset6)
            {
                stationDisplay.setText((float)fmPresets[5] + "FM");
            }
        }
        else
        {
            if (v == preset1)
            {
                stationDisplay.setText(amPresets[0] + "AM");
            }
            else if (v == preset2)
            {
                stationDisplay.setText(amPresets[1] + "AM");
            }
            else if (v == preset3)
            {
                stationDisplay.setText(amPresets[2] + "AM");
            }
            else if (v == preset4)
            {
                stationDisplay.setText(amPresets[3] + "AM");
            }
            else if (v == preset5)
            {
                stationDisplay.setText(amPresets[4] + "AM");
            }
            else if (v == preset6)
            {
                stationDisplay.setText(amPresets[5] + "AM");
            }
        }

    }

    public class ChangePresets implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {

            if (amFm.isChecked()) {
                if (v == preset1) {
                    fmPresets[0] = ((tuner.getProgress() * 0.2) + 88.1);
                } else if (v == preset2) {
                    fmPresets[1] = ((tuner.getProgress() * 0.2) + 88.1);
                } else if (v == preset3) {
                    fmPresets[2] = ((tuner.getProgress() * 0.2) + 88.1);
                } else if (v == preset4) {
                    fmPresets[3] = ((tuner.getProgress() * 0.2) + 88.1);
                } else if (v == preset5) {
                    fmPresets[4] = ((tuner.getProgress() * 0.2) + 88.1);
                } else if (v == preset6) {
                    fmPresets[5] = ((tuner.getProgress() * 0.2) + 88.1);
                }
            } else {
                if (v == preset1) {
                    amPresets[0] = tuner.getProgress() * 10 + 530;
                } else if (v == preset2) {
                    amPresets[1] = tuner.getProgress() * 10 + 530;
                } else if (v == preset3) {
                    amPresets[2] = tuner.getProgress() * 10 + 530;
                } else if (v == preset4) {
                    amPresets[3] = tuner.getProgress() * 10 + 530;
                } else if (v == preset5) {
                    amPresets[4] = tuner.getProgress() * 10 + 530;
                } else if (v == preset6) {
                    amPresets[5] = tuner.getProgress() * 10 + 530;
                }
            }
            return true;
        }
    }

    private class ChangeSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if (amFm.isChecked()) {

                seekBar.setMax(100);
                float p;
                p = (float)((seekBar.getProgress()*0.2)+88.1);
                stationDisplay.setText(p + "FM");
            }
            else
            {
                seekBar.setMax(117);
                int p;
                p = seekBar.getProgress()*10+530;
                stationDisplay.setText(p + "AM");
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class ChangeVolumeListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            seekBar.setMax(10);
            int v;
            v = seekBar.getProgress();
            printVol.setText(v + "");

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }


}
