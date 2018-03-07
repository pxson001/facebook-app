package com.facebook.katana.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.katana.model.FacebookApiException.ServerExceptionData;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: update-pinned-threads */
public class FacebookApiException_ServerExceptionDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f935a;

    static {
        GlobalAutoGenDeserializerCache.a(ServerExceptionData.class, new FacebookApiException_ServerExceptionDataDeserializer());
        m984e();
    }

    public FacebookApiException_ServerExceptionDataDeserializer() {
        a(ServerExceptionData.class);
    }

    private static synchronized Map<String, FbJsonField> m984e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookApiException_ServerExceptionDataDeserializer.class) {
            if (f935a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("error_code", FbJsonField.jsonField(ServerExceptionData.class.getDeclaredField("mErrorCode")));
                    builder.b("error_msg", FbJsonField.jsonField(ServerExceptionData.class.getDeclaredField("mErrorMsg")));
                    builder.b("error_data", FbJsonField.jsonField(ServerExceptionData.class.getDeclaredField("mErrorData")));
                    f935a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f935a;
        }
        return map;
    }

    public final FbJsonField m985a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m984e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m984e().keySet());
    }
}
