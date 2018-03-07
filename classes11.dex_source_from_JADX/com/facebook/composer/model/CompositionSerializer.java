package com.facebook.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendsPromote */
public class CompositionSerializer extends JsonSerializer<Composition> {
    public final void m8152a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Composition composition = (Composition) obj;
        if (composition == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8151b(composition, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(Composition.class, new CompositionSerializer());
    }

    private static void m8151b(Composition composition, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "app_attribution", composition.getAppAttribution());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "attachments", composition.getAttachments());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "composer_date_info", composition.getComposerDateInfo());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "facecast_info", composition.getFacecastInfo());
        AutoGenJsonHelper.a(jsonGenerator, "is_backout_draft", Boolean.valueOf(composition.isBackoutDraft()));
        AutoGenJsonHelper.a(jsonGenerator, "is_feed_only_post", Boolean.valueOf(composition.isFeedOnlyPost()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "location_info", composition.getLocationInfo());
        AutoGenJsonHelper.a(jsonGenerator, "marketplace_id", Long.valueOf(composition.getMarketplaceId()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "minutiae_object", composition.getMinutiaeObject());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "page_data", composition.getPageData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "predicted_topics", composition.getPredictedTopics());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "product_item_attachment", composition.getProductItemAttachment());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "publish_mode", composition.getPublishMode());
        AutoGenJsonHelper.a(jsonGenerator, "rating", Integer.valueOf(composition.getRating()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "red_space_value", composition.getRedSpaceValue());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "referenced_sticker_data", composition.getReferencedStickerData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "removed_u_r_ls", composition.getRemovedURLs());
        AutoGenJsonHelper.a(jsonGenerator, "schedule_time", composition.getScheduleTime());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "share_params", composition.getShareParams());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "slideshow_data", composition.getSlideshowData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tagged_users", composition.getTaggedUsers());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "target_album", composition.getTargetAlbum());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "text_with_entities", composition.getTextWithEntities());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "topics", composition.getTopics());
        AutoGenJsonHelper.a(jsonGenerator, "user_selected_tags", Boolean.valueOf(composition.isUserSelectedTags()));
    }
}
