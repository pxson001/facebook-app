package com.facebook.appdiscovery.lite.model;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.graphql.model.FeedUnit;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: is_on */
public class AppDiscoveryResultsCollection implements ListItemCollection<FeedUnit> {
    public final List<FeedUnit> f10573a = Lists.a();

    public final Object m12466a(int i) {
        return (FeedUnit) this.f10573a.get(i);
    }

    public final int m12465a() {
        return this.f10573a.size();
    }
}
