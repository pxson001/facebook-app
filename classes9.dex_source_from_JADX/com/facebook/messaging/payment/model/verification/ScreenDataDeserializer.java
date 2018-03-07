package com.facebook.messaging.payment.model.verification;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: has_xma */
public class ScreenDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13479a;

    static {
        GlobalAutoGenDeserializerCache.a(ScreenData.class, new ScreenDataDeserializer());
        m14085e();
    }

    public ScreenDataDeserializer() {
        a(ScreenData.class);
    }

    private static synchronized Map<String, FbJsonField> m14085e() {
        Map<String, FbJsonField> map;
        synchronized (ScreenDataDeserializer.class) {
            if (f13479a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("intro_reason", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mIntroReason")));
                    builder.b("first_name", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mFirstName")));
                    builder.b("last_name", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mLastName")));
                    builder.b("sender_short_name", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mSenderShortName")));
                    builder.b("card_issuer", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mCardIssuer")));
                    builder.b("card_last_four", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mCardLastFour")));
                    builder.b("error_message", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mErrorMessage")));
                    builder.b("dob_year", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mDobYear")));
                    builder.b("dob_month", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mDobMonth")));
                    builder.b("dob_day", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mDobDay")));
                    builder.b("is_sender", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mIsSender")));
                    builder.b("previous_attempt_failed", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mPreviousAttemptFailed")));
                    builder.b("has_thrown_exception", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mHasThrownException")));
                    builder.b("verification_succeeded", FbJsonField.jsonField(ScreenData.class.getDeclaredField("mVerificationSucceeded")));
                    f13479a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13479a;
        }
        return map;
    }

    public final FbJsonField m14086a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m14085e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m14085e().keySet());
    }
}
