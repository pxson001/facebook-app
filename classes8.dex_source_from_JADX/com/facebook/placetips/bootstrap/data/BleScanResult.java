package com.facebook.placetips.bootstrap.data;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: search_impression_source */
public class BleScanResult {
    public final ImmutableList<BleBroadcastSummary> f3831a;
    public final long f3832b;
    public final long f3833c;
    public final long f3834d;
    public final int f3835e;

    public BleScanResult(List<BleBroadcastSummary> list, long j, long j2, long j3, int i) {
        this.f3831a = ImmutableList.copyOf(list);
        this.f3832b = j;
        this.f3833c = j2;
        this.f3834d = j3;
        this.f3835e = i;
    }
}
