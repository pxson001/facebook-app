package com.facebook.debug.fieldusage;

import android.support.v4.util.ArrayMap;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import java.util.Map;

/* compiled from: search_chained_pymk */
public class FieldAccessTracker {
    public boolean f2888a = true;
    public byte[] f2889b;
    private byte[] f2890c;
    public int f2891d;
    private String f2892e;
    public String[] f2893f;
    public int f2894g;
    public String f2895h;
    public FieldAccessTracker f2896i;
    public FieldAccessQueryTracker f2897j;
    public int f2898k;

    public FieldAccessTracker(int i, String str, MutableFlattenable mutableFlattenable) {
        int i2 = (i >> 3) + 1;
        this.f2889b = new byte[i2];
        this.f2890c = new byte[i2];
        this.f2893f = new String[i];
        this.f2894g = i;
        this.f2895h = str;
        this.f2892e = mutableFlattenable.getClass().getSimpleName();
        this.f2897j = null;
        if (mutableFlattenable.w_() != null) {
            this.f2891d = mutableFlattenable.A_();
            for (i2 = 0; i2 < i; i2++) {
                Object obj;
                if (FlatBuffer.p(mutableFlattenable.w_().a, mutableFlattenable.u_(), i2) != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    m4036a(i2 >> 3, i2 & 7);
                }
            }
        }
        this.f2896i = null;
    }

    public final void m4036a(int i, int i2) {
        if (this.f2888a) {
            byte[] bArr = this.f2890c;
            bArr[i] = (byte) (bArr[i] | (1 << i2));
        }
    }

    private boolean m4033b(int i) {
        return (this.f2890c[i >> 3] & (1 << (i & 7))) != 0;
    }

    private boolean m4034c(int i) {
        return (this.f2889b[i >> 3] & (1 << (i & 7))) != 0;
    }

    public final void m4037a(StringBuilder stringBuilder) {
        if (this.f2896i != null) {
            this.f2896i.m4037a(stringBuilder);
            stringBuilder.append(this.f2896i.f2891d).append(",").append(this.f2898k).append(".");
        } else if (!this.f2895h.isEmpty()) {
            stringBuilder.append(this.f2895h).append(".");
        }
    }

    public final String m4035a() {
        if (this.f2896i == null) {
            return this.f2895h;
        }
        StringBuilder stringBuilder = new StringBuilder(100);
        this.f2896i.m4037a(stringBuilder);
        stringBuilder.append(this.f2896i.f2891d).append(",").append(this.f2898k);
        return stringBuilder.toString();
    }

    public final void m4038a(Map<String, Map<String, Long>> map, boolean z) {
        String a = m4035a();
        StringBuilder stringBuilder = new StringBuilder(a.length() + 20);
        stringBuilder.append(a);
        for (int i = 0; i < this.f2894g; i++) {
            if (m4033b(i)) {
                String str;
                stringBuilder.setLength(a.length());
                stringBuilder.append("::");
                if (this.f2893f[i] != null) {
                    str = this.f2893f[i];
                } else {
                    str = Integer.toString(i);
                }
                String str2 = str;
                if (z) {
                    stringBuilder.append(this.f2891d);
                } else {
                    stringBuilder.append(this.f2892e);
                }
                stringBuilder.append(".");
                stringBuilder.append(str2);
                String stringBuilder2 = stringBuilder.toString();
                if (map.containsKey(stringBuilder2)) {
                    Map map2 = (Map) map.get(stringBuilder2);
                    Long l = (Long) map2.get("used_count");
                    map2.put("set_count", Long.valueOf(((Long) map2.get("set_count")).longValue() + 1));
                    if (m4034c(i)) {
                        map2.put("used_count", Long.valueOf(l.longValue() + 1));
                    }
                } else {
                    ArrayMap arrayMap = new ArrayMap();
                    arrayMap.put("set_count", Long.valueOf(1));
                    arrayMap.put("used_count", Long.valueOf(m4034c(i) ? 1 : 0));
                    map.put(stringBuilder2, arrayMap);
                }
            }
        }
    }
}
