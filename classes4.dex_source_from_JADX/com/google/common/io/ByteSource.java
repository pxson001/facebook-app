package com.google.common.io;

import com.facebook.messaging.media.upload.util.MediaHashCache.2;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: foreground_location_location_success */
public abstract class ByteSource {
    public abstract InputStream mo846a();

    protected ByteSource() {
    }

    public ByteSource m11937a(long j, long j2) {
        return new SlicedByteSource(this, j, j2);
    }

    public final long m11936a(OutputStream outputStream) {
        Preconditions.checkNotNull(outputStream);
        Closer a = Closer.m11942a();
        try {
            long a2 = ByteStreams.m11949a((InputStream) a.m11943a(mo846a()), outputStream);
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }

    public final long m11935a(ByteSink byteSink) {
        Preconditions.checkNotNull(byteSink);
        Closer a = Closer.m11942a();
        try {
            long a2 = ByteStreams.m11949a((InputStream) a.m11943a(mo846a()), (OutputStream) a.m11943a(byteSink.mo896a()));
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }

    public byte[] mo847b() {
        Closer a = Closer.m11942a();
        try {
            byte[] a2 = ByteStreams.m11954a((InputStream) a.m11943a(mo846a()));
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }

    @Beta
    public final <T> T m11939a(ByteProcessor<T> byteProcessor) {
        Preconditions.checkNotNull(byteProcessor);
        Closer a = Closer.m11942a();
        try {
            T a2 = ByteStreams.m11952a((InputStream) a.m11943a(mo846a()), (2) byteProcessor);
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }

    public final boolean m11940a(ByteSource byteSource) {
        Preconditions.checkNotNull(byteSource);
        byte[] bArr = new byte[8192];
        byte[] bArr2 = new byte[8192];
        Closer a = Closer.m11942a();
        try {
            InputStream inputStream = (InputStream) a.m11943a(mo846a());
            InputStream inputStream2 = (InputStream) a.m11943a(byteSource.mo846a());
            int a2;
            do {
                a2 = ByteStreams.m11948a(inputStream, bArr, 0, 8192);
                if (!(a2 == ByteStreams.m11948a(inputStream2, bArr2, 0, 8192) && Arrays.equals(bArr, bArr2))) {
                    a.close();
                    return false;
                }
            } while (a2 == 8192);
            a.close();
            return true;
        } catch (Throwable th) {
            a.close();
        }
    }
}
