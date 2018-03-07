package com.facebook.widget.listview;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: event_invitee_limit */
class BetterListView$3 implements OnPreDrawListener {
    final /* synthetic */ BetterListView f12733a;

    BetterListView$3(BetterListView betterListView) {
        this.f12733a = betterListView;
    }

    public boolean onPreDraw() {
        BetterListView.b(this.f12733a);
        return true;
    }
}
