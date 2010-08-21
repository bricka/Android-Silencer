/*
Android Silencer - Easily toggle vibrate and silence
Copyright (C) 2010  Alex Brick

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

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

        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        
        tv = (TextView) findViewById(R.id.TextView);
        
        Button button = (Button) findViewById(R.id.Button);
        
        button.setOnClickListener(new View.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		int newRingerMode = -1;
        		
        		switch(audioManager.getRingerMode())
        		{
        			case AudioManager.RINGER_MODE_NORMAL:
        			case AudioManager.RINGER_MODE_SILENT:
        				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        				newRingerMode = AudioManager.RINGER_MODE_VIBRATE;
        				break;
        			case AudioManager.RINGER_MODE_VIBRATE:
        				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        				newRingerMode = AudioManager.RINGER_MODE_SILENT;
        				break;
        		}
        		
        		setRingerModeText(newRingerMode);
        	}
        });
    }
    
    /**
     * Called every time the activity is opened by the user.
     */
    @Override
    public void onStart()
    {
    	super.onStart();
    	
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        
        setRingerModeText(audioManager.getRingerMode());
    }
    
    /**
     * Updates the displayed text view with the given status of the ringer.
     * 
     * @param ringerMode the new status of the ringer
     */
    private void setRingerModeText(final int ringerMode)
    {
    	String text = null;
    	
    	switch(ringerMode)
        {
            case AudioManager.RINGER_MODE_NORMAL:
                text = getString(R.string.ringer_normal);
                break;
            case AudioManager.RINGER_MODE_SILENT:
                text = getString(R.string.ringer_silent);
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                text = getString(R.string.ringer_vibrate);
                break;
            default:
            	text = "Unknown";
            	break;
        }
    	
    	tv.setText("Current Ringer Status: " + text);
    }
}
