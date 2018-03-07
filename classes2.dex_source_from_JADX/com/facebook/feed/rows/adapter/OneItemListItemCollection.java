package com.facebook.feed.rows.adapter;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.google.common.base.Preconditions;

/* compiled from: percent_time_dropped_frames_0 */
public class OneItemListItemCollection<T> implements ListItemCollection<T> {
    public T f10223a;

    public final int mo1374a() {
        return this.f10223a == null ? 0 : 1;
    }

    public final T mo1375a(int i) {
        Preconditions.checkState(this.f10223a != null);
        return this.f10223a;
    }
}
