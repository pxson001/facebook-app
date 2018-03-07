package com.facebook.composer.publish.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: adaptive_image_quality */
public class ErrorDetailsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11512a;

    static {
        GlobalAutoGenDeserializerCache.a(ErrorDetails.class, new ErrorDetailsDeserializer());
        m19656e();
    }

    public ErrorDetailsDeserializer() {
        a(ErrorDetails.class);
    }

    private static synchronized Map<String, FbJsonField> m19656e() {
        Map<String, FbJsonField> map;
        synchronized (ErrorDetailsDeserializer.class) {
            if (f11512a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("is_retriable", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("isRetriable")));
                    builder.b("message", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("userMessage")));
                    builder.b("log_message", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("logMessage")));
                    builder.b("error_code", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("errorCode")));
                    builder.b("error_subcode", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("errorSubcode")));
                    builder.b("sentry_warning_with_user_confirmation_required", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("isSentryWarningWithUserConfirmationRequired")));
                    builder.b("user_title", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("userTitle")));
                    builder.b("video_transcoding_error", FbJsonField.jsonField(ErrorDetails.class.getDeclaredField("isVideoTranscodingError")));
                    f11512a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11512a;
        }
        return map;
    }

    public final FbJsonField m19657a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19656e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19656e().keySet());
    }
}
