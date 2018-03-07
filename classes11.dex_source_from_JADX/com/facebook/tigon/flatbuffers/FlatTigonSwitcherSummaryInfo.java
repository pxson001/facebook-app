package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.facebook.tigon.tigonapi.FlatBuffersHelpers;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_items */
public final class FlatTigonSwitcherSummaryInfo extends Table {
    public final String m6198a() {
        int a = a(4);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, a + this.a) : null;
    }
}
