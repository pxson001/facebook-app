package com.facebook.ipc.friendsharing.listeningto;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unknown linear layout attribute =  */
public class ListeningToComposerPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1145a;

    static {
        GlobalAutoGenDeserializerCache.a(ListeningToComposerPluginConfig.class, new ListeningToComposerPluginConfigDeserializer());
        m1379e();
    }

    public ListeningToComposerPluginConfigDeserializer() {
        a(ListeningToComposerPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m1379e() {
        Map<String, FbJsonField> map;
        synchronized (ListeningToComposerPluginConfigDeserializer.class) {
            if (f1145a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("artist_name", FbJsonField.jsonField(ListeningToComposerPluginConfig.class.getDeclaredField("mArtistName")));
                    builder.b("track_name", FbJsonField.jsonField(ListeningToComposerPluginConfig.class.getDeclaredField("mTrackName")));
                    builder.b("composer_session_id", FbJsonField.jsonField(ListeningToComposerPluginConfig.class.getDeclaredField("mComposerSessionId")));
                    f1145a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1145a;
        }
        return map;
    }

    public final FbJsonField m1380a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1379e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1379e().keySet());
    }
}
