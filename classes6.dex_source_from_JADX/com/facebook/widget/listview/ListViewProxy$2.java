package com.facebook.widget.listview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: referrer_id */
class ListViewProxy$2 implements OnItemClickListener {
    final /* synthetic */ ScrollingViewProxy$OnItemClickListener f6047a;
    final /* synthetic */ ListViewProxy f6048b;

    ListViewProxy$2(ListViewProxy listViewProxy, ScrollingViewProxy$OnItemClickListener scrollingViewProxy$OnItemClickListener) {
        this.f6048b = listViewProxy;
        this.f6047a = scrollingViewProxy$OnItemClickListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6047a.m8636a(i);
    }
}
