package com.facebook.composer.publish.common;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: addActivityAnalyticsInfo */
public class EditPostParamsSerializer extends JsonSerializer<EditPostParams> {
    public final void m19652a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EditPostParams editPostParams = (EditPostParams) obj;
        if (editPostParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19651b(editPostParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(EditPostParams.class, new EditPostParamsSerializer());
    }

    private static void m19651b(EditPostParams editPostParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "composer_session_id", editPostParams.composerSessionId);
        AutoGenJsonHelper.a(jsonGenerator, "legacy_story_api_id", editPostParams.legacyStoryApiId);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "message", editPostParams.message);
        AutoGenJsonHelper.a(jsonGenerator, "story_id", editPostParams.storyId);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "cache_ids", editPostParams.cacheIds);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "minutiae_tag", editPostParams.minutiaeTag);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tagged_ids", editPostParams.taggedIds);
        AutoGenJsonHelper.a(jsonGenerator, "place_tag", editPostParams.placeTag);
        AutoGenJsonHelper.a(jsonGenerator, "privacy", editPostParams.privacy);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "product_item_attachment", editPostParams.productItemAttachment);
        AutoGenJsonHelper.a(jsonGenerator, "should_publish_unpublished_content", Boolean.valueOf(editPostParams.shouldPublishUnpublishedContent));
        AutoGenJsonHelper.a(jsonGenerator, "original_post_time", Long.valueOf(editPostParams.originalPostTime));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_fbids", editPostParams.mediaFbIds);
        AutoGenJsonHelper.a(jsonGenerator, "has_media_fbids", Boolean.valueOf(editPostParams.hasMediaFbIds));
        AutoGenJsonHelper.a(jsonGenerator, "target_id", Long.valueOf(editPostParams.targetId));
        AutoGenJsonHelper.a(jsonGenerator, "is_photo_container", Boolean.valueOf(editPostParams.isPhotoContainer));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_captions", editPostParams.mediaCaptions);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "last_error_details", editPostParams.m19647a());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "link_edit", editPostParams.linkEdit);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "topic_feeds", editPostParams.topics);
    }
}
