package com.facebook.tigon.tigonapi;

import android.util.Pair;
import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: no_owner */
public class TigonCallbacksHelper {
    @DoNotStrip
    public static void onStarted(TigonBaseCallbacks tigonBaseCallbacks, ByteBuffer byteBuffer) {
        tigonBaseCallbacks.onStarted(FlatBufferDeserializer.m6316a(byteBuffer));
    }

    @DoNotStrip
    public static void onResponse(TigonBaseCallbacks tigonBaseCallbacks, ByteBuffer byteBuffer) {
        tigonBaseCallbacks.onResponse(FlatBufferDeserializer.m6319b(byteBuffer));
    }

    @DoNotStrip
    public static void onEOM(TigonBaseCallbacks tigonBaseCallbacks, ByteBuffer byteBuffer) {
        tigonBaseCallbacks.onEOM((TigonSummaryImpl) FlatBufferDeserializer.m6321c(byteBuffer).second);
    }

    @DoNotStrip
    public static void onError(TigonBaseCallbacks tigonBaseCallbacks, ByteBuffer byteBuffer) {
        Pair c = FlatBufferDeserializer.m6321c(byteBuffer);
        tigonBaseCallbacks.onError((TigonError) c.first, (TigonSummaryImpl) c.second);
    }

    @DoNotStrip
    public static void onWillRetry(TigonBaseCallbacks tigonBaseCallbacks, ByteBuffer byteBuffer) {
        Pair c = FlatBufferDeserializer.m6321c(byteBuffer);
        tigonBaseCallbacks.onWillRetry((TigonError) c.first, (TigonSummaryImpl) c.second);
    }
}
