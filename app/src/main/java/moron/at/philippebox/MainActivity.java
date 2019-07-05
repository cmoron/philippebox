/*
 * (C) Copyright 2019 Cyril Moron.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package moron.at.philippebox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    /** The media player used to play philippe sounds. */
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Launch philippe sound.
     *
     * @param view the view
     */
    public void onBtnPhilippeClick(View view) {
        playSound(R.raw.phillipe);
    }

    /**
     * Launch philippe en rogne sound.
     *
     * @param view the view
     */
    public void onBtnRogneClick(View view) {
        playSound(R.raw.philippe_rogne);
    }

    /**
     * Launch mon vieux philippe sound.
     *
     * @param view the view
     */
    public void onBtnVieuxClick(View view) {
        playSound(R.raw.philippe_vieux);
    }

    /**
     * Launch fais pas ca philippe sound.
     *
     * @param view the view
     */
    public void onBtnFaisPasCaClick(View view) {
        playSound(R.raw.philippe_fais_pas_ca);
    }

    /**
     * Plays the selected sound.
     * @param soundId the sound resource id.
     */
    private void playSound(int soundId) {
        if (null == mediaPlayer) {
            mediaPlayer = MediaPlayer.create(this, soundId);
        } else {
            mediaPlayer.stop();
            releaseMediaPlayer();
            playSound(soundId);
        }
        mediaPlayer.start();
    }

    /**
     * Properly release the media player.
     */
    private void releaseMediaPlayer() {
        if (null != mediaPlayer) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
