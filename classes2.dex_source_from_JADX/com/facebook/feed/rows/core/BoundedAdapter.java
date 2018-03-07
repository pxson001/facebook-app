package com.facebook.feed.rows.core;

import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HasFeedEdge;
import javax.annotation.Nullable;

/* compiled from: minutiae_audio_fingerprinting */
public class BoundedAdapter<T> implements HasFeedEdge {
    public final FeedUnitAdapter<T, ?> f13446a;
    public final int f13447b;
    public final long f13448c;
    public final GraphQLFeedUnitEdge f13449d;
    @Nullable
    private final FeedUnit f13450e;
    private final boolean f13451f;

    public BoundedAdapter(FeedUnitAdapter<T, ?> feedUnitAdapter, int i, long j, @Nullable FeedEdge feedEdge, FeedUnit feedUnit, boolean z) {
        this.f13446a = feedUnitAdapter;
        this.f13447b = i;
        this.f13448c = j;
        this.f13449d = feedEdge;
        this.f13450e = feedUnit;
        this.f13451f = z;
    }

    public final FeedUnitAdapter<T, ?> m19811b() {
        return this.f13446a;
    }

    public final FeedUnit m19812c() {
        return this.f13450e;
    }

    public final RowKey m19813d() {
        return this.f13446a.m19045a(this.f13447b);
    }

    public int hashCode() {
        if (this.f13446a.f12957b == null) {
            return -1;
        }
        if (this.f13451f) {
            return (this.f13446a.f12957b.hashCode() * 31) + this.f13447b;
        }
        return this.f13446a.f12957b.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BoundedAdapter)) {
            return false;
        }
        boolean z;
        BoundedAdapter boundedAdapter = (BoundedAdapter) obj;
        if (boundedAdapter.f13446a.f12957b == this.f13446a.f12957b) {
            z = true;
        } else {
            z = false;
        }
        if (!this.f13451f) {
            return z;
        }
        if (z && boundedAdapter.f13447b == this.f13447b) {
            return true;
        }
        return false;
    }
}
