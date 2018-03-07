package com.facebook.feedplugins.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: force_mode/ */
class PlayFullscreenVideoPartDefinition$1 implements OnClickListener {
    final /* synthetic */ FullscreenVideoLauncher f13071a;
    final /* synthetic */ PlayFullscreenVideoPartDefinition f13072b;

    PlayFullscreenVideoPartDefinition$1(PlayFullscreenVideoPartDefinition playFullscreenVideoPartDefinition, FullscreenVideoLauncher fullscreenVideoLauncher) {
        this.f13072b = playFullscreenVideoPartDefinition;
        this.f13071a = fullscreenVideoLauncher;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -800414078);
        this.f13071a.m14736a(view);
        Logger.a(2, EntryType.UI_INPUT_END, -1483941827, a);
    }
}
