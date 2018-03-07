package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.facebook.tigon.tigonapi.FlatBuffersHelpers;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: numberDelimiter */
public final class FlatTigonHttpFlowStatsInfo extends Table {
    public final String m6126a() {
        int a = a(4);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, a + this.a) : null;
    }

    public final boolean m6127b() {
        int a = a(6);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }

    public final int m6128c() {
        int a = a(8);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final int m6129d() {
        int a = a(10);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final int m6130e() {
        int a = a(12);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final int m6131f() {
        int a = a(14);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final long m6132g() {
        int a = a(16);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final boolean m6133h() {
        int a = a(18);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }
}
