package com.facebook.platform.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: review_cover_pic_size */
public class PlatformCompositionSerializer extends JsonSerializer<PlatformComposition> {
    public final void m4178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PlatformComposition platformComposition = (PlatformComposition) obj;
        if (platformComposition == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4177b(platformComposition, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PlatformComposition.class, new PlatformCompositionSerializer());
    }

    private static void m4177b(PlatformComposition platformComposition, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "has_user_interacted", Boolean.valueOf(platformComposition.mHasUserInteracted));
        AutoGenJsonHelper.a(jsonGenerator, "user_id", Long.valueOf(platformComposition.mUserId));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "attachments", platformComposition.mAttachments);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "target_album", platformComposition.mTargetAlbum);
        AutoGenJsonHelper.a(jsonGenerator, "rating", Integer.valueOf(platformComposition.mRating));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "text_with_entities", platformComposition.mTextWithEntities);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "location_info", platformComposition.mLocationInfo);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "minutiae_object", platformComposition.mMinutiaeObject);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "product_item_attachment", platformComposition.mProductItemAttachment);
        AutoGenJsonHelper.a(jsonGenerator, "marketplace_id", Long.valueOf(platformComposition.mMarketplaceId));
        AutoGenJsonHelper.a(jsonGenerator, "user_selected_tags", Boolean.valueOf(platformComposition.mUserSelectedTags));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "posting_to_redspace", platformComposition.mRedSpaceValue);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "publish_mode", platformComposition.mPublishMode);
        AutoGenJsonHelper.a(jsonGenerator, "schedule_time", platformComposition.mScheduleTime);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tagged_profiles", platformComposition.mTaggedProfiles);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "removed_urls", platformComposition.mRemovedURLs);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "date_info", platformComposition.mComposerDateInfo);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "referenced_sticker_data", platformComposition.mReferencedStickerData);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "share_params", platformComposition.mShareParams);
        AutoGenJsonHelper.a(jsonGenerator, "is_backout_draft", Boolean.valueOf(platformComposition.mIsBackoutDraft));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "app_attribution", platformComposition.mAppAttribution);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "topic_feeds", platformComposition.mTopicIds);
        AutoGenJsonHelper.a(jsonGenerator, "app_provided_hashtag", platformComposition.mAppProvidedHashtag);
        AutoGenJsonHelper.a(jsonGenerator, "user_deleted_app_provided_hashtag", Boolean.valueOf(platformComposition.mUserDeletedAppProvidedHashtag));
        AutoGenJsonHelper.a(jsonGenerator, "is_feed_only_post", Boolean.valueOf(platformComposition.mIsFeedOnlyPost));
    }
}
