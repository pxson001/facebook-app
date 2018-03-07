package com.facebook.imagepipeline.internal;

import com.facebook.crypto.cipher.NativeGCMCipherException;
import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: TRADE_SCHOOL */
class ExperimentalCryptoDiskStorage$RunOnErrorInputStream extends FilterInputStream {
    private final Runnable f13709a;

    public ExperimentalCryptoDiskStorage$RunOnErrorInputStream(InputStream inputStream, Runnable runnable) {
        super(inputStream);
        this.f13709a = runnable;
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return super.read(bArr, i, i2);
        } catch (NativeGCMCipherException e) {
            this.f13709a.run();
            throw e;
        }
    }

    public long skip(long j) {
        try {
            return super.skip(j);
        } catch (NativeGCMCipherException e) {
            this.f13709a.run();
            throw e;
        }
    }

    public void close() {
        try {
            super.close();
        } catch (NativeGCMCipherException e) {
            this.f13709a.run();
            throw e;
        }
    }

    public int read() {
        try {
            return super.read();
        } catch (NativeGCMCipherException e) {
            this.f13709a.run();
            throw e;
        }
    }
}
