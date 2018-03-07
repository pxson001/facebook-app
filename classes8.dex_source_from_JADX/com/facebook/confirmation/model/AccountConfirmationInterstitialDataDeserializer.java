package com.facebook.confirmation.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: instantshopping_document_fetch_query?native_document_id= */
public class AccountConfirmationInterstitialDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10780a;

    static {
        GlobalAutoGenDeserializerCache.a(AccountConfirmationInterstitialData.class, new AccountConfirmationInterstitialDataDeserializer());
        m12728e();
    }

    public AccountConfirmationInterstitialDataDeserializer() {
        a(AccountConfirmationInterstitialData.class);
    }

    private static synchronized Map<String, FbJsonField> m12728e() {
        Map<String, FbJsonField> map;
        synchronized (AccountConfirmationInterstitialDataDeserializer.class) {
            if (f10780a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("normalized_contactpoint", FbJsonField.jsonField(AccountConfirmationInterstitialData.class.getDeclaredField("normalizedContactpoint")));
                    builder.b("contactpoint_type", FbJsonField.jsonField(AccountConfirmationInterstitialData.class.getDeclaredField("contactpointType")));
                    builder.b("iso_country_code", FbJsonField.jsonField(AccountConfirmationInterstitialData.class.getDeclaredField("isoCountryCode")));
                    builder.b("interstitial_type", FbJsonField.jsonFieldWithCreator(AccountConfirmationInterstitialData.class.getDeclaredField("interstitialType")));
                    builder.b("min_impression_delay_ms", FbJsonField.jsonField(AccountConfirmationInterstitialData.class.getDeclaredField("minImpressionDelayMs")));
                    f10780a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10780a;
        }
        return map;
    }

    public final FbJsonField m12729a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12728e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12728e().keySet());
    }
}
