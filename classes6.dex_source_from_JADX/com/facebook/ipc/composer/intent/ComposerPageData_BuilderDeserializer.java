package com.facebook.ipc.composer.intent;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.intent.ComposerPageData.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: loadTopPhoto */
public class ComposerPageData_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11558a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerPageData_BuilderDeserializer());
        m18238e();
    }

    public ComposerPageData_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m18238e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerPageData_BuilderDeserializer.class) {
            if (f11558a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("is_page_verified", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsPageVerified", new Class[]{Boolean.TYPE})));
                    builder.b("post_as_page_viewer_context", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPostAsPageViewerContext", new Class[]{ViewerContext.class})));
                    f11558a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11558a;
        }
        return map;
    }

    public final FbJsonField m18239a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18238e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18238e().keySet());
    }
}
