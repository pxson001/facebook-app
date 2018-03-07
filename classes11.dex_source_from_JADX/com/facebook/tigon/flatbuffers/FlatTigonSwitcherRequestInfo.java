package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.facebook.tigon.tigonapi.FlatBuffersHelpers;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_logging_items */
public final class FlatTigonSwitcherRequestInfo extends Table {
    public final String m6197f(int i) {
        int a = a(4);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, e(a) + (i * 4)) : null;
    }

    public final int m6196a() {
        int a = a(4);
        return a != 0 ? d(a) : 0;
    }
}
