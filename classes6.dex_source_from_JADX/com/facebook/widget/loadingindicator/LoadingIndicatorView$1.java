package com.facebook.widget.loadingindicator;

import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;

/* compiled from: recent_story */
class LoadingIndicatorView$1 implements Runnable {
    final /* synthetic */ RetryClickedListener f6113a;
    final /* synthetic */ Runnable f6114b;
    final /* synthetic */ LoadingIndicatorView f6115c;

    LoadingIndicatorView$1(LoadingIndicatorView loadingIndicatorView, RetryClickedListener retryClickedListener, Runnable runnable) {
        this.f6115c = loadingIndicatorView;
        this.f6113a = retryClickedListener;
        this.f6114b = runnable;
    }

    public void run() {
        LoadingIndicatorView.a(this.f6115c, this.f6113a);
        if (this.f6114b != null) {
            this.f6115c.post(this.f6114b);
        }
    }
}
