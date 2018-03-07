package com.facebook.messaging.payment.model.verification;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: has_sticker */
public class UserInputDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13487a;

    static {
        GlobalAutoGenDeserializerCache.a(UserInput.class, new UserInputDeserializer());
        m14088e();
    }

    public UserInputDeserializer() {
        a(UserInput.class);
    }

    private static synchronized Map<String, FbJsonField> m14088e() {
        Map<String, FbJsonField> map;
        synchronized (UserInputDeserializer.class) {
            if (f13487a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("first_name", FbJsonField.jsonField(UserInput.class.getDeclaredField("mFirstName")));
                    builder.b("last_name", FbJsonField.jsonField(UserInput.class.getDeclaredField("mLastName")));
                    builder.b("card_first_six", FbJsonField.jsonField(UserInput.class.getDeclaredField("mCardFirstSix")));
                    builder.b("dob_year", FbJsonField.jsonField(UserInput.class.getDeclaredField("mDobYear")));
                    builder.b("dob_month", FbJsonField.jsonField(UserInput.class.getDeclaredField("mDobMonth")));
                    builder.b("dob_day", FbJsonField.jsonField(UserInput.class.getDeclaredField("mDobDay")));
                    builder.b("ssn_last_four", FbJsonField.jsonField(UserInput.class.getDeclaredField("mSsnLastFour")));
                    f13487a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13487a;
        }
        return map;
    }

    public final FbJsonField m14089a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m14088e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m14088e().keySet());
    }
}
