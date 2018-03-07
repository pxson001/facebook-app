package com.facebook.feed.nux;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.NuxBubbleManager.Nux;

/* compiled from: slow_connection */
class FeedNuxBubbleManager$3 implements OnClickListener {
    final /* synthetic */ Nux f3660a;
    final /* synthetic */ FeedNuxBubbleManager f3661b;

    FeedNuxBubbleManager$3(FeedNuxBubbleManager feedNuxBubbleManager, Nux nux) {
        this.f3661b = feedNuxBubbleManager;
        this.f3660a = nux;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 663783975);
        FeedNuxBubbleManager.c(this.f3661b, true);
        this.f3660a.d.b();
        Logger.a(2, EntryType.UI_INPUT_END, 560612850, a);
    }
}
