package com.facebook.livephotos.exoplayer.extractor;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.SampleHolder;
import com.facebook.livephotos.exoplayer.extractor.RollingSampleBuffer.InfoQueue;
import com.facebook.livephotos.exoplayer.upstream.Allocation;
import com.facebook.livephotos.exoplayer.upstream.DefaultAllocator;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;

/* compiled from: page_share_error */
public class DefaultTrackOutput implements TrackOutput {
    public final RollingSampleBuffer f6968a;
    public final SampleHolder f6969b = new SampleHolder(0);
    public boolean f6970c = true;
    public long f6971d = Long.MIN_VALUE;
    private long f6972e = Long.MIN_VALUE;
    public volatile long f6973f = Long.MIN_VALUE;
    public volatile MediaFormat f6974g;

    public DefaultTrackOutput(DefaultAllocator defaultAllocator) {
        this.f6968a = new RollingSampleBuffer(defaultAllocator);
    }

    public final void m8854a() {
        RollingSampleBuffer rollingSampleBuffer = this.f6968a;
        InfoQueue infoQueue = rollingSampleBuffer.f7043c;
        infoQueue.f7036h = 0;
        infoQueue.f7037i = 0;
        infoQueue.f7038j = 0;
        infoQueue.f7035g = 0;
        while (!rollingSampleBuffer.f7044d.isEmpty()) {
            rollingSampleBuffer.f7041a.m9265a((Allocation) rollingSampleBuffer.f7044d.remove());
        }
        rollingSampleBuffer.f7047g = 0;
        rollingSampleBuffer.f7048h = 0;
        rollingSampleBuffer.f7049i = null;
        rollingSampleBuffer.f7050j = rollingSampleBuffer.f7042b;
        this.f6970c = true;
        this.f6971d = Long.MIN_VALUE;
        this.f6972e = Long.MIN_VALUE;
        this.f6973f = Long.MIN_VALUE;
    }

    public final boolean m8859e() {
        return !m8852f();
    }

    public final boolean m8858a(SampleHolder sampleHolder) {
        if (!m8852f()) {
            return false;
        }
        this.f6968a.m8915b(sampleHolder);
        this.f6970c = false;
        this.f6971d = sampleHolder.f6873e;
        return true;
    }

    private boolean m8852f() {
        boolean a = this.f6968a.m8913a(this.f6969b);
        if (this.f6970c) {
            while (a && !this.f6969b.m8752c()) {
                this.f6968a.m8914b();
                a = this.f6968a.m8913a(this.f6969b);
            }
        }
        if (!a) {
            return false;
        }
        if (this.f6972e == Long.MIN_VALUE || this.f6969b.f6873e < this.f6972e) {
            return true;
        }
        return false;
    }

    public final void mo410a(MediaFormat mediaFormat) {
        this.f6974g = mediaFormat;
    }

    public final int mo408a(DefaultExtractorInput defaultExtractorInput, int i, boolean z) {
        return this.f6968a.m8909a(defaultExtractorInput, i, z);
    }

    public final void mo411a(ParsableByteArray parsableByteArray, int i) {
        this.f6968a.m8911a(parsableByteArray, i);
    }

    public void mo409a(long j, int i, int i2, int i3, byte[] bArr) {
        this.f6973f = Math.max(this.f6973f, j);
        this.f6968a.m8910a(j, i, (this.f6968a.m8916c() - ((long) i2)) - ((long) i3), i2, bArr);
    }
}
