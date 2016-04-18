package ie.simonkenny.audioplaybackexample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button audioButton1 = (Button) findViewById(R.id.audio_button_1);
        Button audioButton2 = (Button) findViewById(R.id.audio_button_2);
        Button audioButton3 = (Button) findViewById(R.id.audio_button_3);

        if (audioButton1 != null && audioButton2 != null && audioButton3 != null) {
            // Set up OnClickListener for button 1
            audioButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startAudio(R.raw.discovery_ato);
                }
            });
            // Set up OnClickListener for button 2
            audioButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startAudio(R.raw.discovery_orbit);
                }
            });
            // Set up OnClickListener for button 3
            audioButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startAudio(R.raw.discovery_wheel_stop);
                }
            });
        }
    }

    private void startAudio(int audioResId) {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer = null;
        }
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), audioResId);
        mMediaPlayer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer = null;
        }
    }
}
