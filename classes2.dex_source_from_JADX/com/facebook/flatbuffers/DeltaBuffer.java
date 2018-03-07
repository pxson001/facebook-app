package com.facebook.flatbuffers;

import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

/* compiled from: markerNote */
public final class DeltaBuffer {
    @Nullable
    private ByteBuffer f15027a;
    @Nullable
    private SparseArray<SparseArray<DeltaIndex>> f15028b;
    @Nullable
    private SparseArray<SparseArray<Object>> f15029c;
    private final Object f15030d = new Object();

    protected DeltaBuffer() {
    }

    protected DeltaBuffer(@Nullable ByteBuffer byteBuffer) {
        m21569a(byteBuffer);
    }

    private void m21569a(@Nullable ByteBuffer byteBuffer) {
        int i = 0;
        this.f15027a = byteBuffer;
        if (this.f15027a != null) {
            this.f15027a.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = 0;
            while (i2 < 4) {
                if (this.f15027a.get(i2) != ((byte) "DELT".charAt(i2))) {
                    throw new RuntimeException("Delta buffer header is invalid");
                }
                i2++;
            }
            int i3 = this.f15027a.getInt(i2);
            i2 += 4;
            while (i < i3) {
                int i4 = this.f15027a.getInt(i2);
                i2 += 4;
                int i5 = this.f15027a.getInt(i2);
                i2 += 4;
                DeltaIndex deltaIndex = new DeltaIndex(this.f15027a, i2);
                i2 += 12;
                if (this.f15028b == null) {
                    this.f15028b = new SparseArray();
                }
                m21568a(this.f15028b, i4, i5, deltaIndex);
                i++;
            }
        } else {
            this.f15028b = null;
        }
        this.f15029c = null;
    }

    private static void m21568a(SparseArray<SparseArray<DeltaIndex>> sparseArray, int i, int i2, DeltaIndex deltaIndex) {
        SparseArray sparseArray2 = (SparseArray) sparseArray.get(i);
        if (sparseArray2 == null) {
            sparseArray2 = new SparseArray();
            sparseArray.put(i, sparseArray2);
        }
        sparseArray2.put(i2, deltaIndex);
    }

    @Nullable
    protected final ByteBuffer m21570a() {
        ByteBuffer byteBuffer;
        synchronized (this.f15030d) {
            byteBuffer = this.f15027a;
        }
        return byteBuffer;
    }

    protected final boolean m21572a(int i, int i2) {
        synchronized (this.f15030d) {
            SparseArray sparseArray;
            if (this.f15029c != null) {
                sparseArray = (SparseArray) this.f15029c.get(i);
                if (sparseArray != null && sparseArray.indexOfKey(i2) >= 0) {
                    return true;
                }
            }
            if (this.f15028b != null) {
                sparseArray = (SparseArray) this.f15028b.get(i);
                if (sparseArray != null && sparseArray.indexOfKey(i2) >= 0) {
                    return true;
                }
            }
            return false;
        }
    }

