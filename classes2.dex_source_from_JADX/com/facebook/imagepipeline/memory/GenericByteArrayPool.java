package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool.InvalidSizeException;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: page/%s/scheduled_posts */
public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {
    private final int[] f10571g;

    protected final void mo2014b(Object obj) {
        Preconditions.a((byte[]) obj);
    }

    protected final int mo2016c(Object obj) {
        byte[] bArr = (byte[]) obj;
        Preconditions.a(bArr);
        return bArr.length;
    }

    public GenericByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.f10499c;
        this.f10571g = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.f10571g[i] = sparseIntArray.keyAt(i);
        }
        m15737a();
    }

    protected final Object mo2013b(int i) {
        return new byte[i];
    }

    protected final int mo2017d(int i) {
        return i;
    }

    protected final int mo2015c(int i) {
        if (i <= 0) {
            throw new InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f10571g) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }
}
