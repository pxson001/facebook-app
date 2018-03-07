package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: number_format_config */
public final class FlatTigonError extends Table {
    public static int m6124a(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4) {
        flatBufferBuilder.b(4);
        flatBufferBuilder.c(3, i4, 0);
        flatBufferBuilder.b(2, i3, 0);
        flatBufferBuilder.c(1, i2, 0);
        flatBufferBuilder.b(0, i, 0);
        return flatBufferBuilder.c();
    }
}
