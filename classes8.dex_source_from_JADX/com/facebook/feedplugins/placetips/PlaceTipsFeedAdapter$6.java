package com.facebook.feedplugins.placetips;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: friending/ */
class PlaceTipsFeedAdapter$6 implements OnClickListener {
    final /* synthetic */ PlaceTipsFeedAdapter f12908a;

    PlaceTipsFeedAdapter$6(PlaceTipsFeedAdapter placeTipsFeedAdapter) {
        this.f12908a = placeTipsFeedAdapter;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -107902928);
        this.f12908a.a(view);
        Logger.a(2, EntryType.UI_INPUT_END, 1730168975, a);
    }
}
