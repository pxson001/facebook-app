package com.facebook.platform.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.ipc.model.FacebookProfile;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: review_needy_place_card */
public class PlatformCompositionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4231a;

    static {
        GlobalAutoGenDeserializerCache.a(PlatformComposition.class, new PlatformCompositionDeserializer());
        m4175e();
    }

    public PlatformCompositionDeserializer() {
        a(PlatformComposition.class);
    }

    private static synchronized Map<String, FbJsonField> m4175e() {
        Map<String, FbJsonField> map;
        synchronized (PlatformCompositionDeserializer.class) {
            if (f4231a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("has_user_interacted", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mHasUserInteracted")));
                    builder.b("user_id", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mUserId")));
                    builder.b("attachments", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mAttachments"), ComposerAttachment.class));
                    builder.b("target_album", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mTargetAlbum")));
                    builder.b("rating", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mRating")));
                    builder.b("text_with_entities", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mTextWithEntities")));
                    builder.b("location_info", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mLocationInfo")));
                    builder.b("minutiae_object", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mMinutiaeObject")));
                    builder.b("product_item_attachment", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mProductItemAttachment")));
                    builder.b("marketplace_id", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mMarketplaceId")));
                    builder.b("user_selected_tags", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mUserSelectedTags")));
                    builder.b("posting_to_redspace", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mRedSpaceValue")));
                    builder.b("publish_mode", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mPublishMode")));
                    builder.b("schedule_time", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mScheduleTime")));
                    builder.b("tagged_profiles", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mTaggedProfiles"), FacebookProfile.class));
                    builder.b("removed_urls", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mRemovedURLs"), String.class));
                    builder.b("date_info", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mComposerDateInfo")));
                    builder.b("referenced_sticker_data", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mReferencedStickerData")));
                    builder.b("share_params", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mShareParams")));
                    builder.b("is_backout_draft", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mIsBackoutDraft")));
                    builder.b("app_attribution", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mAppAttribution")));
                    builder.b("topic_feeds", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mTopicIds"), String.class));
                    builder.b("app_provided_hashtag", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mAppProvidedHashtag")));
                    builder.b("user_deleted_app_provided_hashtag", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mUserDeletedAppProvidedHashtag")));
                    builder.b("is_feed_only_post", FbJsonField.jsonField(PlatformComposition.class.getDeclaredField("mIsFeedOnlyPost")));
                    f4231a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4231a;
        }
        return map;
    }

    public final FbJsonField m4176a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4175e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4175e().keySet());
    }
}
