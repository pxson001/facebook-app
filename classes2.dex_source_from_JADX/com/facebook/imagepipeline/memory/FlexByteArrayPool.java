package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: page/%s/service/%s */
public class FlexByteArrayPool {
    @VisibleForTesting
    public final SoftRefByteArrayPool f10569a;
    private final ResourceReleaser<byte[]> f10570b;

    @VisibleForTesting
    /* compiled from: page/%s/service/%s */
    class SoftRefByteArrayPool extends GenericByteArrayPool {
        public SoftRefByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        final Bucket<byte[]> mo2012e(int i) {
            return new OOMSoftReferenceBucket(mo2017d(i), this.f10573b.f10502f, 0);
        }
    }

    /* compiled from: page/%s/service/%s */
    class C04451 implements ResourceReleaser<byte[]> {
        final /* synthetic */ FlexByteArrayPool f10588a;

        C04451(FlexByteArrayPool flexByteArrayPool) {
            this.f10588a = flexByteArrayPool;
        }

        public final void mo2019a(Object obj) {
            this.f10588a.f10569a.mo2019a((byte[]) obj);
        }
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        Preconditions.a(poolParams.f10502f > 0);
        this.f10569a = new SoftRefByteArrayPool(memoryTrimmableRegistry, poolParams, NoOpPoolStatsTracker.m15750a());
        this.f10570b = new C04451(this);
    }

    public final CloseableReference<byte[]> m15720a(int i) {
        return CloseableReference.m15676a(this.f10569a.mo2018a(i), this.f10570b);
    }
}
