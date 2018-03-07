package com.facebook.video.server;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Closeables;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: pack_ids */
public final class TeedOutputStream extends OutputStream {
    private final ImmutableList<OutputStream> f5560a;
    @GuardedBy("this")
    private boolean f5561b;

    public TeedOutputStream(OutputStream... outputStreamArr) {
        this.f5560a = ImmutableList.copyOf(outputStreamArr);
    }

    public final void close() {
        try {
            super.close();
        } finally {
            m5986b();
        }
    }

    public final void write(int i) {
        m5984a(i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        m5985a(bArr, i, i2);
    }

    private synchronized void m5983a() {
        this.f5561b = true;
    }

    private void m5986b() {
        int size = this.f5560a.size();
        for (int i = 0; i < size; i++) {
            Closeables.a((OutputStream) this.f5560a.get(i), false);
        }
        m5983a();
    }

    private void m5984a(int i) {
        int size = this.f5560a.size();
        int i2 = 0;
        while (i2 < size) {
            try {
                ((OutputStream) this.f5560a.get(i2)).write(i);
                i2++;
            } catch (IOException e) {
                m5986b();
                throw e;
            }
        }
    }

    private void m5985a(byte[] bArr, int i, int i2) {
        int size = this.f5560a.size();
        int i3 = 0;
        while (i3 < size) {
            try {
                ((OutputStream) this.f5560a.get(i3)).write(bArr, i, i2);
                i3++;
            } catch (IOException e) {
                m5986b();
                throw e;
            }
        }
    }
}
