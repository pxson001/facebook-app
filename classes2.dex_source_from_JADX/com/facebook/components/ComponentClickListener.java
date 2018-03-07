package com.facebook.components;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: geofenceRadiusMeters */
public class ComponentClickListener implements OnClickListener {
    public EventHandler f22645a;

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1909392302);
        if (this.f22645a != null) {
            EventHandler eventHandler = this.f22645a;
            Object clickEvent = new ClickEvent();
            clickEvent.a = view;
            eventHandler.f22607a.f22589c.mo3134a(eventHandler, clickEvent);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -501024700, a);
    }
}
