package com.facebook.widget.listview;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: event_invitee_limit */
class BetterListView$1 implements OnScrollListener {
    final /* synthetic */ BetterListView f12731a;

    BetterListView$1(BetterListView betterListView) {
        this.f12731a = betterListView;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        BetterListView.b(this.f12731a, i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        BetterListView.a(this.f12731a, absListView, i, i2, i3);
    }
}
