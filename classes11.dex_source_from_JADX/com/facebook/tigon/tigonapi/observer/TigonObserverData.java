package com.facebook.tigon.tigonapi.observer;

import android.util.Pair;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.tigonapi.FlatBufferDeserializer;
import com.facebook.tigon.tigonapi.TigonError;
import com.facebook.tigon.tigonapi.TigonResponse;
import com.facebook.tigon.tigonapi.TigonSummaryImpl;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: newLikeCount */
class TigonObserverData implements TigonRequestErrored {
    private long f5073a;
    private TigonRequest f5074b;
    private int f5075c;
    private TigonRequest f5076d;
    private TigonResponse f5077e;
    private TigonSummaryImpl f5078f;
    private TigonError f5079g;

    @DoNotStrip
    private TigonObserverData(long j, TigonRequest tigonRequest, ByteBuffer byteBuffer) {
        this.f5073a = j;
        this.f5074b = tigonRequest;
        if (this.f5074b == null) {
            this.f5074b = FlatBufferDeserializer.m6316a(byteBuffer);
        }
    }

    public long requestId() {
        return this.f5073a;
    }

    public TigonRequest submittedRequest() {
        return this.f5074b;
    }

    public int attempts() {
        return this.f5075c;
    }

    public TigonResponse response() {
        return this.f5077e;
    }

    public TigonSummaryImpl summary() {
        return this.f5078f;
    }

    public TigonError error() {
        return this.f5079g;
    }

    @DoNotStrip
    private void onStarted(int i, ByteBuffer byteBuffer) {
        this.f5075c = i;
        this.f5076d = FlatBufferDeserializer.m6316a(byteBuffer);
    }

    @DoNotStrip
    private void onResponse(ByteBuffer byteBuffer) {
        this.f5077e = FlatBufferDeserializer.m6319b(byteBuffer);
    }

    @DoNotStrip
    private void onFinished(ByteBuffer byteBuffer) {
        Pair c = FlatBufferDeserializer.m6321c(byteBuffer);
        this.f5079g = (TigonError) c.first;
        this.f5078f = (TigonSummaryImpl) c.second;
    }
}
