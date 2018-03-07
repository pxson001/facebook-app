package com.facebook.zero.sdk.request;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.facebook.bugreporter.annotations.InternalSettingsActivity */
public class FetchZeroInterstitialEligibilityResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5899a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchZeroInterstitialEligibilityResult.class, new FetchZeroInterstitialEligibilityResultDeserializer());
        m10661e();
    }

    public FetchZeroInterstitialEligibilityResultDeserializer() {
        a(FetchZeroInterstitialEligibilityResult.class);
    }

    private static synchronized Map<String, FbJsonField> m10661e() {
        Map<String, FbJsonField> map;
        synchronized (FetchZeroInterstitialEligibilityResultDeserializer.class) {
            if (f5899a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(FetchZeroInterstitialEligibilityResult.class.getDeclaredField("mCampaignId")));
                    builder.b("type", FbJsonField.jsonField(FetchZeroInterstitialEligibilityResult.class.getDeclaredField("mType")));
                    builder.b("ttl", FbJsonField.jsonField(FetchZeroInterstitialEligibilityResult.class.getDeclaredField("mTtl")));
                    builder.b("delay_interval", FbJsonField.jsonField(FetchZeroInterstitialEligibilityResult.class.getDeclaredField("mDelayInterval")));
                    f5899a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5899a;
        }
        return map;
    }

    public final FbJsonField m10662a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10661e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10661e().keySet());
    }
}
