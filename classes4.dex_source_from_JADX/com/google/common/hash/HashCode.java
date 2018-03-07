package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
/* compiled from: sticky_guardrail_manager_serialize_error */
public abstract class HashCode {
    private static final char[] f1661a = "0123456789abcdef".toCharArray();

    /* compiled from: sticky_guardrail_manager_serialize_error */
    public final class BytesHashCode extends HashCode implements Serializable {
        public final byte[] bytes;

        BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        public final int mo127a() {
            return this.bytes.length * 8;
        }

        public final byte[] mo131d() {
            return (byte[]) this.bytes.clone();
        }

        public final int mo129b() {
            boolean z;
            if (this.bytes.length >= 4) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", new Object[]{Integer.valueOf(this.bytes.length)});
            return (((this.bytes[0] & 255) | ((this.bytes[1] & 255) << 8)) | ((this.bytes[2] & 255) << 16)) | ((this.bytes[3] & 255) << 24);
        }

        public final long mo130c() {
            Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", new Object[]{Integer.valueOf(this.bytes.length)});
            long j = (long) (this.bytes[0] & 255);
            for (int i = 1; i < Math.min(this.bytes.length, 8); i++) {
                j |= (((long) this.bytes[i]) & 255) << (i * 8);
            }
            return j;
        }

        final byte[] mo132e() {
            return this.bytes;
        }

        final boolean mo128a(HashCode hashCode) {
            if (this.bytes.length != hashCode.mo132e().length) {
                return false;
            }
            boolean z = true;
            for (int i = 0; i < this.bytes.length; i++) {
                int i2;
                if (this.bytes[i] == hashCode.mo132e()[i]) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                z &= i2;
            }
            return z;
        }
    }

    @CheckReturnValue
    public abstract int mo127a();

    abstract boolean mo128a(HashCode hashCode);

    @CheckReturnValue
    public abstract int mo129b();

    @CheckReturnValue
    public abstract long mo130c();

    @CheckReturnValue
    public abstract byte[] mo131d();

    HashCode() {
    }

    byte[] mo132e() {
        return mo131d();
    }

    static HashCode m1911a(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (mo127a() == hashCode.mo127a() && mo128a(hashCode)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (mo127a() >= 32) {
            return mo129b();
        }
        byte[] e = mo132e();
        int i = e[0] & 255;
        for (int i2 = 1; i2 < e.length; i2++) {
            i |= (e[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] e = mo132e();
        StringBuilder stringBuilder = new StringBuilder(e.length * 2);
        for (byte b : e) {
            stringBuilder.append(f1661a[(b >> 4) & 15]).append(f1661a[b & 15]);
        }
        return stringBuilder.toString();
    }
}
