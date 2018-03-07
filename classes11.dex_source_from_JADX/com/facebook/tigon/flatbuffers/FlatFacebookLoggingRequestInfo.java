package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.facebook.tigon.tigonapi.FlatBuffersHelpers;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: numeric */
public final class FlatFacebookLoggingRequestInfo extends Table {
    public final String m6121a() {
        int a = a(4);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, a + this.a) : null;
    }

    public final String m6122b() {
        int a = a(6);
        return a != 0 ? FlatBuffersHelpers.m6336a(this.b, a + this.a) : null;
    }
}
