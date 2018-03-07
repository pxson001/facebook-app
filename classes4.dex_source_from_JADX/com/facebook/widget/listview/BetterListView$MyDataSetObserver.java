package com.facebook.widget.listview;

import android.database.DataSetObserver;

/* compiled from: event_invitee_limit */
class BetterListView$MyDataSetObserver extends DataSetObserver {
    final /* synthetic */ BetterListView f12734a;

    public BetterListView$MyDataSetObserver(BetterListView betterListView) {
        this.f12734a = betterListView;
    }

    public void onChanged() {
        this.f12734a.v = false;
    }

    public void onInvalidated() {
        this.f12734a.v = false;
    }
}
