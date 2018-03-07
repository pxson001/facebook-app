package com.facebook.composer.minutiae.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.facebook.composer.minutiae.widget.RidgeWidgetService.Commands;

/* compiled from: task_key_submit_answer */
public class RidgeWidgetProvider extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : appWidgetManager.getAppWidgetIds(new ComponentName(context, RidgeWidgetProvider.class))) {
            Intent intent = new Intent(context.getApplicationContext(), RidgeWidgetService.class);
            intent.putExtra("appWidgetId", i);
            intent.setAction(Commands.INITIALIZE.name());
            context.startService(intent);
            appWidgetManager.updateAppWidget(i, new RemoteViews(context.getPackageName(), 2130906901));
        }
    }
}