    protected final int m21573b(int i, int i2) {
        int intValue;
        synchronized (this.f15030d) {
            SparseArray sparseArray;
            if (this.f15029c != null) {
                sparseArray = (SparseArray) this.f15029c.get(i);
                if (sparseArray != null) {
                    Integer num = (Integer) sparseArray.get(i2);
                    if (num != null) {
                        intValue = num.intValue();
                    }
                }
            }
            if (this.f15028b != null) {
                sparseArray = (SparseArray) this.f15028b.get(i);
                if (sparseArray != null) {
                    DeltaIndex deltaIndex = (DeltaIndex) sparseArray.get(i2);
                    if (deltaIndex == null || this.f15027a == null) {
                        throw new RuntimeException("DeltaBuffer.getInt called on a value that doesn't exist.");
                    } else if (deltaIndex.c != 0) {
                        intValue = this.f15027a.getInt(deltaIndex.c);
                    }
                }
            }
            intValue = 0;
        }
        return intValue;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean m21576c(int r6, int r7) {
        /*
        r5 = this;
        r2 = 1;
        r1 = 0;
        r3 = r5.f15030d;
        monitor-enter(r3);
        r0 = r5.f15029c;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0021;
    L_0x0009:
        r0 = r5.f15029c;	 Catch:{ all -> 0x0043 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0043 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0021;
    L_0x0013:
        r0 = r0.get(r7);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0021;
    L_0x001b:
        r0 = r0.booleanValue();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = r5.f15028b;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0059;
    L_0x0025:
        r0 = r5.f15028b;	 Catch:{ all -> 0x0043 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0043 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0059;
    L_0x002f:
        r0 = r0.get(r7);	 Catch:{ all -> 0x0043 }
        r0 = (com.facebook.flatbuffers.DeltaBuffer.DeltaIndex) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x003b;
    L_0x0037:
        r4 = r5.f15027a;	 Catch:{ all -> 0x0043 }
        if (r4 != 0) goto L_0x0046;
    L_0x003b:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0043 }
        r1 = "DeltaBuffer.getBoolean called on a non-exist value.";
        r0.<init>(r1);	 Catch:{ all -> 0x0043 }
        throw r0;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r4 = r0.c;	 Catch:{  }
        if (r4 == 0) goto L_0x0059;
    L_0x004a:
        r4 = r5.f15027a;	 Catch:{  }
        r0 = r0.c;	 Catch:{  }
        r0 = r4.get(r0);	 Catch:{  }
        if (r0 != r2) goto L_0x0057;
    L_0x0054:
        r0 = r2;
    L_0x0055:
        monitor-exit(r3);	 Catch:{  }
        goto L_0x0020;
    L_0x0057:
        r0 = r1;
        goto L_0x0055;
    L_0x0059:
        monitor-exit(r3);	 Catch:{  }
        r0 = r1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.flatbuffers.DeltaBuffer.c(int, int):boolean");
    }

    @Nullable
    protected final String m21577d(int i, int i2) {
        String str;
        synchronized (this.f15030d) {
            SparseArray sparseArray;
            if (this.f15029c != null) {
                sparseArray = (SparseArray) this.f15029c.get(i);
                if (sparseArray != null) {
                    str = (String) sparseArray.get(i2);
                    if (str != null) {
                    }
                }
            }
            if (this.f15028b != null) {
                sparseArray = (SparseArray) this.f15028b.get(i);
                if (sparseArray != null) {
                    DeltaIndex deltaIndex = (DeltaIndex) sparseArray.get(i2);
                    if (deltaIndex == null || this.f15027a == null) {
                        throw new RuntimeException("DeltaBuffer.getString called on a non-exist value.");
                    } else if (deltaIndex.c != 0) {
                        str = FlatBuffer.m4035a(this.f15027a, deltaIndex.c);
                    }
                }
            }
            str = null;
        }
        return str;
    }

    protected final void m21571a(int i, int i2, Object obj) {
        synchronized (this.f15030d) {
            if (this.f15029c == null) {
                this.f15029c = new SparseArray();
            }
            SparseArray sparseArray = (SparseArray) this.f15029c.get(i);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.f15029c.put(i, sparseArray);
            }
            sparseArray.put(i2, obj);
        }
    }

    protected final boolean m21574b() {
        boolean z;
        synchronized (this.f15030d) {
            if (this.f15029c == null || this.f15029c.size() == 0) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    protected final boolean m21575c() {
        boolean z;
        synchronized (this.f15030d) {
            if (this.f15029c == null || this.f15029c.size() == 0) {
                z = false;
            } else {
                int i;
                int keyAt;
                SparseArray sparseArray;
                int i2;
                int keyAt2;
                int i3;
                int b;
                SparseArray sparseArray2 = new SparseArray();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(256);
                for (i = 0; i < this.f15029c.size(); i++) {
                    keyAt = this.f15029c.keyAt(i);
                    sparseArray = (SparseArray) this.f15029c.valueAt(i);
                    for (i2 = 0; i2 < sparseArray.size(); i2++) {
                        keyAt2 = sparseArray.keyAt(i2);
                        Object valueAt = sparseArray.valueAt(i2);
                        if (valueAt == null) {
                            m21568a(sparseArray2, keyAt, keyAt2, new DeltaIndex(0, 0, 0));
                        } else {
                            if (valueAt instanceof Integer) {
                                flatBufferBuilder.m21491a(((Integer) valueAt).intValue());
                                i3 = 4;
                            } else if (valueAt instanceof Boolean) {
                                flatBufferBuilder.m21490a(((Boolean) valueAt).booleanValue() ? (byte) 1 : (byte) 0);
                                i3 = 1;
                            } else if (valueAt instanceof Long) {
                                flatBufferBuilder.m21499a(((Long) valueAt).longValue());
                                i3 = 8;
                            } else if (valueAt instanceof String) {
                                b = flatBufferBuilder.m21501b();
                                flatBufferBuilder.m21502b((String) valueAt);
                                i3 = flatBufferBuilder.m21501b() - b;
                            } else {
                                throw new RuntimeException("Type not supported in DeltaBuffer:" + valueAt.getClass().getSimpleName());
                            }
                            b = flatBufferBuilder.m21501b();
                            m21568a(sparseArray2, keyAt, keyAt2, new DeltaIndex(b, i3, b));
                        }
                    }
                }
                if (this.f15028b != null) {
                    if (this.f15027a == null) {
                        throw new RuntimeException("mByteBuffer for DeltaBuffer should not be null");
                    }
                    for (keyAt = 0; keyAt < this.f15028b.size(); keyAt++) {
                        keyAt2 = this.f15028b.keyAt(keyAt);
                        sparseArray = (SparseArray) sparseArray2.get(keyAt2);
                        SparseArray sparseArray3 = (SparseArray) this.f15028b.valueAt(keyAt);
                        for (i = 0; i < sparseArray3.size(); i++) {
                            b = sparseArray3.keyAt(i);
                            if (sparseArray == null || sparseArray.indexOfKey(b) < 0) {
                                DeltaIndex deltaIndex = (DeltaIndex) sparseArray3.valueAt(i);
                                if (deltaIndex.c == 0) {
                                    m21568a(sparseArray2, keyAt2, b, deltaIndex);
                                } else {
                                    flatBufferBuilder.m21493a(deltaIndex.a(), deltaIndex.b);
                                    flatBufferBuilder.m21500a(this.f15027a.array(), deltaIndex.a, deltaIndex.b);
                                    int b2 = flatBufferBuilder.m21501b();
                                    m21568a(sparseArray2, keyAt2, b, new DeltaIndex(b2, deltaIndex.b, b2 - (deltaIndex.c - deltaIndex.a)));
                                }
                            }
                        }
                    }
                }
                keyAt = 0;
                i3 = 0;
                while (i3 < sparseArray2.size()) {
                    i2 = keyAt + ((SparseArray) sparseArray2.valueAt(i3)).size();
                    i3++;
                    keyAt = i2;
                }
                int i4 = ((keyAt * 5) + 2) * 4;
                flatBufferBuilder.m21493a(4, 0);
                flatBufferBuilder.m21493a(flatBufferBuilder.m21508c(), i4);
                for (i = 0; i < sparseArray2.size(); i++) {
                    keyAt2 = sparseArray2.keyAt(i);
                    sparseArray = (SparseArray) sparseArray2.valueAt(i);
                    for (i2 = 0; i2 < sparseArray.size(); i2++) {
                        b = sparseArray.keyAt(i2);
                        ((DeltaIndex) sparseArray.valueAt(i2)).a(flatBufferBuilder);
                        flatBufferBuilder.m21491a(b);
                        flatBufferBuilder.m21491a(keyAt2);
                    }
                }
                flatBufferBuilder.m21491a(keyAt);
                for (i4 = 3; i4 >= 0; i4--) {
                    flatBufferBuilder.m21490a((byte) "DELT".charAt(i4));
                }
                m21569a(ByteBuffer.wrap(flatBufferBuilder.m21515e()));
                z = true;
            }
        }
        return z;
    }
}
