package com.facebook.tigon.tigonapi;

import android.util.Pair;
import com.facebook.tigon.flatbuffers.FlatFacebookLoggingRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonDelayerRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonError;
import com.facebook.tigon.flatbuffers.FlatTigonFlowTimeDataInfo;
import com.facebook.tigon.flatbuffers.FlatTigonHttpFlowStatsInfo;
import com.facebook.tigon.flatbuffers.FlatTigonIdleTimeoutRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonLigerRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonPriorityQueueRequestTypeInfo;
import com.facebook.tigon.flatbuffers.FlatTigonRequest;
import com.facebook.tigon.flatbuffers.FlatTigonRequestFinished;
import com.facebook.tigon.flatbuffers.FlatTigonRequestStatsSummaryInfo;
import com.facebook.tigon.flatbuffers.FlatTigonRequestTimeoutRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonResponse;
import com.facebook.tigon.flatbuffers.FlatTigonRetrierRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonSummary;
import com.facebook.tigon.flatbuffers.FlatTigonSwitcherRequestInfo;
import com.facebook.tigon.flatbuffers.FlatTigonSwitcherSummaryInfo;
import com.facebook.tigon.iface.FacebookLoggingRequestInfoImpl;
import com.facebook.tigon.iface.TigonDelayerRequestInfoImpl;
import com.facebook.tigon.iface.TigonIdleTimeoutRequestInfoImpl;
import com.facebook.tigon.iface.TigonLigerRequestInfoImpl;
import com.facebook.tigon.iface.TigonPriorityData;
import com.facebook.tigon.iface.TigonPriorityQueueRequestTypeInfoImpl;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.iface.TigonRequestBuilder;
import com.facebook.tigon.iface.TigonRequestLayers;
import com.facebook.tigon.iface.TigonRequestTimeoutRequestInfoImpl;
import com.facebook.tigon.iface.TigonRetrierRequestInfoImpl;
import com.facebook.tigon.iface.TigonSwitcherRequestInfoImpl;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: not page context */
public class FlatBufferDeserializer {
    public static final FlatTigonResponse f5007a = new FlatTigonResponse();
    private static final FlatTigonRequestFinished f5008b = new FlatTigonRequestFinished();
    private static final FlatTigonError f5009c = new FlatTigonError();
    private static final FlatTigonSummary f5010d = new FlatTigonSummary();
    private static final FlatTigonRequestStatsSummaryInfo f5011e = new FlatTigonRequestStatsSummaryInfo();
    private static final FlatTigonSwitcherSummaryInfo f5012f = new FlatTigonSwitcherSummaryInfo();
    private static final FlatTigonHttpFlowStatsInfo f5013g = new FlatTigonHttpFlowStatsInfo();
    public static final FlatTigonFlowTimeDataInfo f5014h = new FlatTigonFlowTimeDataInfo();
    private static final FlatTigonRequest f5015i = new FlatTigonRequest();
    private static final FlatFacebookLoggingRequestInfo f5016j = new FlatFacebookLoggingRequestInfo();
    private static final FlatTigonDelayerRequestInfo f5017k = new FlatTigonDelayerRequestInfo();
    private static final FlatTigonIdleTimeoutRequestInfo f5018l = new FlatTigonIdleTimeoutRequestInfo();
    private static final FlatTigonRequestTimeoutRequestInfo f5019m = new FlatTigonRequestTimeoutRequestInfo();
    private static final FlatTigonRetrierRequestInfo f5020n = new FlatTigonRetrierRequestInfo();
    private static final FlatTigonPriorityQueueRequestTypeInfo f5021o = new FlatTigonPriorityQueueRequestTypeInfo();
    private static final FlatTigonSwitcherRequestInfo f5022p = new FlatTigonSwitcherRequestInfo();
    private static final FlatTigonLigerRequestInfo f5023q = new FlatTigonLigerRequestInfo();
    private static final FlatBufferArrayReader f5024r = new C06641();

    /* compiled from: not page context */
    interface FlatBufferArrayReader {
        String mo128a(int i);
    }

    /* compiled from: not page context */
    final class C06641 implements FlatBufferArrayReader {
        C06641() {
        }

        public final String mo128a(int i) {
            FlatTigonResponse flatTigonResponse = FlatBufferDeserializer.f5007a;
            int a = flatTigonResponse.a(6);
            return a != 0 ? FlatBuffersHelpers.m6336a(flatTigonResponse.b, flatTigonResponse.e(a) + (i * 4)) : null;
        }
    }

