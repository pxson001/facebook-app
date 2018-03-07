package com.facebook.auth.credentials;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: preview_size */
public class DBLFacebookCredentialsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4243a;

    static {
        GlobalAutoGenDeserializerCache.a(DBLFacebookCredentials.class, new DBLFacebookCredentialsDeserializer());
        m4773e();
    }

    public DBLFacebookCredentialsDeserializer() {
        a(DBLFacebookCredentials.class);
    }

    private static synchronized Map<String, FbJsonField> m4773e() {
        Map<String, FbJsonField> map;
        synchronized (DBLFacebookCredentialsDeserializer.class) {
            if (f4243a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("uid", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mUserId")));
                    builder.b("time", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mTime")));
                    builder.b("name", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mName")));
                    builder.b("username", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mUsername")));
                    builder.b("pic_url", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mPicUrl")));
                    builder.b("nonce", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mNonce")));
                    builder.b("is_pin_set", FbJsonField.jsonField(DBLFacebookCredentials.class.getDeclaredField("mIsPinSet")));
                    f4243a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4243a;
        }
        return map;
    }

    public final FbJsonField m4774a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4773e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4773e().keySet());
    }
}
