package com.facebook.ipc.slideshow;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.slideshow.SlideshowEditConfiguration.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unhandled view =  */
public class SlideshowEditConfiguration_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1182a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new SlideshowEditConfiguration_BuilderDeserializer());
        m1398e();
    }

    public SlideshowEditConfiguration_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m1398e() {
        Map<String, FbJsonField> map;
        synchronized (SlideshowEditConfiguration_BuilderDeserializer.class) {
            if (f1182a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("action_when_done", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setActionWhenDone", new Class[]{SlideshowEditConfigurationSpec$Action.class})));
                    builder.b("composer_configuration", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setComposerConfiguration", new Class[]{ComposerConfiguration.class})));
                    builder.b("media_items", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setMediaItems", new Class[]{ImmutableList.class}), MediaItem.class));
                    builder.b("session_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSessionId", new Class[]{String.class})));
                    builder.b("slideshow_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSlideshowData", new Class[]{ComposerSlideshowData.class})));
                    builder.b("source", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSource", new Class[]{SlideshowEditConfigurationSpec$Source.class})));
                    f1182a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1182a;
        }
        return map;
    }

    public final FbJsonField m1399a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1398e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1398e().keySet());
    }
}
