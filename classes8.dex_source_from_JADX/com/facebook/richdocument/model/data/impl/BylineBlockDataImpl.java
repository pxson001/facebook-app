package com.facebook.richdocument.model.data.impl;

import com.facebook.richdocument.model.data.AuthorBlockData;
import com.facebook.richdocument.model.data.BlockData;
import com.google.common.collect.ImmutableList;

/* compiled from: photo_taken */
public class BylineBlockDataImpl extends BaseBlockData implements BlockData {
    public final ImmutableList<AuthorBlockData> f5697a;
    private final long f5698b;

    public BylineBlockDataImpl(ImmutableList<AuthorBlockData> immutableList, long j) {
        super(14);
        this.f5697a = immutableList;
        this.f5698b = j;
    }

    public final long m5509b() {
        return this.f5698b;
    }
}
