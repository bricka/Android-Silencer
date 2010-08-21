package com.cabhan.silencer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * An Activity that allows the phone's volume to be toggled between silenced and vibrate.
 * @author Alex Brick
 *
 */
public class Silencer extends Activity
{
	private TextView tv;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int ringerMode = audioManager.getRingerMode();
        
        tv = (TextView) findViewById(R.id.TextView);

        String text = null;

        switch(ringerMode)
        {
            case AudioManager.RINGER_MODE_NORMAL:
                text = getString(R.id.NORMAL_RINGER);
                break;
            case AudioManager.RINGER_MODE_SILENT:
                text = getString(R.id.SILENT_RINGER);
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                text = getString(R.id.VIBRATE_RINGER);
                break;
        }

        tv.setText(text);
        
        Button button = (Button) findViewById(R.id.Button);
        
        button.setOnClickListener(new View.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		switch(ringerMode)
        		{
        			case AudioManager.RINGER_MODE_NORMAL:
        			case AudioManager.RINGER_MODE_SILENT:
        				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        tv.setText(getString(R.id.VIBRATE_RINGER));
        				break;
        			case AudioManager.RINGER_MODE_VIBRATE:
        				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        tv.setText(getString(R.id.SILENT_RINGER));
        				break;
        		}
        	}
        });
    }
}
