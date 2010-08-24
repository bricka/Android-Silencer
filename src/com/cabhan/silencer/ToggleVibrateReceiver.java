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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class ToggleVibrateReceiver extends BroadcastReceiver
{
	private static final String TAG = "ToggleVibrateReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.v(TAG, "In onReceive");
		final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        
		switch(audioManager.getRingerMode())
		{
			case AudioManager.RINGER_MODE_NORMAL:
			case AudioManager.RINGER_MODE_SILENT:
				Log.v(TAG, "Switching to vibrate");
				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				Log.v(TAG, "Switching to silent");
				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				break;
		}
		
		Log.v(TAG, "Done with onReceive");
	}

}
