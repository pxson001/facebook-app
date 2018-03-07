package com.facebook.qe.store;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.qe.schema.Schema;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: undo_action */
public class Index {
    @GuardedBy("this")
    private final ByteBuffer f1978a;
    private final int f1979b;
    private final int f1980c;
    private final int f1981d;
    private final int f1982e;
    public final int f1983f;

    public static Index m4008a() {
        try {
            return new Index(ByteBuffer.wrap(IndexBuilder.a(Collections.emptyList(), false)), false);
        } catch (StoreIntegrityException e) {
            throw new RuntimeException(e);
        }
    }

    public static Index m4009a(Schema schema) {
        try {
            return new Index(ByteBuffer.wrap(schema.mo570d()), false);
        } catch (StoreIntegrityException e) {
            throw new RuntimeException(e);
        }
    }

    public Index(ByteBuffer byteBuffer, boolean z) {
        this.f1978a = byteBuffer;
        if (z) {
            m4012c();
        }
        this.f1978a.position(12);
        this.f1983f = FlatBuffer.m4026a(this.f1978a);
        this.f1979b = FlatBuffer.m4060o(this.f1978a, this.f1983f, 3);
        this.f1980c = FlatBuffer.m4060o(this.f1978a, this.f1983f, 1);
        this.f1981d = FlatBuffer.m4060o(this.f1978a, this.f1983f, 4);
        this.f1982e = FlatBuffer.m4060o(this.f1978a, this.f1983f, 2);
    }

    public final synchronized int m4014a(int i) {
        int b;
        b = FlatBuffer.m4042b(this.f1978a, this.f1979b, i, -1);
        if (b == -1) {
            throw new IllegalStateException("No experiment index found for slot " + i);
        }
        return b;
    }

    public final synchronized String m4019b(int i) {
        return FlatBuffer.m4035a(this.f1978a, FlatBuffer.m4059n(this.f1978a, this.f1980c, i));
    }

    public final synchronized int m4021c(int i) {
        int b;
        b = FlatBuffer.m4042b(this.f1978a, this.f1981d, i, -1);
        if (b == -1) {
            throw new IllegalStateException("No first slot found for experiment index " + i);
        }
        return b;
    }

    public final synchronized int m4016a(String str, String str2) {
        int i = -1;
        synchronized (this) {
            int a = FlatBuffer.m4028a(this.f1978a, this.f1983f, 1, str);
            if (a != -1) {
                a = FlatBuffer.m4059n(this.f1978a, this.f1982e, a);
                int a2 = FlatBuffer.m4028a(this.f1978a, a, 1, str2);
                if (a2 != -1) {
                    i = FlatBuffer.m4027a(this.f1978a, FlatBuffer.m4059n(this.f1978a, FlatBuffer.m4060o(this.f1978a, a, 2), a2), 1, -1);
                }
            }
        }
        return i;
    }

    public final synchronized void m4017a(Visitor visitor) {
        boolean z = true;
        synchronized (this) {
            synchronized (this) {
                if (this.f1980c == 0) {
                } else {
                    int b = FlatBuffer.m4041b(this.f1978a, this.f1980c);
                    int b2 = FlatBuffer.m4041b(this.f1978a, this.f1982e);
                    if (b != b2) {
                        z = false;
                    }
                    Preconditions.m2016a(z);
                    for (b2 = 0; b2 < b; b2++) {
                        String a;
                        int n;
                        int o;
                        int b3;
                        int o2;
                        synchronized (this) {
                            a = FlatBuffer.m4035a(this.f1978a, FlatBuffer.m4059n(this.f1978a, this.f1980c, b2));
                            n = FlatBuffer.m4059n(this.f1978a, this.f1982e, b2);
                            o = FlatBuffer.m4060o(this.f1978a, n, 1);
                            if (o == 0) {
                                throw new IllegalStateException("No parameters found for experiment " + a);
                            }
                            b3 = FlatBuffer.m4041b(this.f1978a, o);
                            o2 = FlatBuffer.m4060o(this.f1978a, n, 2);
                        }
                        for (n = 0; n < b3; n++) {
                            int n2;
                            String a2;
                            int a3;
                            synchronized (this) {
                                int n3 = FlatBuffer.m4059n(this.f1978a, o, n);
                                n2 = FlatBuffer.m4059n(this.f1978a, o2, n);
                                a2 = FlatBuffer.m4035a(this.f1978a, n3);
                                a3 = FlatBuffer.m4027a(this.f1978a, n2, 1, -1);
                                n2 = FlatBuffer.m4027a(this.f1978a, n2, 2, -1);
                            }
                            if (n == 0) {
                                visitor.a(a, a3);
                            }
                            visitor.a(a2, a3, n2, m4013d(n));
                        }
                    }
                }
            }
        }
    }

    private static boolean m4013d(int i) {
        return i <= 3;
    }

    public final synchronized Iterable<String> m4018b() {
        return new 1(this, m4010b(this.f1978a));
    }

    private static ByteBuffer m4010b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        return duplicate;
    }

    public final synchronized int m4015a(String str) {
        return FlatBuffer.m4028a(this.f1978a, this.f1983f, 1, str);
    }

    public final synchronized boolean m4020b(String str) {
        boolean z = true;
        synchronized (this) {
            if (FlatBuffer.m4028a(this.f1978a, this.f1983f, 1, str) == -1) {
                z = false;
            }
        }
        return z;
    }

    private synchronized void m4012c() {
        this.f1978a.position(0);
        int remaining = this.f1978a.remaining();
        if (remaining < 12) {
            throw new StoreIntegrityException("index.bin is too small to verify: " + remaining + " bytes less than expected: 12" + " bytes");
        }
        int i = this.f1978a.getInt(0);
        if (i != -87117812) {
            throw new StoreIntegrityException("Unexpected magic: " + i + " Expected: -87117812");
        }
        i = this.f1978a.getInt(4);
        if (i != 538251273) {
            throw new StoreIntegrityException("Unexpected version: " + i + " Expected: 538251273");
        }
        i = this.f1978a.getInt(8);
        if (remaining != i) {
            throw new StoreIntegrityException("Unexpected index.bin size: '" + remaining + " Expected: " + i);
        }
    }

    public static <T> Iterator<T> m4011b(Iterator<T> it) {
        if (it == null) {
            return Collections.emptyList().iterator();
        }
        return it;
    }
}
