package com.facebook.flatbuffers;

import android.util.SparseArray;
import com.facebook.flatbuffers.DeltaBuffer.DeltaIndex;
import com.facebook.graphql.model.extras.BaseExtra;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

/* compiled from: home_stories_entry */
public final class ExtraBuffer {
    @Nullable
    private ByteBuffer f20934a;
    @Nullable
    private SparseArray<DeltaIndex> f20935b;
    @Nullable
    private SparseArray<Extra> f20936c;
    @Nullable
    private MutableFlatBuffer f20937d;
    private final Object f20938e = new Object();

    protected ExtraBuffer() {
    }

    protected ExtraBuffer(ByteBuffer byteBuffer) {
        m28658a(byteBuffer);
    }

    private void m28658a(ByteBuffer byteBuffer) {
        int i = 0;
        this.f20934a = byteBuffer;
        this.f20937d = null;
        if (this.f20934a != null) {
            this.f20934a.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = 0;
            while (i2 < 4) {
                if (this.f20934a.get(i2) != ((byte) "EXTR".charAt(i2))) {
                    throw new RuntimeException("Extra buffer header is invalid");
                }
                i2++;
            }
            this.f20935b = new SparseArray();
            int i3 = this.f20934a.getInt(i2);
            i2 += 4;
            while (i < i3) {
                int i4 = this.f20934a.getInt(i2);
                i2 += 4;
                DeltaIndex deltaIndex = new DeltaIndex(this.f20934a, i2);
                i2 += 12;
                this.f20935b.put(i4, deltaIndex);
                i++;
            }
            return;
        }
        this.f20935b = null;
    }

    @Nullable
    private MutableFlatBuffer m28659d() {
        if (this.f20937d == null && this.f20934a != null) {
            this.f20937d = new MutableFlatBuffer(this.f20934a, null, null, false, null);
        }
        return this.f20937d;
    }

    @Nullable
    protected final ByteBuffer m28661a() {
        ByteBuffer byteBuffer;
        synchronized (this.f20938e) {
            byteBuffer = this.f20934a;
        }
        return byteBuffer;
    }

