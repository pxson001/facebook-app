package com.facebook.photos.data.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: horizontal_margin */
public class FacebookPhotoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f12965a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookPhoto.class, new FacebookPhotoDeserializer());
        m20330e();
    }

    public FacebookPhotoDeserializer() {
        a(FacebookPhoto.class);
    }

    private static synchronized Map<String, FbJsonField> m20330e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookPhotoDeserializer.class) {
            if (f12965a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("pid", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mPhotoId")));
                    builder.b("aid", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mAlbumId")));
                    builder.b("owner", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mOwner")));
                    builder.b("src", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mSrcUrl")));
                    builder.b("src_big", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mSrcUrlBig")));
                    builder.b("src_small", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mSrcUrlSmall")));
                    builder.b("src_webp", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mSrcUrlWebp")));
                    builder.b("src_big_webp", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mSrcUrlBigWebp")));
                    builder.b("src_small_webp", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mSrcUrlSmallWebp")));
                    builder.b("caption", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mCaption")));
                    builder.b("created", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mCreated")));
                    builder.b("position", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mPosition")));
                    builder.b("object_id", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mObjectId")));
                    builder.b("can_tag", FbJsonField.jsonField(FacebookPhoto.class.getDeclaredField("mCanTag")));
                    f12965a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f12965a;
        }
        return map;
    }

    public final FbJsonField m20331a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m20330e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m20330e().keySet());
    }
}
