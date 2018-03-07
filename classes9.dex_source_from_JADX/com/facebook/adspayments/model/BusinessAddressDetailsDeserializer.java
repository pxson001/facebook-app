package com.facebook.adspayments.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: UTF-8 encoding not supported on this system. */
public class BusinessAddressDetailsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23680a;

    static {
        GlobalAutoGenDeserializerCache.a(BusinessAddressDetails.class, new BusinessAddressDetailsDeserializer());
        m25695e();
    }

    public BusinessAddressDetailsDeserializer() {
        a(BusinessAddressDetails.class);
    }

    private static synchronized Map<String, FbJsonField> m25695e() {
        Map<String, FbJsonField> map;
        synchronized (BusinessAddressDetailsDeserializer.class) {
            if (f23680a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("street1", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mStreet1")));
                    builder.b("street_number", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mStreetNumber")));
                    builder.b("street2", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mStreet2")));
                    builder.b("neighborhood", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mNeighborhood")));
                    builder.b("city", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mCity")));
                    builder.b("state", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mState")));
                    builder.b("zip", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mPostalCode")));
                    builder.b("country_code", FbJsonField.jsonField(BusinessAddressDetails.class.getDeclaredField("mCountryCode")));
                    f23680a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23680a;
        }
        return map;
    }

    public final FbJsonField m25696a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m25695e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m25695e().keySet());
    }
}
