package com.google.protobuf;

import com.google.protobuf.ByteString.ByteIterator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: already inactive */
class LiteralByteString extends ByteString {
    protected final byte[] f20961c;
    private int f20962d = 0;

    /* compiled from: already inactive */
    class LiteralByteIterator implements ByteIterator {
        final /* synthetic */ LiteralByteString f20958a;
        private int f20959b = 0;
        private final int f20960c;

        public LiteralByteIterator(LiteralByteString literalByteString) {
            this.f20958a = literalByteString;
            this.f20960c = literalByteString.mo912b();
        }

        public boolean hasNext() {
            return this.f20959b < this.f20960c;
        }

        public Object next() {
            return Byte.valueOf(mo908a());
        }

        public final byte mo908a() {
            try {
                byte[] bArr = this.f20958a.f20961c;
                int i = this.f20959b;
                this.f20959b = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public /* synthetic */ Iterator iterator() {
        return mo911a();
    }

    LiteralByteString(byte[] bArr) {
        this.f20961c = bArr;
    }

    public final byte mo909a(int i) {
        return this.f20961c[i];
    }

    public final int mo912b() {
        return this.f20961c.length;
    }

    protected final void mo915b(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f20961c, i, bArr, i2, i3);
    }

    public final String mo914b(String str) {
        return new String(this.f20961c, 0, mo912b(), str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        if (mo912b() != ((ByteString) obj).mo912b()) {
            return false;
        }
        if (mo912b() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return m21390a((LiteralByteString) obj, 0, mo912b());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + obj.getClass());
    }

    final boolean m21390a(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.mo912b()) {
            throw new IllegalArgumentException("Length too large: " + i2 + mo912b());
        } else if (i + i2 > literalByteString.mo912b()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + literalByteString.mo912b());
        } else {
            byte[] bArr = this.f20961c;
            byte[] bArr2 = literalByteString.f20961c;
            int i3 = 0 + i2;
            int i4 = 0;
            int i5 = 0 + i;
            while (i4 < i3) {
                if (bArr[i4] != bArr2[i5]) {
                    return false;
                }
                i4++;
                i5++;
            }
            return true;
        }
    }

    public int hashCode() {
        int i = this.f20962d;
        if (i == 0) {
            i = mo912b();
            i = mo913b(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.f20962d = i;
        }
        return i;
    }

    protected final int mo919i() {
        return this.f20962d;
    }

    protected final int mo913b(int i, int i2, int i3) {
        byte[] bArr = this.f20961c;
        int i4 = 0 + i2;
        int i5 = i4 + i3;
        while (i4 < i5) {
            i = (i * 31) + bArr[i4];
            i4++;
        }
        return i;
    }

    public final InputStream mo917g() {
        return new ByteArrayInputStream(this.f20961c, 0, mo912b());
    }

    public final CodedInputStream mo918h() {
        return CodedInputStream.m20192a(this.f20961c, 0, mo912b());
    }

    public final ByteIterator mo911a() {
        return new LiteralByteIterator(this);
    }

    protected final int mo910a(int i, int i2, int i3) {
        int i4 = 0 + i2;
        return Utf8.m21522a(i, this.f20961c, i4, i4 + i3);
    }

    public final boolean mo916f() {
        int i = 0;
        return Utf8.m21523b(this.f20961c, i, mo912b() + i) == 0;
    }
}