    protected final <T extends Extra> T m28660a(int i, Flattenable flattenable, Class<T> cls) {
        T t;
        synchronized (this.f20938e) {
            BaseExtra baseExtra;
            DeltaIndex deltaIndex;
            if (this.f20936c != null) {
                int indexOfKey = this.f20936c.indexOfKey(i);
                if (indexOfKey >= 0) {
                    t = (BaseExtra) this.f20936c.valueAt(indexOfKey);
                }
                try {
                    baseExtra = (BaseExtra) cls.newInstance();
                    if (this.f20935b != null) {
                        deltaIndex = (DeltaIndex) this.f20935b.get(i);
                        if (!(deltaIndex == null || deltaIndex.c == 0)) {
                            if (m28659d() == null) {
                                throw new RuntimeException("mByteBuffer should not be null.");
                            } else if (baseExtra instanceof Flattenable) {
                                throw new RuntimeException("object should implement Flattenable to save persistent states.");
                            } else {
                                baseExtra.mo1412a(m28659d(), deltaIndex.c);
                            }
                        }
                    }
                    this.f20936c.put(i, baseExtra);
                } catch (Throwable e) {
                    throw new RuntimeException("Not able to create object", e);
                } catch (Throwable e2) {
                    throw new RuntimeException("Access to constructor denied", e2);
                }
            }
            this.f20936c = new SparseArray();
            baseExtra = (BaseExtra) cls.newInstance();
            if (this.f20935b != null) {
                deltaIndex = (DeltaIndex) this.f20935b.get(i);
                if (m28659d() == null) {
                    throw new RuntimeException("mByteBuffer should not be null.");
                } else if (baseExtra instanceof Flattenable) {
                    throw new RuntimeException("object should implement Flattenable to save persistent states.");
                } else {
                    baseExtra.mo1412a(m28659d(), deltaIndex.c);
                }
            }
            this.f20936c.put(i, baseExtra);
        }
        return t;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean m28662b() {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        r4 = r6.f20938e;
        monitor-enter(r4);
        r0 = r6.f20936c;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r6.f20936c;	 Catch:{ all -> 0x003e }
        r0 = r0.size();	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0014;
    L_0x0011:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r2;
    L_0x0013:
        return r0;
    L_0x0014:
        r3 = r2;
    L_0x0015:
        r0 = r6.f20936c;	 Catch:{ all -> 0x003e }
        r0 = r0.size();	 Catch:{ all -> 0x003e }
        if (r3 >= r0) goto L_0x003b;
    L_0x001d:
        r0 = r6.f20936c;	 Catch:{ all -> 0x003e }
        r0 = r0.valueAt(r3);	 Catch:{ all -> 0x003e }
        r0 = (com.facebook.graphql.model.extras.BaseExtra) r0;	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x002a;
    L_0x0027:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
        goto L_0x0013;
    L_0x002a:
        r5 = r0.m28655a();	 Catch:{ all -> 0x003e }
        if (r5 == 0) goto L_0x0037;
    L_0x0030:
        r0 = r0 instanceof com.facebook.flatbuffers.Flattenable;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0037;
    L_0x0034:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
        goto L_0x0013;
    L_0x0037:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0015;
    L_0x003b:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r2;
        goto L_0x0013;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.flatbuffers.ExtraBuffer.b():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean m28663c() {
        /*
        r12 = this;
        r3 = 0;
        r5 = r12.f20938e;
        monitor-enter(r5);
        r1 = r12.f20936c;	 Catch:{ all -> 0x0076 }
        if (r1 == 0) goto L_0x0010;
    L_0x0008:
        r1 = r12.f20936c;	 Catch:{ all -> 0x0076 }
        r1 = r1.size();	 Catch:{ all -> 0x0076 }
        if (r1 != 0) goto L_0x0013;
    L_0x0010:
        monitor-exit(r5);	 Catch:{ all -> 0x0076 }
        r1 = r3;
    L_0x0012:
        return r1;
    L_0x0013:
        r6 = new android.util.SparseArray;	 Catch:{ all -> 0x0076 }
        r6.<init>();	 Catch:{ all -> 0x0076 }
        r7 = new com.facebook.flatbuffers.FlatBufferBuilder;	 Catch:{ all -> 0x0076 }
        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r7.<init>(r1);	 Catch:{ all -> 0x0076 }
        r4 = r3;
    L_0x0020:
        r1 = r12.f20936c;	 Catch:{ all -> 0x0076 }
        r1 = r1.size();	 Catch:{ all -> 0x0076 }
        if (r4 >= r1) goto L_0x0079;
    L_0x0028:
        r1 = r12.f20936c;	 Catch:{ all -> 0x0076 }
        r8 = r1.keyAt(r4);	 Catch:{ all -> 0x0076 }
        r1 = r12.f20936c;	 Catch:{ all -> 0x0076 }
        r1 = r1.valueAt(r4);	 Catch:{ all -> 0x0076 }
        r1 = (com.facebook.graphql.model.extras.BaseExtra) r1;	 Catch:{ all -> 0x0076 }
        if (r1 != 0) goto L_0x0047;
    L_0x0038:
        r1 = new com.facebook.flatbuffers.DeltaBuffer$DeltaIndex;	 Catch:{ all -> 0x0076 }
        r2 = 0;
        r9 = 0;
        r10 = 0;
        r1.<init>(r2, r9, r10);	 Catch:{ all -> 0x0076 }
        r6.put(r8, r1);	 Catch:{ all -> 0x0076 }
    L_0x0043:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x0020;
    L_0x0047:
        r2 = r1.m28655a();	 Catch:{ all -> 0x0076 }
        if (r2 == 0) goto L_0x0043;
    L_0x004d:
        r2 = r1 instanceof com.facebook.flatbuffers.Flattenable;	 Catch:{ all -> 0x0076 }
        if (r2 == 0) goto L_0x0043;
    L_0x0051:
        r7.m21489a();	 Catch:{ all -> 0x0076 }
        r9 = r7.m21501b();	 Catch:{ all -> 0x0076 }
        r0 = r1;
        r0 = (com.facebook.flatbuffers.Flattenable) r0;	 Catch:{ all -> 0x0076 }
        r2 = r0;
        r2 = r7.m21475a(r2);	 Catch:{ all -> 0x0076 }
        r10 = r7.m21501b();	 Catch:{ all -> 0x0076 }
        r9 = r10 - r9;
        r10 = new com.facebook.flatbuffers.DeltaBuffer$DeltaIndex;	 Catch:{ all -> 0x0076 }
        r11 = r7.m21501b();	 Catch:{ all -> 0x0076 }
        r10.<init>(r11, r9, r2);	 Catch:{ all -> 0x0076 }
        r6.put(r8, r10);	 Catch:{ all -> 0x0076 }
        r1.m28656b();	 Catch:{ all -> 0x0076 }
        goto L_0x0043;
    L_0x0076:
        r1 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0076 }
        throw r1;
    L_0x0079:
        r1 = r6.size();	 Catch:{  }
        if (r1 != 0) goto L_0x0082;
    L_0x007f:
        monitor-exit(r5);	 Catch:{  }
        r1 = r3;
        goto L_0x0012;
    L_0x0082:
        r1 = r12.f20935b;	 Catch:{  }
        if (r1 == 0) goto L_0x00e7;
    L_0x0086:
        r1 = r12.f20934a;	 Catch:{  }
        if (r1 != 0) goto L_0x0092;
    L_0x008a:
        r1 = new java.lang.RuntimeException;	 Catch:{  }
        r2 = "mByteBuffer for ExtraBuffer should not be null";
        r1.<init>(r2);	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x0092:
        r2 = r3;
    L_0x0093:
        r1 = r12.f20935b;	 Catch:{  }
        r1 = r1.size();	 Catch:{  }
        if (r2 >= r1) goto L_0x00e7;
    L_0x009b:
        r1 = r12.f20935b;	 Catch:{  }
        r4 = r1.keyAt(r2);	 Catch:{  }
        r1 = r6.indexOfKey(r4);	 Catch:{  }
        if (r1 >= 0) goto L_0x00b6;
    L_0x00a7:
        r1 = r12.f20935b;	 Catch:{  }
        r1 = r1.valueAt(r2);	 Catch:{  }
        r1 = (com.facebook.flatbuffers.DeltaBuffer.DeltaIndex) r1;	 Catch:{  }
        r8 = r1.c;	 Catch:{  }
        if (r8 != 0) goto L_0x00ba;
    L_0x00b3:
        r6.put(r4, r1);	 Catch:{  }
    L_0x00b6:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0093;
    L_0x00ba:
        r8 = r1.a();	 Catch:{  }
        r9 = r1.b;	 Catch:{  }
        r7.m21493a(r8, r9);	 Catch:{  }
        r8 = r12.f20934a;	 Catch:{  }
        r8 = r8.array();	 Catch:{  }
        r9 = r1.a;	 Catch:{  }
        r10 = r1.b;	 Catch:{  }
        r7.m21500a(r8, r9, r10);	 Catch:{  }
        r8 = r7.m21501b();	 Catch:{  }
        r9 = new com.facebook.flatbuffers.DeltaBuffer$DeltaIndex;	 Catch:{  }
        r10 = r1.b;	 Catch:{  }
        r11 = r1.c;	 Catch:{  }
        r1 = r1.a;	 Catch:{  }
        r1 = r11 - r1;
        r1 = r8 - r1;
        r9.<init>(r8, r10, r1);	 Catch:{  }
        r6.put(r4, r9);	 Catch:{  }
        goto L_0x00b6;
    L_0x00e7:
        r1 = r6.size();	 Catch:{  }
        r1 = r1 * 4;
        r1 = r1 + 2;
        r1 = r1 * 4;
        r2 = 4;
        r4 = 0;
        r7.m21493a(r2, r4);	 Catch:{  }
        r2 = r7.m21508c();	 Catch:{  }
        r7.m21493a(r2, r1);	 Catch:{  }
    L_0x00fd:
        r1 = r6.size();	 Catch:{  }
        if (r3 >= r1) goto L_0x0116;
    L_0x0103:
        r2 = r6.keyAt(r3);	 Catch:{  }
        r1 = r6.valueAt(r3);	 Catch:{  }
        r1 = (com.facebook.flatbuffers.DeltaBuffer.DeltaIndex) r1;	 Catch:{  }
        r1.a(r7);	 Catch:{  }
        r7.m21491a(r2);	 Catch:{  }
        r3 = r3 + 1;
        goto L_0x00fd;
    L_0x0116:
        r1 = r6.size();	 Catch:{  }
        r7.m21491a(r1);	 Catch:{  }
        r1 = 3;
    L_0x011e:
        if (r1 < 0) goto L_0x012d;
    L_0x0120:
        r2 = "EXTR";
        r2 = r2.charAt(r1);	 Catch:{  }
        r2 = (byte) r2;	 Catch:{  }
        r7.m21490a(r2);	 Catch:{  }
        r1 = r1 + -1;
        goto L_0x011e;
    L_0x012d:
        r1 = r7.m21515e();	 Catch:{  }
        r1 = java.nio.ByteBuffer.wrap(r1);	 Catch:{  }
        r12.m28658a(r1);	 Catch:{  }
        r1 = 1;
        monitor-exit(r5);	 Catch:{  }
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.flatbuffers.ExtraBuffer.c():boolean");
    }
}
