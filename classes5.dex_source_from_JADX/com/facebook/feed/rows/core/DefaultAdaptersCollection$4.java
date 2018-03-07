package com.facebook.feed.rows.core;

import java.util.Iterator;

/* compiled from: Window callback may not be null */
public class DefaultAdaptersCollection$4 implements Iterable<FeedUnitAdapter> {
    final /* synthetic */ DefaultAdaptersCollection f12248a;

    public DefaultAdaptersCollection$4(DefaultAdaptersCollection defaultAdaptersCollection) {
        this.f12248a = defaultAdaptersCollection;
    }

    public Iterator<FeedUnitAdapter> iterator() {
        return new DefaultAdaptersCollection$3(this.f12248a);
    }
}
