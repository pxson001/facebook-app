package com.facebook.widget.listview;

import com.facebook.widget.listview.BetterListView.OnTouchDownListener;

/* compiled from: referrer_id */
class ListViewProxy$5 implements OnTouchDownListener {
    final /* synthetic */ ScrollingViewProxy.OnTouchDownListener f6051a;
    final /* synthetic */ ListViewProxy f6052b;

    ListViewProxy$5(ListViewProxy listViewProxy, ScrollingViewProxy.OnTouchDownListener onTouchDownListener) {
        this.f6052b = listViewProxy;
        this.f6051a = onTouchDownListener;
    }

    public final void m8617a() {
        this.f6051a.a(this.f6052b);
    }
}
