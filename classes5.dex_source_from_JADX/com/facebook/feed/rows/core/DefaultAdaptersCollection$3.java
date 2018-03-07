package com.facebook.feed.rows.core;

import com.google.common.collect.AbstractIterator;

/* compiled from: Window callback may not be null */
public class DefaultAdaptersCollection$3 extends AbstractIterator<FeedUnitAdapter> {
    final /* synthetic */ DefaultAdaptersCollection f12245a;
    private int f12246b;
    private FeedUnitAdapter f12247c;

    public DefaultAdaptersCollection$3(DefaultAdaptersCollection defaultAdaptersCollection) {
        this.f12245a = defaultAdaptersCollection;
    }

    protected final Object m20270a() {
        while (this.f12246b < this.f12245a.j.size() && ((BoundedAdapter) this.f12245a.j.get(this.f12246b)).a == this.f12247c) {
            this.f12246b++;
        }
        if (this.f12246b == this.f12245a.j.size()) {
            return (FeedUnitAdapter) b();
        }
        this.f12247c = ((BoundedAdapter) this.f12245a.j.get(this.f12246b)).a;
        return this.f12247c;
    }
}
