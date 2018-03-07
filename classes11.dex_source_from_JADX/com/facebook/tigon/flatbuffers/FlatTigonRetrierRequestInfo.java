package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_recommended_pages_in_carousel */
public final class FlatTigonRetrierRequestInfo extends Table {
    public final boolean m6191a() {
        int a = a(4);
        return (a == 0 || this.b.get(a + this.a) == (byte) 0) ? false : true;
    }
}
