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

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class SilencerWidgetProvider extends AppWidgetProvider
{
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIDs)
	{
		RemoteViews views;
		
		for(int appWidgetID : appWidgetIDs)
		{
			views = new RemoteViews(context.getPackageName(), R.layout.silencer_appwidget);
			
			Intent intent = new Intent(context, ToggleVibrateReceiver.class);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
			views.setOnClickPendingIntent(R.id.WidgetButton, pendingIntent);
			
			appWidgetManager.updateAppWidget(appWidgetID, views);
		}
	}
}
