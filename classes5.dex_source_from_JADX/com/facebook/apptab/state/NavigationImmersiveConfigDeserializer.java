package com.facebook.apptab.state;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: android_feed_add_photo_button */
public class NavigationImmersiveConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10353a;

    static {
        GlobalAutoGenDeserializerCache.a(NavigationImmersiveConfig.class, new NavigationImmersiveConfigDeserializer());
        m18434e();
    }

    public NavigationImmersiveConfigDeserializer() {
        a(NavigationImmersiveConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m18434e() {
        Map<String, FbJsonField> map;
        synchronized (NavigationImmersiveConfigDeserializer.class) {
            if (f10353a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("experiment_name", FbJsonField.jsonField(NavigationImmersiveConfig.class.getDeclaredField("experimentName")));
                    builder.b("experiment_group_name", FbJsonField.jsonField(NavigationImmersiveConfig.class.getDeclaredField("experimentGroupName")));
                    builder.b("fb_logo_badge_style", FbJsonField.jsonField(NavigationImmersiveConfig.class.getDeclaredField("fbLogoBadgeStyle")));
                    builder.b("fb_logo_badge_count", FbJsonField.jsonField(NavigationImmersiveConfig.class.getDeclaredField("fbLogoBadgeCount")));
                    builder.b("button_action", FbJsonField.jsonField(NavigationImmersiveConfig.class.getDeclaredField("buttonAction")));
                    builder.b("animation_speed", FbJsonField.jsonField(NavigationImmersiveConfig.class.getDeclaredField("animationSpeed")));
                    f10353a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10353a;
        }
        return map;
    }

    public final FbJsonField m18435a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18434e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18434e().keySet());
    }
}
