package com.facebook.widget.listview;

/* compiled from: referrer_id */
class ListViewProxy$1 implements Runnable {
    final /* synthetic */ int f6044a;
    final /* synthetic */ int f6045b;
    final /* synthetic */ ListViewProxy f6046c;

    ListViewProxy$1(ListViewProxy listViewProxy, int i, int i2) {
        this.f6046c = listViewProxy;
        this.f6044a = i;
        this.f6045b = i2;
    }

    public void run() {
        this.f6046c.a.smoothScrollBy(this.f6044a, this.f6045b);
    }
}