    /* compiled from: not page context */
    final class C06652 implements FlatBufferArrayReader {
        C06652() {
        }

        public final String mo128a(int i) {
            FlatTigonFlowTimeDataInfo flatTigonFlowTimeDataInfo = FlatBufferDeserializer.f5014h;
            int a = flatTigonFlowTimeDataInfo.a(4);
            return a != 0 ? FlatBuffersHelpers.m6336a(flatTigonFlowTimeDataInfo.b, flatTigonFlowTimeDataInfo.e(a) + (i * 4)) : null;
        }
    }

    public static synchronized TigonRequest m6316a(ByteBuffer byteBuffer) {
        TigonRequest a;
        int i = 0;
        synchronized (FlatBufferDeserializer.class) {
            FlatTigonRequest a2 = FlatTigonRequest.m6139a(byteBuffer, f5015i);
            TigonRequestBuilder tigonRequestBuilder = new TigonRequestBuilder();
            tigonRequestBuilder.a(a2.m6165a());
            tigonRequestBuilder.b(a2.m6166b());
            tigonRequestBuilder.a(new TigonPriorityData(a2.m6168d(), a2.m6169e()));
            for (int i2 = 0; i2 < a2.m6167c(); i2 += 2) {
                tigonRequestBuilder.a(a2.m6170f(i2), a2.m6170f(i2 + 1));
            }
            FlatFacebookLoggingRequestInfo a3 = a2.m6157a(f5016j);
            if (a3 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.c, new FacebookLoggingRequestInfoImpl(a3.m6121a(), a3.m6122b()));
            }
            FlatTigonIdleTimeoutRequestInfo a4 = a2.m6159a(f5018l);
            if (a4 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.d, new TigonIdleTimeoutRequestInfoImpl(a4.m6134a()));
            }
            FlatTigonDelayerRequestInfo a5 = a2.m6158a(f5017k);
            if (a5 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.b, new TigonDelayerRequestInfoImpl(a5.m6123a()));
            }
            FlatTigonRequestTimeoutRequestInfo a6 = a2.m6162a(f5019m);
            if (a6 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.g, new TigonRequestTimeoutRequestInfoImpl(a6.m6187a()));
            }
            FlatTigonRetrierRequestInfo a7 = a2.m6163a(f5020n);
            if (a7 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.h, new TigonRetrierRequestInfoImpl(a7.m6191a()));
            }
            FlatTigonPriorityQueueRequestTypeInfo a8 = a2.m6161a(f5021o);
            if (a8 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.f, new TigonPriorityQueueRequestTypeInfoImpl(a8.m6136a()));
            }
            FlatTigonSwitcherRequestInfo a9 = a2.m6164a(f5022p);
            if (a9 != null) {
                String[] strArr = new String[a9.m6196a()];
                while (i < strArr.length) {
                    strArr[i] = a9.m6197f(i);
                    i++;
                }
                tigonRequestBuilder.a(TigonRequestLayers.j, new TigonSwitcherRequestInfoImpl(strArr));
            }
            FlatTigonLigerRequestInfo a10 = a2.m6160a(f5023q);
            if (a10 != null) {
                tigonRequestBuilder.a(TigonRequestLayers.e, new TigonLigerRequestInfoImpl(a10.m6135a()));
            }
            a = tigonRequestBuilder.a();
        }
        return a;
    }

    public static synchronized TigonResponse m6319b(ByteBuffer byteBuffer) {
        TigonResponse tigonResponse;
        synchronized (FlatBufferDeserializer.class) {
            FlatTigonResponse.m6188a(byteBuffer, f5007a);
            tigonResponse = new TigonResponse(f5007a.m6189a(), m6318a(f5007a.m6190b(), f5024r));
        }
        return tigonResponse;
    }

    private static HashMap<String, String> m6318a(int i, FlatBufferArrayReader flatBufferArrayReader) {
        if (i % 2 != 0) {
            throw new IllegalArgumentException("Received odd number of strings; keys and vals unmatched");
        }
        HashMap<String, String> hashMap = new HashMap(i / 2);
        for (int i2 = 0; i2 < i; i2 += 2) {
            hashMap.put(flatBufferArrayReader.mo128a(i2), flatBufferArrayReader.mo128a(i2 + 1));
        }
        return hashMap;
    }

    @Nullable
    private static TigonError m6317a(FlatTigonRequestFinished flatTigonRequestFinished) {
        FlatTigonError flatTigonError;
        FlatTigonError flatTigonError2 = f5009c;
        int a = flatTigonRequestFinished.a(4);
        if (a != 0) {
            a = flatTigonRequestFinished.b(a + flatTigonRequestFinished.a);
            ByteBuffer byteBuffer = flatTigonRequestFinished.b;
            flatTigonError2.a = a;
            flatTigonError2.b = byteBuffer;
            flatTigonError = flatTigonError2;
        } else {
            flatTigonError = null;
        }
        Table table = flatTigonError;
        if (table == null) {
            return null;
        }
        String a2;
        a = table.a(4);
        if (a != 0) {
            a = table.b.getInt(a + table.a);
        } else {
            a = 0;
        }
        int i = a;
        a = table.a(6);
        if (a != 0) {
            a2 = FlatBuffersHelpers.m6336a(table.b, a + table.a);
        } else {
            a2 = null;
        }
        String str = a2;
        a = table.a(8);
        if (a != 0) {
            a = table.b.getInt(a + table.a);
        } else {
            a = 0;
        }
        int i2 = a;
        a = table.a(10);
        return new TigonError(i, str, i2, a != 0 ? FlatBuffersHelpers.m6336a(table.b, a + table.a) : null);
    }

    @Nullable
    private static TigonSummaryImpl m6320b(FlatTigonRequestFinished flatTigonRequestFinished) {
        FlatTigonSummary a = flatTigonRequestFinished.m6172a(f5010d);
        if (a == null) {
            return null;
        }
        TigonRequestStatsSummaryInfoImpl tigonRequestStatsSummaryInfoImpl;
        TigonSwitcherSummaryInfoImpl tigonSwitcherSummaryInfoImpl;
        FlatTigonRequestStatsSummaryInfo a2 = a.m6194a(f5011e);
        if (a2 != null) {
            tigonRequestStatsSummaryInfoImpl = new TigonRequestStatsSummaryInfoImpl(a2.m6173a(), a2.m6174b(), a2.m6175c(), a2.m6176d(), a2.m6177e(), a2.m6178f(), a2.m6179g(), a2.m6180h(), a2.m6181i(), a2.m6182j(), a2.m6183k(), a2.m6184l(), a2.m6185m(), a2.m6186n());
        } else {
            tigonRequestStatsSummaryInfoImpl = null;
        }
        FlatTigonSwitcherSummaryInfo a3 = a.m6195a(f5012f);
        if (a3 != null) {
            tigonSwitcherSummaryInfoImpl = new TigonSwitcherSummaryInfoImpl(a3.m6198a());
        } else {
            tigonSwitcherSummaryInfoImpl = null;
        }
        TigonHttpFlowStatsInfoImpl tigonHttpFlowStatsInfoImpl = null;
        FlatTigonHttpFlowStatsInfo a4 = a.m6193a(f5013g);
        if (a4 != null) {
            tigonHttpFlowStatsInfoImpl = new TigonHttpFlowStatsInfoImpl(a4.m6126a(), a4.m6127b(), a4.m6128c(), a4.m6129d(), a4.m6130e(), a4.m6131f(), a4.m6132g(), a4.m6133h());
        }
        TigonFlowTimeDataInfoImpl tigonFlowTimeDataInfoImpl = null;
        if (a.m6192a(f5014h) != null) {
            tigonFlowTimeDataInfoImpl = new TigonFlowTimeDataInfoImpl(m6318a(f5014h.m6125a(), new C06652()));
        }
        return new TigonSummaryImpl(tigonRequestStatsSummaryInfoImpl, tigonSwitcherSummaryInfoImpl, tigonHttpFlowStatsInfoImpl, tigonFlowTimeDataInfoImpl);
    }

    public static synchronized Pair<TigonError, TigonSummary> m6321c(ByteBuffer byteBuffer) {
        Pair<TigonError, TigonSummary> pair;
        synchronized (FlatBufferDeserializer.class) {
            FlatTigonRequestFinished a = FlatTigonRequestFinished.m6171a(byteBuffer, f5008b);
            pair = new Pair(m6317a(a), m6320b(a));
        }
        return pair;
    }
}
