package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: page/%s/call_to_action */
public class PooledByteStreams {
    private final int f10598a;
    private final GenericByteArrayPool f10599b;

    public PooledByteStreams(GenericByteArrayPool genericByteArrayPool) {
        this(genericByteArrayPool, 16384);
    }

    @VisibleForTesting
    private PooledByteStreams(GenericByteArrayPool genericByteArrayPool, int i) {
        Preconditions.a(i > 0);
        this.f10598a = i;
        this.f10599b = genericByteArrayPool;
    }

    public final long m15787a(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        Object obj = (byte[]) this.f10599b.mo2018a(this.f10598a);
        while (true) {
            try {
                int read = inputStream.read(obj, 0, this.f10598a);
                if (read == -1) {
                    break;
                }
                outputStream.write(obj, 0, read);
                j += (long) read;
            } finally {
                j = this.f10599b;
                j.mo2019a(obj);
            }
        }
        return j;
    }
}
