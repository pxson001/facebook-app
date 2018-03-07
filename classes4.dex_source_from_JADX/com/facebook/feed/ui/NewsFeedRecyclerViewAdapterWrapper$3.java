package com.facebook.feed.ui;

import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;

/* compiled from: primaryAction */
class NewsFeedRecyclerViewAdapterWrapper$3 implements Marker {
    final /* synthetic */ Marker f4238a;
    final /* synthetic */ NewsFeedRecyclerViewAdapterWrapper f4239b;

    NewsFeedRecyclerViewAdapterWrapper$3(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper, Marker marker) {
        this.f4239b = newsFeedRecyclerViewAdapterWrapper;
        this.f4238a = marker;
    }

    public final int m4768a() {
        return this.f4239b.b() + this.f4238a.a();
    }
}
