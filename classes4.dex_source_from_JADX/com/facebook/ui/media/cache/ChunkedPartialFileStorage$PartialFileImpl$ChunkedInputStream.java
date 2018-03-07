package com.facebook.ui.media.cache;

import com.facebook.ui.media.cache.ChunkedPartialFileStorage.PartialFileImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

/* compiled from: pack_lists */
class ChunkedPartialFileStorage$PartialFileImpl$ChunkedInputStream extends InputStream {
    final /* synthetic */ PartialFileImpl f5852a;
    private long f5853b;
    private InputStream f5854c;

    public ChunkedPartialFileStorage$PartialFileImpl$ChunkedInputStream(PartialFileImpl partialFileImpl, long j) {
        this.f5852a = partialFileImpl;
        this.f5853b = j;
        m6344a();
    }

    private boolean m6344a() {
        Entry entry = null;
        for (Entry entry2 : PartialFileImpl.n(this.f5852a).entrySet()) {
            Entry entry22;
            if (!((Range) entry22.getKey()).a(this.f5853b)) {
                entry22 = entry;
            }
            entry = entry22;
        }
        if (entry == null) {
            return false;
        }
        if (this.f5854c != null) {
            this.f5854c.close();
        }
        try {
            this.f5854c = new FileInputStream((File) entry.getValue());
            this.f5854c.skip(this.f5853b - ((Range) entry.getKey()).a);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void close() {
        if (this.f5854c != null) {
            this.f5854c.close();
            this.f5854c = null;
        }
    }

    public int read() {
        return read(new byte[1], 0, 1);
    }

    private int m6343a(byte[] bArr, int i, int i2) {
        if (this.f5854c == null) {
            return -1;
        }
        return this.f5854c.read(bArr, i, i2);
    }

    public int read(byte[] bArr, int i, int i2) {
        int a = m6343a(bArr, i, i2);
        if (a < 0 && m6344a()) {
            a = m6343a(bArr, i, i2);
        }
        if (a > 0) {
            this.f5853b += (long) a;
        }
        return a;
    }
}
