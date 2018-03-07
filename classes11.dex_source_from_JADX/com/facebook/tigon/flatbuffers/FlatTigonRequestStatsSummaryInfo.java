package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_top_pages */
public final class FlatTigonRequestStatsSummaryInfo extends Table {
    public final long m6173a() {
        int a = a(4);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6174b() {
        int a = a(6);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6175c() {
        int a = a(8);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6176d() {
        int a = a(10);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6177e() {
        int a = a(12);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6178f() {
        int a = a(14);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6179g() {
        int a = a(16);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6180h() {
        int a = a(18);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final int m6181i() {
        int a = a(20);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final long m6182j() {
        int a = a(22);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final long m6183k() {
        int a = a(24);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }

    public final int m6184l() {
        int a = a(26);
        return a != 0 ? this.b.getShort(a + this.a) & 65535 : 0;
    }

    public final int m6185m() {
        int a = a(28);
        return a != 0 ? this.b.getShort(a + this.a) & 65535 : 0;
    }

    public final int m6186n() {
        int a = a(30);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }
}
