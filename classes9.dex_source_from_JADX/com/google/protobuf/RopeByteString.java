package com.google.protobuf;

import com.google.protobuf.ByteString.ByteIterator;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/* compiled from: allows_rsvp */
class RopeByteString extends ByteString {
    private static final int[] f20987c;
    private final int f20988d;
    public final ByteString f20989e;
    public final ByteString f20990f;
    private final int f20991g;
    private int f20992h;

    /* compiled from: allows_rsvp */
    class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> f20974a = new Stack();
        private LiteralByteString f20975b;

        public /* synthetic */ Object next() {
            return m21419a();
        }

        public PieceIterator(ByteString byteString) {
            this.f20975b = m21417a(byteString);
        }

        private LiteralByteString m21417a(ByteString byteString) {
            ByteString byteString2 = byteString;
            while (byteString2 instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString2;
                this.f20974a.push(ropeByteString);
                byteString2 = ropeByteString.f20989e;
            }
            return (LiteralByteString) byteString2;
        }

        private LiteralByteString m21418b() {
            while (!this.f20974a.isEmpty()) {
                LiteralByteString a = m21417a(((RopeByteString) this.f20974a.pop()).f20990f);
                if ((a.mo912b() == 0 ? 1 : null) == null) {
                    return a;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.f20975b != null;
        }

        public final LiteralByteString m21419a() {
            if (this.f20975b == null) {
                throw new NoSuchElementException();
            }
            LiteralByteString literalByteString = this.f20975b;
            this.f20975b = m21418b();
            return literalByteString;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: allows_rsvp */
    class RopeByteIterator implements ByteIterator {
        int f20976a;
        final /* synthetic */ RopeByteString f20977b;
        private final PieceIterator f20978c;
        private ByteIterator f20979d = this.f20978c.m21419a().mo911a();

        public RopeByteIterator(RopeByteString ropeByteString) {
            this.f20977b = ropeByteString;
            this.f20978c = new PieceIterator(ropeByteString);
            this.f20976a = ropeByteString.mo912b();
        }

        public boolean hasNext() {
            return this.f20976a > 0;
        }

        public Object next() {
            return Byte.valueOf(mo908a());
        }

        public final byte mo908a() {
            if (!this.f20979d.hasNext()) {
                this.f20979d = this.f20978c.m21419a().mo911a();
            }
            this.f20976a--;
            return this.f20979d.mo908a();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: allows_rsvp */
    class RopeInputStream extends InputStream {
        final /* synthetic */ RopeByteString f20980a;
        private PieceIterator f20981b;
        private LiteralByteString f20982c;
        private int f20983d;
        private int f20984e;
        private int f20985f;
        private int f20986g;

        public RopeInputStream(RopeByteString ropeByteString) {
            this.f20980a = ropeByteString;
            m21422a();
        }

        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return m21421a(bArr, i, i2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) m21421a(null, 0, (int) j);
        }

        private int m21421a(byte[] bArr, int i, int i2) {
            int i3 = i2;
            int i4 = i;
            while (i3 > 0) {
                m21423b();
                if (this.f20982c == null) {
                    if (i3 == i2) {
                        return -1;
                    }
                    return i2 - i3;
                }
                int min = Math.min(this.f20983d - this.f20984e, i3);
                if (bArr != null) {
                    this.f20982c.m20180a(bArr, this.f20984e, i4, min);
                    i4 += min;
                }
                this.f20984e += min;
                i3 -= min;
            }
            return i2 - i3;
        }

        public int read() {
            m21423b();
            if (this.f20982c == null) {
                return -1;
            }
            LiteralByteString literalByteString = this.f20982c;
            int i = this.f20984e;
            this.f20984e = i + 1;
            return literalByteString.mo909a(i) & 255;
        }

        public int available() {
            return this.f20980a.mo912b() - (this.f20985f + this.f20984e);
        }

        public boolean markSupported() {
            return true;
        }

        public void mark(int i) {
            this.f20986g = this.f20985f + this.f20984e;
        }

        public synchronized void reset() {
            m21422a();
            m21421a(null, 0, this.f20986g);
        }

        private void m21422a() {
            this.f20981b = new PieceIterator(this.f20980a);
            this.f20982c = this.f20981b.m21419a();
            this.f20983d = this.f20982c.mo912b();
            this.f20984e = 0;
            this.f20985f = 0;
        }

        private void m21423b() {
            if (this.f20982c != null && this.f20984e == this.f20983d) {
                this.f20985f += this.f20983d;
                this.f20984e = 0;
                if (this.f20981b.hasNext()) {
                    this.f20982c = this.f20981b.m21419a();
                    this.f20983d = this.f20982c.mo912b();
                    return;
                }
                this.f20982c = null;
                this.f20983d = 0;
            }
        }
    }

    public /* synthetic */ Iterator iterator() {
        return mo911a();
    }

    static {
        int i = 1;
        List arrayList = new ArrayList();
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(Integer.MAX_VALUE));
        f20987c = new int[arrayList.size()];
        for (i2 = 0; i2 < f20987c.length; i2++) {
            f20987c[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
    }

    public final byte mo909a(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        } else if (i > this.f20988d) {
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + this.f20988d);
        } else if (i < this.f20991g) {
            return this.f20989e.mo909a(i);
        } else {
            return this.f20990f.mo909a(i - this.f20991g);
        }
    }

    public final int mo912b() {
        return this.f20988d;
    }

    protected final void mo915b(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.f20991g) {
            this.f20989e.mo915b(bArr, i, i2, i3);
        } else if (i >= this.f20991g) {
            this.f20990f.mo915b(bArr, i - this.f20991g, i2, i3);
        } else {
            int i4 = this.f20991g - i;
            this.f20989e.mo915b(bArr, i, i2, i4);
            this.f20990f.mo915b(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    public final String mo914b(String str) {
        return new String(m20185d(), str);
    }

    public final boolean mo916f() {
        if (this.f20990f.mo910a(this.f20989e.mo910a(0, 0, this.f20991g), 0, this.f20990f.mo912b()) == 0) {
            return true;
        }
        return false;
    }

    protected final int mo910a(int i, int i2, int i3) {
        if (i2 + i3 <= this.f20991g) {
            return this.f20989e.mo910a(i, i2, i3);
        }
        if (i2 >= this.f20991g) {
            return this.f20990f.mo910a(i, i2 - this.f20991g, i3);
        }
        int i4 = this.f20991g - i2;
        return this.f20990f.mo910a(this.f20989e.mo910a(i, i2, i4), 0, i3 - i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f20988d != byteString.mo912b()) {
            return false;
        }
        if (this.f20988d == 0) {
            return true;
        }
        if (this.f20992h != 0) {
            int i = byteString.mo919i();
            if (!(i == 0 || this.f20992h == i)) {
                return false;
            }
        }
        return m21424a(byteString);
    }

    private boolean m21424a(ByteString byteString) {
        Iterator pieceIterator = new PieceIterator(this);
        LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
        Iterator pieceIterator2 = new PieceIterator(byteString);
        LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
        int i = 0;
        LiteralByteString literalByteString3 = literalByteString;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean a;
            int b = literalByteString3.mo912b() - i2;
            int b2 = literalByteString2.mo912b() - i;
            int min = Math.min(b, b2);
            if (i2 == 0) {
                a = literalByteString3.m21390a(literalByteString2, i, min);
            } else {
                a = literalByteString2.m21390a(literalByteString3, i2, min);
            }
            if (!a) {
                return false;
            }
            int i4 = i3 + min;
            if (i4 >= this.f20988d) {
                break;
            }
            if (min == b) {
                literalByteString3 = (LiteralByteString) pieceIterator.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == b2) {
                literalByteString2 = (LiteralByteString) pieceIterator2.next();
                i = 0;
                i3 = i4;
            } else {
                i += min;
                i3 = i4;
            }
        }
        if (i4 == this.f20988d) {
            return true;
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        int i = this.f20992h;
        if (i == 0) {
            i = mo913b(this.f20988d, 0, this.f20988d);
            if (i == 0) {
                i = 1;
            }
            this.f20992h = i;
        }
        return i;
    }

    protected final int mo919i() {
        return this.f20992h;
    }

    protected final int mo913b(int i, int i2, int i3) {
        if (i2 + i3 <= this.f20991g) {
            return this.f20989e.mo913b(i, i2, i3);
        }
        if (i2 >= this.f20991g) {
            return this.f20990f.mo913b(i, i2 - this.f20991g, i3);
        }
        int i4 = this.f20991g - i2;
        return this.f20990f.mo913b(this.f20989e.mo913b(i, i2, i4), 0, i3 - i4);
    }

    public final CodedInputStream mo918h() {
        return new CodedInputStream(new RopeInputStream(this));
    }

    public final InputStream mo917g() {
        return new RopeInputStream(this);
    }

    public final ByteIterator mo911a() {
        return new RopeByteIterator(this);
    }
}
