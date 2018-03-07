package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: nux_seen */
public final class FlatAndroidRetryRequestInfo extends Table {
    public static int m6117a(FlatBufferBuilder flatBufferBuilder, int i, long j, long j2, float f) {
        flatBufferBuilder.b(4);
        flatBufferBuilder.a(2, j2, 0);
        m6120a(flatBufferBuilder, j);
        m6118a(flatBufferBuilder, f);
        m6119a(flatBufferBuilder, i);
        return m6116a(flatBufferBuilder);
    }

    private static void m6119a(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.b(0, i, 0);
    }

    private static void m6120a(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.a(1, j, 0);
    }

    private static void m6118a(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.a(3, f, 0.0d);
    }

    private static int m6116a(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.c();
    }
}
