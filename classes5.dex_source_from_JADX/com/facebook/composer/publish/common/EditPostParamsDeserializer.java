package com.facebook.composer.publish.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: addComponentDebugInfo */
public class EditPostParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11503a;

    static {
        GlobalAutoGenDeserializerCache.a(EditPostParams.class, new EditPostParamsDeserializer());
        m19649e();
    }

    public EditPostParamsDeserializer() {
        a(EditPostParams.class);
    }

    private static synchronized Map<String, FbJsonField> m19649e() {
        Map<String, FbJsonField> map;
        synchronized (EditPostParamsDeserializer.class) {
            if (f11503a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("composer_session_id", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("composerSessionId")));
                    builder.b("legacy_story_api_id", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("legacyStoryApiId")));
                    builder.b("message", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("message")));
                    builder.b("story_id", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("storyId")));
                    builder.b("cache_ids", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("cacheIds"), String.class));
                    builder.b("minutiae_tag", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("minutiaeTag")));
                    builder.b("tagged_ids", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("taggedIds"), Long.class));
                    builder.b("place_tag", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("placeTag")));
                    builder.b("privacy", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("privacy")));
                    builder.b("product_item_attachment", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("productItemAttachment")));
                    builder.b("should_publish_unpublished_content", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("shouldPublishUnpublishedContent")));
                    builder.b("original_post_time", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("originalPostTime")));
                    builder.b("media_fbids", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("mediaFbIds"), String.class));
                    builder.b("has_media_fbids", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("hasMediaFbIds")));
                    builder.b("target_id", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("targetId")));
                    builder.b("is_photo_container", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("isPhotoContainer")));
                    builder.b("media_captions", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("mediaCaptions"), String.class));
                    builder.b("last_error_details", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("lastErrorDetails")));
                    builder.b("link_edit", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("linkEdit")));
                    builder.b("topic_feeds", FbJsonField.jsonField(EditPostParams.class.getDeclaredField("topics"), GraphQLExploreFeed.class));
                    f11503a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11503a;
        }
        return map;
    }

    public final FbJsonField m19650a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19649e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19649e().keySet());
    }
}
