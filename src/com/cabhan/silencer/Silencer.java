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
        
        Button button = (Button) findViewById(R.id.Button);
        
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        
        button.setOnClickListener(new View.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		switch(audioManager.getRingerMode())
        		{
        			case AudioManager.RINGER_MODE_NORMAL:
        			case AudioManager.RINGER_MODE_SILENT:
        				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        				break;
        			case AudioManager.RINGER_MODE_VIBRATE:
        				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        				break;
        		}
        	}
        });
    }
}