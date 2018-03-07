package com.facebook.payments.paymentmethods.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: suggestion_id */
public class CreditCardDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1944a;

    static {
        GlobalAutoGenDeserializerCache.a(CreditCard.class, new CreditCardDeserializer());
        m2171e();
    }

    public CreditCardDeserializer() {
        a(CreditCard.class);
    }

    private static synchronized Map<String, FbJsonField> m2171e() {
        Map<String, FbJsonField> map;
        synchronized (CreditCardDeserializer.class) {
            if (f1944a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mId")));
                    builder.b("expiry_month", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mExpiryMonth")));
                    builder.b("expiry_year", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mExpiryYear")));
                    builder.b("last4", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mLastFour")));
                    builder.b("first6", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mFirstSix")));
                    builder.b("card_type", FbJsonField.jsonFieldWithCreator(CreditCard.class.getDeclaredField("mFbPaymentCardType")));
                    builder.b("readable_card_type", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mReadableCardType")));
                    builder.b("card_holder_name", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mCardHolderName")));
                    builder.b("is_enabled", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mIsEnabled")));
                    builder.b("is_cvv_tricky_bin", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mIsTrickyBin")));
                    builder.b("billing_address", FbJsonField.jsonField(CreditCard.class.getDeclaredField("mAddress")));
                    f1944a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1944a;
        }
        return map;
    }

    public final FbJsonField m2172a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m2171e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m2171e().keySet());
    }
}
