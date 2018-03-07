package com.facebook.feedplugins.placetips;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: friending/ */
class PlaceTipsFeedAdapter$8 implements OnClickListener {
    final /* synthetic */ PlaceTipsFeedAdapter f12911a;

    PlaceTipsFeedAdapter$8(PlaceTipsFeedAdapter placeTipsFeedAdapter) {
        this.f12911a = placeTipsFeedAdapter;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 988129441);
        this.f12911a.a(view);
        Logger.a(2, EntryType.UI_INPUT_END, -106932355, a);
    }
}
