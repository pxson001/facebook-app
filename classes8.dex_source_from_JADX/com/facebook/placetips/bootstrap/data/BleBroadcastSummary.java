package com.facebook.placetips.bootstrap.data;

import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: search_performed */
public class BleBroadcastSummary {
    public final BleBroadcast f3829a;
    public final List<Integer> f3830b = Lists.b();

    public BleBroadcastSummary(BleBroadcast bleBroadcast) {
        this.f3829a = bleBroadcast;
    }

    public final BleBroadcastSummary m3720a(int i) {
        this.f3830b.add(Integer.valueOf(i));
        return this;
    }

    public final int m3721b() {
        int i = 0;
        for (Integer intValue : this.f3830b) {
            i = intValue.intValue() + i;
        }
        return i / this.f3830b.size();
    }

    public final int m3722c() {
        return this.f3830b.size();
    }
}
