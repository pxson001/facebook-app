package com.facebook.fbui.tooltip;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: YOUR_POSTS_PAGE */
class Tooltip$4 implements OnClickListener {
    final /* synthetic */ Tooltip$OnTooltipClickListener f12209a;
    final /* synthetic */ Tooltip f12210b;

    Tooltip$4(Tooltip tooltip, Tooltip$OnTooltipClickListener tooltip$OnTooltipClickListener) {
        this.f12210b = tooltip;
        this.f12209a = tooltip$OnTooltipClickListener;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1864066203);
        if (this.f12209a != null) {
            this.f12210b.l();
            this.f12209a.m20227a();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 529860638, a);
    }
}
