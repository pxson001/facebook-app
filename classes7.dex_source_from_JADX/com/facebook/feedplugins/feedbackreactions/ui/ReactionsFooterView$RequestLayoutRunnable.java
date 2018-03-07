package com.facebook.feedplugins.feedbackreactions.ui;

/* compiled from: StructuredLocationQuery */
class ReactionsFooterView$RequestLayoutRunnable implements Runnable {
    final /* synthetic */ ReactionsFooterView f23120a;

    public ReactionsFooterView$RequestLayoutRunnable(ReactionsFooterView reactionsFooterView) {
        this.f23120a = reactionsFooterView;
    }

    public void run() {
        this.f23120a.k.requestLayout();
    }
}
