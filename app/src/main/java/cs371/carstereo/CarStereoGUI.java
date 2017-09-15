package cs371.carstereo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class CarStereoGUI extends AppCompatActivity implements OnClickListener, SeekBar.OnSeekBarChangeListener, Button.OnLongClickListener {

    private Button PowerButton;
    private Button StationDisplay;
    private Button Volume;
    private SeekBar Tuner;
    boolean powah = false;
    boolean AMFM = true;
    private Switch Radio;
    private Button One;
    private Button Two;
    private Button Three;
    private Button Four;
    private Button Five;

    int[] AMRadio = {550, 600, 650, 700, 750};
    double[] FMRadio = {90.9, 92.9, 94.9, 96.9, 98.9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_stereo_gui);

        PowerButton = (ToggleButton)findViewById(R.id.PowerButton);
        PowerButton.setOnClickListener(this);

        StationDisplay = (Button)findViewById(R.id.display);
        StationDisplay.setOnClickListener(this);

        Volume = (Button)findViewById(R.id.volumedisplay);
        Volume.setOnClickListener(this);

        Tuner = (SeekBar)findViewById(R.id.seekBar2);
        Tuner.setOnClickListener(this);
        Tuner.setOnSeekBarChangeListener(this);

        Radio = (Switch)findViewById(R.id.switch1);
        Radio.setOnClickListener(this);

        One = (Button)findViewById(R.id.Station5);
        One.setOnClickListener(this);

        Two = (Button)findViewById(R.id.Station4);
        Two.setOnClickListener(this);

        Three = (Button)findViewById(R.id.Station3);
        Three.setOnClickListener(this);

        Four = (Button)findViewById(R.id.Station2);
        Four.setOnClickListener(this);

        Five = (Button)findViewById(R.id.Station1);
        Five.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == PowerButton) {
            if (powah == false) {
                PowerButton.setBackgroundColor(Color.YELLOW);
                StationDisplay.setTextColor(Color.CYAN);
                Volume.setTextColor(Color.CYAN);
                Tuner.setVisibility(View.VISIBLE);
                powah = true;
            }
            else {
                PowerButton.setBackgroundColor(Color.GRAY);
                StationDisplay.setTextColor(Color.BLACK);
                Volume.setTextColor(Color.BLACK);
                Tuner.setVisibility(View.INVISIBLE);
                powah = false;
            }
        }

        if(v == Radio) {
            if(AMFM == false) {
                Tuner.setMax(117);
                StationDisplay.setText("530");
                AMFM = true;
            }
            else {
                Tuner.setMax(108);
                StationDisplay.setText("88.1");
                AMFM = false;
            }
        }

        if(v == One){
            if(AMFM==true) {
                StationDisplay.setText(AMRadio[0]+"");
            }
            else if(AMFM==false) {
                StationDisplay.setText(FMRadio[0]+"");
            }
        }
        if(v == Two){
            if(AMFM==true) {
                StationDisplay.setText(AMRadio[1]+"");
            }
            else if(AMFM==false) {
                StationDisplay.setText(FMRadio[1]+"");
            }
        }
        if(v == Three){
            if(AMFM==true) {
                StationDisplay.setText(AMRadio[2]+"");
            }
            else if(AMFM==false) {
                StationDisplay.setText(FMRadio[2]+"");
            }
        }
        if(v == Four){
            if(AMFM==true) {
                StationDisplay.setText(AMRadio[3]+"");
            }
            else if(AMFM==false) {
                StationDisplay.setText(FMRadio[3]+"");
            }
        }
        if(v == Five){
            if(AMFM==true) {
                StationDisplay.setText(AMRadio[4]+"");
            }
            else if(AMFM==false) {
                StationDisplay.setText(FMRadio[4]+"");
            }
        }
    }



    public void onProgressChanged(SeekBar b, int progress, boolean touch) {
        Log.i("error", "check");
        if (b == Tuner) {
            if (AMFM == true) {
                StationDisplay.setText((progress)*10+530+"");

            }
            else {
                Tuner.setMax(107);
                StationDisplay.setText((double)(progress*2+881)/10+"");

            }
        }
    }
    public void onStartTrackingTouch(SeekBar b) {

    }
    public void onStopTrackingTouch(SeekBar b) {

    }
    public void onLongClick(View c){
        if(c == One){
            if(AMFM==true) {
                AMRadio[0]=Tuner.getProgress();
            }
            else if(AMFM==false) {
                FMRadio[0]=Tuner.getProgress();
            }
        }
        if(c == Two){
            if(AMFM==true) {
                AMRadio[1]=Tuner.getProgress();
            }
            else if(AMFM==false) {
                FMRadio[1]=Tuner.getProgress();
            }
        }
        if(c == Three){
            if(AMFM==true) {
                AMRadio[2]=Tuner.getProgress();
            }
            else if(AMFM==false) {
                FMRadio[2]=Tuner.getProgress();
            }
        }
        if(c == Four){
            if(AMFM==true) {
                AMRadio[3]=Tuner.getProgress();
            }
            else if(AMFM==false) {
                FMRadio[3]=Tuner.getProgress();
            }
        }
        if(c == Five){
            if(AMFM==true) {
                AMRadio[4]=Tuner.getProgress();
            }
            else if(AMFM==false) {
                FMRadio[4]=Tuner.getProgress();
            }
        }
    }
}

