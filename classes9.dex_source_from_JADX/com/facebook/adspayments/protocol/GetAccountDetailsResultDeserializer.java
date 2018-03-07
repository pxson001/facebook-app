package com.facebook.adspayments.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: USE_PARTICIPANTS_NAMES_ONLY */
public class GetAccountDetailsResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23697a;

    static {
        GlobalAutoGenDeserializerCache.a(GetAccountDetailsResult.class, new GetAccountDetailsResultDeserializer());
        m25715e();
    }

    public GetAccountDetailsResultDeserializer() {
        a(GetAccountDetailsResult.class);
    }

    private static synchronized Map<String, FbJsonField> m25715e() {
        Map<String, FbJsonField> map;
        synchronized (GetAccountDetailsResultDeserializer.class) {
            if (f23697a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("stored_balance_status", FbJsonField.jsonField(GetAccountDetailsResult.class.getDeclaredField("mStoredBalanceStatus")));
                    builder.b("business_country_code", FbJsonField.jsonField(GetAccountDetailsResult.class.getDeclaredField("mBusinessCountry")));
                    builder.b("currency", FbJsonField.jsonField(GetAccountDetailsResult.class.getDeclaredField("mCurrency")));
                    f23697a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23697a;
        }
        return map;
    }

    public final FbJsonField m25716a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m25715e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m25715e().keySet());
    }
}
