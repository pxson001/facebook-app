package com.facebook.audiofingerprinting;

import com.facebook.inject.InjectorLike;
import com.facebook.soloader.NativeLibrary;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: updatedPrefetchData */
public class AudioReceiver extends NativeLibrary {
    private int f1071a;

    private native int getBlockCount(int i);

    private native int getBlockSize(int i);

    private native double getBufferLevel(int i);

    private native double getFormat(int i);

    private native byte[] getSample(int i);

    private static native int nullHandler();

    private native int processSamples(int i, byte[] bArr, int i2);

    private native void releaseBuffer(int i);

    @VisibleForTesting
    protected native int createBuffer(int i, double d);

    private static AudioReceiver m1026k() {
        return new AudioReceiver();
    }

    @Inject
    public AudioReceiver() {
        super(ImmutableList.of("gnustl_shared", "ridgebase"));
    }

    public static AudioReceiver m1025a(InjectorLike injectorLike) {
        return m1026k();
    }

    protected final void m1028c() {
        this.f1071a = nullHandler();
    }

    public final boolean m1029d() {
        return ah_();
    }

    public final synchronized boolean m1030e() {
        b();
        this.f1071a = createBuffer(2, 16.0d);
        return this.f1071a != nullHandler();
    }

    public final synchronized boolean m1031f() {
        boolean z;
        b();
        if (this.f1071a == nullHandler()) {
            z = false;
        } else {
            releaseBuffer(this.f1071a);
            this.f1071a = nullHandler();
            z = true;
        }
        return z;
    }

    public final synchronized int m1027a(byte[] bArr, int i) {
        b();
        if (this.f1071a == nullHandler()) {
            throw new IllegalStateException("start() should be called before calling addSamples()");
        }
        return processSamples(this.f1071a, bArr, i);
    }

    public final synchronized byte[] m1032g() {
        b();
        if (this.f1071a == nullHandler()) {
            throw new IllegalStateException("start() should be called before calling getFingerprintBuffer()");
        }
        return getSample(this.f1071a);
    }

    public final synchronized double m1033h() {
        b();
        if (this.f1071a == nullHandler()) {
            throw new IllegalStateException("start() should be called before calling getAudioLevel()");
        }
        return getBufferLevel(this.f1071a);
    }

    public final synchronized int m1034i() {
        b();
        if (this.f1071a == nullHandler()) {
            throw new IllegalStateException("start should be called before calling getBytesPerFrame()");
        }
        return getBlockSize(this.f1071a);
    }

    public final synchronized double m1035j() {
        b();
        if (this.f1071a == nullHandler()) {
            throw new IllegalStateException("start should be called before calling getVersion()");
        }
        return getFormat(this.f1071a);
    }
}
