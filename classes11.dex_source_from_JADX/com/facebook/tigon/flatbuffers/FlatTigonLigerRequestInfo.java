package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_total_writes */
public final class FlatTigonLigerRequestInfo extends Table {
    public final boolean m6135a() {
        int a = a(4);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }
}
