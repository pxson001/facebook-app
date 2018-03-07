package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: live_video */
public class ComposerShareParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11565a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerShareParams.class, new ComposerShareParamsDeserializer());
        m18250e();
    }

    public ComposerShareParamsDeserializer() {
        a(ComposerShareParams.class);
    }

    private static synchronized Map<String, FbJsonField> m18250e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerShareParamsDeserializer.class) {
            if (f11565a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("share_preview", FbJsonField.jsonField(ComposerShareParams.class.getDeclaredField("sharePreview")));
                    builder.b("shareable", FbJsonField.jsonField(ComposerShareParams.class.getDeclaredField("shareable")));
                    builder.b("link_for_share", FbJsonField.jsonField(ComposerShareParams.class.getDeclaredField("linkForShare")));
                    builder.b("share_tracking", FbJsonField.jsonField(ComposerShareParams.class.getDeclaredField("shareTracking")));
                    builder.b("quote_text", FbJsonField.jsonField(ComposerShareParams.class.getDeclaredField("quoteText")));
                    builder.b("include_reshare_context", FbJsonField.jsonField(ComposerShareParams.class.getDeclaredField("includeReshareContext")));
                    f11565a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11565a;
        }
        return map;
    }

    public final FbJsonField m18251a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18250e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18250e().keySet());
    }
}
