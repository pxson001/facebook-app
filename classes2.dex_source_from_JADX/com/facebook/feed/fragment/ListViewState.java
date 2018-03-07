package com.facebook.feed.fragment;

import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;

/* compiled from: last_ping_sent_time_offset */
public class ListViewState {
    public static final ListViewState f17921a = new ListViewState(new C07271(), -1);
    private final Marker f17922b;
    private final int f17923c;

    /* compiled from: last_ping_sent_time_offset */
    final class C07271 implements Marker {
        C07271() {
        }

        public final int mo2993a() {
            return -1;
        }
    }

    public ListViewState(Marker marker, int i) {
        this.f17922b = marker;
        this.f17923c = i;
    }

    public final Marker m25155a() {
        return this.f17922b;
    }

    public final int m25156b() {
        return this.f17923c;
    }
}
