package com.facebook.tigon.flatbuffers;

import android.annotation.SuppressLint;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressLint({"BadArgumentPlacement", "BadClosingBracePlacement", "YodaConditions"})
/* compiled from: num_recommended_pages_in_list */
public final class FlatTigonResponse extends Table {
    public static FlatTigonResponse m6188a(ByteBuffer byteBuffer, FlatTigonResponse flatTigonResponse) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        flatTigonResponse.a = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        flatTigonResponse.b = byteBuffer;
        return flatTigonResponse;
    }

    public final int m6189a() {
        int a = a(4);
        return a != 0 ? this.b.getInt(a + this.a) : 0;
    }

    public final int m6190b() {
        int a = a(6);
        return a != 0 ? d(a) : 0;
    }
}
