package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: TOURIST_ATTRACTION */
public class SharedByteArray implements MemoryTrimmable {
    @VisibleForTesting
    final int f13724a;
    @VisibleForTesting
    final int f13725b;
    @VisibleForTesting
    final OOMSoftReference<byte[]> f13726c;
    @VisibleForTesting
    final Semaphore f13727d;
    private final ResourceReleaser<byte[]> f13728e;

    /* compiled from: TOURIST_ATTRACTION */
    class C13031 implements ResourceReleaser<byte[]> {
        final /* synthetic */ SharedByteArray f13723a;

        C13031(SharedByteArray sharedByteArray) {
            this.f13723a = sharedByteArray;
        }

        public final void m23065a(Object obj) {
            this.f13723a.f13727d.release();
        }
    }

    public SharedByteArray(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        boolean z = false;
        Preconditions.a(memoryTrimmableRegistry);
        Preconditions.a(poolParams.d > 0);
        if (poolParams.e >= poolParams.d) {
            z = true;
        }
        Preconditions.a(z);
        this.f13725b = poolParams.e;
        this.f13724a = poolParams.d;
        this.f13726c = new OOMSoftReference();
        this.f13727d = new Semaphore(1);
        this.f13728e = new C13031(this);
        memoryTrimmableRegistry.a(this);
    }

    public final void m23066a(MemoryTrimType memoryTrimType) {
        if (this.f13727d.tryAcquire()) {
            try {
                this.f13726c.m19099b();
            } finally {
                this.f13727d.release();
            }
        }
    }
}
