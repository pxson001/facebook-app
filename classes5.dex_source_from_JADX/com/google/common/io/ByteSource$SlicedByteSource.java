package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: bug_report_begin_flow */
final class ByteSource$SlicedByteSource extends ByteSource {
    final long f7646a;
    final long f7647b;
    final /* synthetic */ ByteSource f7648c;

    ByteSource$SlicedByteSource(ByteSource byteSource, long j, long j2) {
        boolean z;
        this.f7648c = byteSource;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "offset (%s) may not be negative", new Object[]{Long.valueOf(j)});
        if (j2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "length (%s) may not be negative", new Object[]{Long.valueOf(j2)});
        this.f7646a = j;
        this.f7647b = j2;
    }

    public final InputStream m13815a() {
        return m13813a(this.f7648c.a());
    }

    private InputStream m13813a(InputStream inputStream) {
        Closer a;
        if (this.f7646a > 0) {
            try {
                if (ByteStreams.c(inputStream, this.f7646a) < this.f7646a) {
                    inputStream.close();
                    return new ByteArrayInputStream(new byte[0]);
                }
            } catch (Throwable th) {
                a.close();
            }
        }
        return ByteStreams.a(inputStream, this.f7647b);
    }

    public final ByteSource m13814a(long j, long j2) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "offset (%s) may not be negative", new Object[]{Long.valueOf(j)});
        if (j2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "length (%s) may not be negative", new Object[]{Long.valueOf(j2)});
        return this.f7648c.a(this.f7646a + j, Math.min(j2, this.f7647b - j));
    }

    public final String toString() {
        return this.f7648c.toString() + ".slice(" + this.f7646a + ", " + this.f7647b + ")";
    }
}
