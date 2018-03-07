package com.facebook.widget.loadingindicator;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;

/* compiled from: recent_story */
class LoadingIndicatorView$2 implements OnClickListener {
    final /* synthetic */ RetryClickedListener f6116a;
    final /* synthetic */ LoadingIndicatorView f6117b;

    LoadingIndicatorView$2(LoadingIndicatorView loadingIndicatorView, RetryClickedListener retryClickedListener) {
        this.f6117b = loadingIndicatorView;
        this.f6116a = retryClickedListener;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 310057036);
        this.f6117b.a();
        this.f6116a.a();
        Logger.a(2, EntryType.UI_INPUT_END, -168832988, a);
    }
}
