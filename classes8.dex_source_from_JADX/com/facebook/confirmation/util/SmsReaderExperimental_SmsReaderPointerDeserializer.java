package com.facebook.confirmation.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: inline_action_save_click */
public class SmsReaderExperimental_SmsReaderPointerDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10817a;

    static {
        GlobalAutoGenDeserializerCache.a(SmsReaderExperimental$SmsReaderPointer.class, new SmsReaderExperimental_SmsReaderPointerDeserializer());
        m12753e();
    }

    public SmsReaderExperimental_SmsReaderPointerDeserializer() {
        a(SmsReaderExperimental$SmsReaderPointer.class);
    }

    private static synchronized Map<String, FbJsonField> m12753e() {
        Map<String, FbJsonField> map;
        synchronized (SmsReaderExperimental_SmsReaderPointerDeserializer.class) {
            if (f10817a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("sms_id", FbJsonField.jsonField(SmsReaderExperimental$SmsReaderPointer.class.getDeclaredField("smsId")));
                    builder.b("mms_id", FbJsonField.jsonField(SmsReaderExperimental$SmsReaderPointer.class.getDeclaredField("mmsId")));
                    f10817a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10817a;
        }
        return map;
    }

    public final FbJsonField m12754a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12753e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12753e().keySet());
    }
}
