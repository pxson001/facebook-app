package com.facebook.captcha.protocol;

import com.facebook.captcha.protocol.RequestCaptchaMethod.Result;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: is_ad_network */
public class RequestCaptchaMethod_ResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10670a;

    static {
        GlobalAutoGenDeserializerCache.a(Result.class, new RequestCaptchaMethod_ResultDeserializer());
        m12606e();
    }

    public RequestCaptchaMethod_ResultDeserializer() {
        a(Result.class);
    }

    private static synchronized Map<String, FbJsonField> m12606e() {
        Map<String, FbJsonField> map;
        synchronized (RequestCaptchaMethod_ResultDeserializer.class) {
            if (f10670a == null) {
                try {
                    f10670a = new Builder().b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10670a;
        }
        return map;
    }

    public final FbJsonField m12607a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12606e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12606e().keySet());
    }
}
