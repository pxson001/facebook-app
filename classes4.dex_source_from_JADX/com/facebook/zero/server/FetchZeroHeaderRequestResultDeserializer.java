package com.facebook.zero.server;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: since_boot_clock_timestamp_ns */
public class FetchZeroHeaderRequestResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f2152a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchZeroHeaderRequestResult.class, new FetchZeroHeaderRequestResultDeserializer());
        m2308e();
    }

    public FetchZeroHeaderRequestResultDeserializer() {
        a(FetchZeroHeaderRequestResult.class);
    }

    private static synchronized Map<String, FbJsonField> m2308e() {
        Map<String, FbJsonField> map;
        synchronized (FetchZeroHeaderRequestResultDeserializer.class) {
            if (f2152a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mCampaignId")));
                    builder.b("status", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mStatus")));
                    builder.b("eid", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mEId")));
                    builder.b("nonce", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mNonce")));
                    builder.b("header_app_id", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mHeaderAppId")));
                    builder.b("emid", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mEncryptedMachineId")));
                    builder.b("ttl", FbJsonField.jsonField(FetchZeroHeaderRequestResult.class.getDeclaredField("mTtl")));
                    f2152a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f2152a;
        }
        return map;
    }

    public final FbJsonField m2309a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m2308e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m2308e().keySet());
    }
}
