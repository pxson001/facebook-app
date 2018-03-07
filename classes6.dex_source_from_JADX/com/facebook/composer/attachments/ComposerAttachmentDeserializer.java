package com.facebook.composer.attachments;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: place_picker_first_scroll */
public class ComposerAttachmentDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7808a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerAttachment.class, new ComposerAttachmentDeserializer());
        m11234e();
    }

    public ComposerAttachmentDeserializer() {
        a(ComposerAttachment.class);
    }

    private static synchronized Map<String, FbJsonField> m11234e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerAttachmentDeserializer.class) {
            if (f7808a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("serialized_media_item", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mSerializedMediaItemInternal")));
                    builder.b("uri", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mUri")));
                    builder.b("caption", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mCaption")));
                    builder.b("creative_editing_data", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mCreativeEditingData")));
                    builder.b("video_creative_editing_data", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mVideoCreativeEditingData")));
                    builder.b("video_tagging_info", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mVideoTaggingInfo")));
                    builder.b("id", FbJsonField.jsonField(ComposerAttachment.class.getDeclaredField("mId")));
                    f7808a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7808a;
        }
        return map;
    }

    public final FbJsonField m11235a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11234e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11234e().keySet());
    }
}
