package com.facebook.messaging.payment.service.model.pay;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_pages_time */
public class SendPaymentBarCodeDetailsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14673a;

    static {
        GlobalAutoGenDeserializerCache.a(SendPaymentBarCodeDetails.class, new SendPaymentBarCodeDetailsDeserializer());
        m15185e();
    }

    public SendPaymentBarCodeDetailsDeserializer() {
        a(SendPaymentBarCodeDetails.class);
    }

    private static synchronized Map<String, FbJsonField> m15185e() {
        Map<String, FbJsonField> map;
        synchronized (SendPaymentBarCodeDetailsDeserializer.class) {
            if (f14673a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("barcode", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mBarCode")));
                    builder.b("qrcode", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mQrCode")));
                    builder.b("barcode_value", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mBarCodeValue")));
                    builder.b("expiry_timestamp", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mExpiryTimeStamp")));
                    builder.b("instructions_url", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mInstructionsUrl")));
                    builder.b("reference_no_1", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mReferenceNo1")));
                    builder.b("reference_no_2", FbJsonField.jsonField(SendPaymentBarCodeDetails.class.getDeclaredField("mReferenceNo2")));
                    f14673a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14673a;
        }
        return map;
    }

    public final FbJsonField m15186a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15185e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15185e().keySet());
    }
}
