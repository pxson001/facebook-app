package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_total_batch_requests_sent */
public final class FlatTigonRequestFinished extends Table {
    public static FlatTigonRequestFinished m6171a(ByteBuffer byteBuffer, FlatTigonRequestFinished flatTigonRequestFinished) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        flatTigonRequestFinished.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        flatTigonRequestFinished.b = byteBuffer;
        return flatTigonRequestFinished;
    }

    public final FlatTigonSummary m6172a(FlatTigonSummary flatTigonSummary) {
        int a = a(6);
        if (a == 0) {
            return null;
        }
        a = b(a + this.a);
        ByteBuffer byteBuffer = this.b;
        flatTigonSummary.a = a;
        flatTigonSummary.b = byteBuffer;
        return flatTigonSummary;
    }
}
