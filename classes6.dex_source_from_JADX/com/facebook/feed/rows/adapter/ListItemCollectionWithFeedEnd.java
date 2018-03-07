package com.facebook.feed.rows.adapter;

import com.facebook.api.feed.data.EndOfFeedSentinel;
import com.facebook.api.feed.data.LoadingMoreSentinel;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.graphql.model.FeedEdge;

/* compiled from: messages/chat_heads/ipc */
public class ListItemCollectionWithFeedEnd implements ListItemCollection<Object> {
    private static final LoadingMoreSentinel f10379a = new LoadingMoreSentinel();
    private static final EndOfFeedSentinel f10380b = new EndOfFeedSentinel();
    private final ListItemCollection<FeedEdge> f10381c;
    private final ListItemCollectionEndProvider f10382d;
    private final boolean f10383e;

    public ListItemCollectionWithFeedEnd(ListItemCollection<FeedEdge> listItemCollection, ListItemCollectionEndProvider listItemCollectionEndProvider, boolean z) {
        this.f10381c = listItemCollection;
        this.f10382d = listItemCollectionEndProvider;
        this.f10383e = z;
    }

    public final int m16534a() {
        int a = this.f10381c.a();
        if (a > 0) {
            return a + 1;
        }
        if (this.f10383e && this.f10382d.m16564a()) {
            return 1;
        }
        return 0;
    }

    public final Object m16535a(int i) {
        if (i < this.f10381c.a()) {
            return this.f10381c.a(i);
        }
        return this.f10382d.m16564a() ? f10379a : f10380b;
    }
}
