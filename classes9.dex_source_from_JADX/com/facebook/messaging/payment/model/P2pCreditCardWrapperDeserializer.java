package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: identity_keys_temp */
public class P2pCreditCardWrapperDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13201a;

    static {
        GlobalAutoGenDeserializerCache.a(P2pCreditCardWrapper.class, new P2pCreditCardWrapperDeserializer());
        m13497e();
    }

    public P2pCreditCardWrapperDeserializer() {
        a(P2pCreditCardWrapper.class);
    }

    private static synchronized Map<String, FbJsonField> m13497e() {
        Map<String, FbJsonField> map;
        synchronized (P2pCreditCardWrapperDeserializer.class) {
            if (f13201a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mId")));
                    builder.b("credit_card", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mP2pCreditCard")));
                    builder.b("mobile_csc_verified", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mIsMobileCSCVerified")));
                    builder.b("web_csc_verified", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mIsWebCSCVerified")));
                    builder.b("zip_verified", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mIsZipVerified")));
                    builder.b("method_category", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mMethodCategory")));
                    builder.b("commerce_payment_eligible", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mCommercePaymentEligible")));
                    builder.b("personal_transfer_eligible", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mPersonalTransferEligible")));
                    builder.b("is_default_receiving", FbJsonField.jsonField(P2pCreditCardWrapper.class.getDeclaredField("mIsDefaultReceiving")));
                    f13201a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13201a;
        }
        return map;
    }

    public final FbJsonField m13498a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13497e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13497e().keySet());
    }
}
