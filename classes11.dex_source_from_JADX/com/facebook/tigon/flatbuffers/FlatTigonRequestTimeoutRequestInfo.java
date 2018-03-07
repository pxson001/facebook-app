package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_timeouts */
public final class FlatTigonRequestTimeoutRequestInfo extends Table {
    public final long m6187a() {
        int a = a(4);
        return a != 0 ? this.b.getLong(a + this.a) : 0;
    }
}
