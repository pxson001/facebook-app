package com.facebook.productionprompts.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: starred */
public class ProfilePictureOverlayDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4259a;

    static {
        GlobalAutoGenDeserializerCache.a(ProfilePictureOverlay.class, new ProfilePictureOverlayDeserializer());
        m6335e();
    }

    public ProfilePictureOverlayDeserializer() {
        a(ProfilePictureOverlay.class);
    }

    private static synchronized Map<String, FbJsonField> m6335e() {
        Map<String, FbJsonField> map;
        synchronized (ProfilePictureOverlayDeserializer.class) {
            if (f4259a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("image_overlay_id", FbJsonField.jsonField(ProfilePictureOverlay.class.getDeclaredField("mImageOverlayId")));
                    builder.b("image_overlay_url", FbJsonField.jsonField(ProfilePictureOverlay.class.getDeclaredField("mImageOverlayUrl")));
                    f4259a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4259a;
        }
        return map;
    }

    public final FbJsonField m6336a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6335e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6335e().keySet());
    }
}
