package com.facebook.messaging.montage.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: is_host */
public class MontagePlayQueue {
    public final ImmutableList<MontageMessageInfo> f12557a;
    public final long[] f12558b;
    public final long f12559c;

    public MontagePlayQueue(ImmutableList<MontageMessageInfo> immutableList) {
        Preconditions.checkNotNull(immutableList);
        this.f12557a = immutableList;
        long j = 0;
        this.f12558b = new long[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            this.f12558b[i] = j;
            j += ((MontageMessageInfo) immutableList.get(i)).f12556c;
        }
        this.f12559c = j;
    }
}
