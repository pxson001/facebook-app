package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_admin_panel_context_item_tap */
public class PoolConfig {
    public final PoolParams f10503a;
    public final PoolStatsTracker f10504b;
    public final PoolParams f10505c;
    public final MemoryTrimmableRegistry f10506d;
    public final PoolParams f10507e;
    public final PoolStatsTracker f10508f;
    public final PoolParams f10509g;
    public final PoolStatsTracker f10510h;

    /* compiled from: page_admin_panel_context_item_tap */
    public class Builder {
        public PoolParams f10511a;
        public PoolStatsTracker f10512b;
        public PoolParams f10513c;
        public MemoryTrimmableRegistry f10514d;
        public PoolParams f10515e;
        public PoolStatsTracker f10516f;
        public PoolParams f10517g;
        public PoolStatsTracker f10518h;

        public final PoolConfig m15635a() {
            return new PoolConfig(this);
        }
    }

    public PoolConfig(Builder builder) {
        PoolParams poolParams;
        if (builder.f10511a == null) {
            int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
            if (min > 16777216) {
                min = (min / 4) * 3;
            } else {
                min /= 2;
            }
            poolParams = new PoolParams(0, min, DefaultBitmapPoolParams.f10519a);
        } else {
            poolParams = builder.f10511a;
        }
        this.f10503a = poolParams;
        this.f10504b = builder.f10512b == null ? NoOpPoolStatsTracker.m15750a() : builder.f10512b;
        this.f10505c = builder.f10513c == null ? DefaultFlexByteArrayPoolParams.m15634a() : builder.f10513c;
        this.f10506d = builder.f10514d == null ? NoOpMemoryTrimmableRegistry.m16319a() : builder.f10514d;
        this.f10507e = builder.f10515e == null ? DefaultNativeMemoryChunkPoolParams.m15636a() : builder.f10515e;
        this.f10508f = builder.f10516f == null ? NoOpPoolStatsTracker.m15750a() : builder.f10516f;
        if (builder.f10517g == null) {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sparseIntArray.put(16384, 5);
            poolParams = new PoolParams(81920, 1048576, sparseIntArray);
        } else {
            poolParams = builder.f10517g;
        }
        this.f10509g = poolParams;
        this.f10510h = builder.f10518h == null ? NoOpPoolStatsTracker.m15750a() : builder.f10518h;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
