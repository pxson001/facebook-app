package com.facebook.nearby.model;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: unread notification count */
public class TilesCacheRecord {
    public final MapTile f392a;
    public final long f393b;
    public final ImmutableSet<String> f394c;
    public final ImmutableSet<Long> f395d;

    public TilesCacheRecord(MapTile mapTile, long j, Set<String> set, Set<Long> set2) {
        this.f392a = mapTile;
        this.f393b = j;
        this.f394c = ImmutableSet.copyOf(set);
        this.f395d = ImmutableSet.copyOf(set2);
    }

    public final MapTile m514a() {
        return this.f392a;
    }
}
