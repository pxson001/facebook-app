package com.facebook.auth.viewercontext;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@DoNotStrip
/* compiled from: suggested_content */
public class ViewerContextDeserializer extends FbJsonDeserializer {
    public static final Map<String, FbJsonField> f2405a;

    static {
        GlobalAutoGenDeserializerCache.a(ViewerContext.class, new ViewerContextDeserializer());
        try {
            Map c = Maps.c();
            c.put("user_id", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mUserId")));
            c.put("auth_token", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mAuthToken")));
            c.put("session_cookies_string", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mSessionCookiesString")));
            c.put("is_page_context", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mIsPageContext")));
            c.put("session_secret", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mSessionSecret")));
            c.put("session_key", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mSessionKey")));
            c.put("username", FbJsonField.jsonField(ViewerContext.class.getDeclaredField("mUsername")));
            f2405a = Collections.unmodifiableMap(c);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    public final FbJsonField m3308a(String str) {
        FbJsonField fbJsonField = (FbJsonField) f2405a.get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        Set<String> a = Sets.a();
        a.addAll(f2405a.keySet());
        Collection collection = null;
        if (collection != null) {
            a.addAll(collection);
        }
        return a;
    }

    public ViewerContextDeserializer() {
        a(ViewerContext.class);
    }
}
