package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool.InvalidSizeException;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: page/%s/child_locations */
public class NativeMemoryChunkPool extends BasePool<NativeMemoryChunk> {
    public final int[] f10597g;

    protected final void mo2014b(Object obj) {
        NativeMemoryChunk nativeMemoryChunk = (NativeMemoryChunk) obj;
        Preconditions.a(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    protected final int mo2016c(Object obj) {
        NativeMemoryChunk nativeMemoryChunk = (NativeMemoryChunk) obj;
        Preconditions.a(nativeMemoryChunk);
        return nativeMemoryChunk.f15714b;
    }

    protected final boolean mo2021d(Object obj) {
        NativeMemoryChunk nativeMemoryChunk = (NativeMemoryChunk) obj;
        Preconditions.a(nativeMemoryChunk);
        return !nativeMemoryChunk.m22397a();
    }

    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.f10499c;
        this.f10597g = new int[sparseIntArray.size()];
        for (int i = 0; i < this.f10597g.length; i++) {
            this.f10597g[i] = sparseIntArray.keyAt(i);
        }
        m15737a();
    }

    protected final Object mo2013b(int i) {
        return new NativeMemoryChunk(i);
    }

    protected final int mo2017d(int i) {
        return i;
    }

    protected final int mo2015c(int i) {
        if (i <= 0) {
            throw new InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f10597g) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }
}
