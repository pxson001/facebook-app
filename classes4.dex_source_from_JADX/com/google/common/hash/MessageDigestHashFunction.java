package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: story= */
final class MessageDigestHashFunction extends AbstractStreamingHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* compiled from: story= */
    final class MessageDigestHasher extends AbstractByteHasher {
        private final MessageDigest f1657a;
        private final int f1658b;
        private boolean f1659c;

        public MessageDigestHasher(MessageDigest messageDigest, int i) {
            this.f1657a = messageDigest;
            this.f1658b = i;
        }

        protected final void mo117a(byte b) {
            m1887b();
            this.f1657a.update(b);
        }

        protected final void mo118a(byte[] bArr) {
            m1887b();
            this.f1657a.update(bArr);
        }

        protected final void mo119a(byte[] bArr, int i, int i2) {
            m1887b();
            this.f1657a.update(bArr, i, i2);
        }

        private void m1887b() {
            Preconditions.checkState(!this.f1659c, "Cannot re-use a Hasher after calling hash() on it");
        }

        public final HashCode mo116a() {
            m1887b();
            this.f1659c = true;
            if (this.f1658b == this.f1657a.getDigestLength()) {
                return HashCode.m1911a(this.f1657a.digest());
            }
            return HashCode.m1911a(Arrays.copyOf(this.f1657a.digest(), this.f1658b));
        }
    }

    MessageDigestHashFunction(String str, String str2) {
        this.prototype = m1882a(str);
        this.bytes = this.prototype.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(str2);
        this.supportsClone = m1883b();
    }

    MessageDigestHashFunction(String str, int i, String str2) {
        boolean z;
        this.toString = (String) Preconditions.checkNotNull(str2);
        this.prototype = m1882a(str);
        int digestLength = this.prototype.getDigestLength();
        if (i < 4 || i > digestLength) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "bytes (%s) must be >= 4 and < %s", new Object[]{Integer.valueOf(i), Integer.valueOf(digestLength)});
        this.bytes = i;
        this.supportsClone = m1883b();
    }

    private boolean m1883b() {
        try {
            this.prototype.clone();
            return true;
        } catch (CloneNotSupportedException e) {
            return false;
        }
    }

    public final String toString() {
        return this.toString;
    }

    private static MessageDigest m1882a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final Hasher mo115a() {
        if (this.supportsClone) {
            try {
                return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException e) {
            }
        }
        return new MessageDigestHasher(m1882a(this.prototype.getAlgorithm()), this.bytes);
    }

    final Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }
}
