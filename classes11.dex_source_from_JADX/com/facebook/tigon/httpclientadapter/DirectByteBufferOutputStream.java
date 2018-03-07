package com.facebook.tigon.httpclientadapter;

import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: num_invites_sent */
public class DirectByteBufferOutputStream extends OutputStream {
    final boolean f4904a = false;
    private final ArrayList<ByteBuffer> f4905b = new ArrayList();

    public DirectByteBufferOutputStream() {
        this.f4905b.add(ByteBuffer.allocateDirect(1024));
    }

    public DirectByteBufferOutputStream(int i) {
        this.f4905b.add(ByteBuffer.allocateDirect(i));
    }

    public void write(int i) {
        ByteBuffer c = m6199c();
        if (c.remaining() == 0) {
            c = m6200d();
        }
        c.put((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            ByteBuffer c = m6199c();
            if (c.remaining() == 0) {
                c = m6200d();
            }
            int min = Math.min(c.remaining(), i2);
            c.put(bArr, i, min);
            i += min;
            i2 -= min;
        }
    }

    public final ByteBuffer[] m6201a() {
        boolean z = true;
        if (this.f4904a) {
            boolean z2;
            if (this.f4905b.size() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            if (((ByteBuffer) this.f4905b.get(0)).remaining() != 0) {
                z = false;
            }
            Preconditions.checkState(z);
        }
        return (ByteBuffer[]) this.f4905b.toArray(new ByteBuffer[this.f4905b.size()]);
    }

    public final int m6202b() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4905b.size(); i2++) {
            i += ((ByteBuffer) this.f4905b.get(i2)).position();
        }
        return i;
    }

    private ByteBuffer m6199c() {
        return (ByteBuffer) this.f4905b.get(this.f4905b.size() - 1);
    }

    private ByteBuffer m6200d() {
        boolean z;
        boolean z2 = true;
        if (this.f4904a) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        if (m6199c().remaining() != 0) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
        this.f4905b.add(allocateDirect);
        return allocateDirect;
    }
}
