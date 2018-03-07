package com.facebook.messaging.payment.service.model.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: firstCodePoint */
public class AddPaymentCardResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14625a;

    static {
        GlobalAutoGenDeserializerCache.a(AddPaymentCardResult.class, new AddPaymentCardResultDeserializer());
        m15157e();
    }

    public AddPaymentCardResultDeserializer() {
        a(AddPaymentCardResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15157e() {
        Map<String, FbJsonField> map;
        synchronized (AddPaymentCardResultDeserializer.class) {
            if (f14625a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("credential_id", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("credentialId")));
                    builder.b("encoded_credential_id", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("encodedCredentialId")));
                    builder.b("follow_up_action_type", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("followUpActionType")));
                    builder.b("follow_up_action_text", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("followUpActionText")));
                    builder.b("follow_up_action_url", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("followUpActionUrl")));
                    builder.b("follow_up_action_button_text", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("followUpActionButtonText")));
                    f14625a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14625a;
        }
        return map;
    }

    public final FbJsonField m15158a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15157e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15157e().keySet());
    }
}
