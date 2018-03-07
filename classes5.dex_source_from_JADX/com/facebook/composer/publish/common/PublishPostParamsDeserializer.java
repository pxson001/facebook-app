package com.facebook.composer.publish.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: activity_analytics_tag */
public class PublishPostParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11590a;

    static {
        GlobalAutoGenDeserializerCache.a(PublishPostParams.class, new PublishPostParamsDeserializer());
        m19718e();
    }

    public PublishPostParamsDeserializer() {
        a(PublishPostParams.class);
    }

    private static synchronized Map<String, FbJsonField> m19718e() {
        Map<String, FbJsonField> map;
        synchronized (PublishPostParamsDeserializer.class) {
            if (f11590a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("composer_type", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("composerType")));
                    builder.b("target_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("targetId")));
                    builder.b("raw_message", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("rawMessage")));
                    builder.b("page_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("placeTag")));
                    builder.b("tagged_ids", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("taggedIds"), Long.class));
                    builder.b("album_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("albumId")));
                    builder.b("privacy", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("privacy")));
                    builder.b("composer_session_logging_data", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("composerSessionLoggingData")));
                    builder.b("link", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("link")));
                    builder.b("user_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("userId")));
                    builder.b("shareable", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("shareable")));
                    builder.b("tracking", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("tracking")));
                    builder.b("nectarModule", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("nectarModule")));
                    builder.b("schedule_publish_time", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("schedulePublishTime")));
                    builder.b("publish_mode", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("publishMode")));
                    builder.b("is_tags_user_selected", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isTagsUserSelected")));
                    builder.b("proxied_app_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("proxiedAppId")));
                    builder.b("proxied_app_name", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("proxiedAppName")));
                    builder.b("android_key_hash", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("androidKeyHash")));
                    builder.b("ref", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ref")));
                    builder.b("name", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("name")));
                    builder.b("caption", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("caption")));
                    builder.b("description", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("description")));
                    builder.b("quote", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("quote")));
                    builder.b("picture", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("picture")));
                    builder.b("is_photo_container", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isPhotoContainer")));
                    builder.b("composer_session_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("composerSessionId")));
                    builder.b("idempotence_token", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("idempotenceToken")));
                    builder.b("is_explicit_location", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isExplicitLocation")));
                    builder.b("is_checkin", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isCheckin")));
                    builder.b("posting_to_redspace", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("redSpaceValue")));
                    builder.b("text_only_place", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("textOnlyPlace")));
                    builder.b("place_attachment_removed", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("placeAttachmentRemoved")));
                    builder.b("feed_topics", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("topicIds"), String.class));
                    builder.b("original_post_time", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("originalPostTime")));
                    builder.b("og_action_type_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ogActionTypeId")));
                    builder.b("og_object_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ogObjectId")));
                    builder.b("og_phrase", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ogPhrase")));
                    builder.b("og_icon_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ogIconId")));
                    builder.b("og_suggestion_mechanism", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ogSuggestionMechansim")));
                    builder.b("og_hide_object_attachment", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("ogHideObjectAttachment")));
                    builder.b("connection_class", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("connectionClass")));
                    builder.b("promote_budget", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mBudgetData")));
                    builder.b("attempt_count", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mAttemptCount")));
                    builder.b("last_error_details", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mLastErrorDetails")));
                    builder.b("product_item", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mProductItemAttachment")));
                    builder.b("marketplace_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mMarketplaceId")));
                    builder.b("is_throwback_post", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isThrowbackPost")));
                    builder.b("reshare_original_post", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("reshareOriginalPost")));
                    builder.b("throwback_card", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("throwbackCardJson")));
                    builder.b("source_type", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("sourceType")));
                    builder.b("referenced_sticker_id", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("referencedStickerId")));
                    builder.b("is_backout_draft", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isBackoutDraft")));
                    builder.b("title", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("title")));
                    builder.b("media_fbids", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mediaFbIds"), String.class));
                    builder.b("sync_object_uuid", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("syncObjectUUIDs"), String.class));
                    builder.b("media_captions", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("mediaCaptions"), String.class));
                    builder.b("souvenir", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("souvenir")));
                    builder.b("prompt_analytics", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("promptAnalytics")));
                    builder.b("warnAcknowledged", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("warnAcknowledged")));
                    builder.b("canHandleWarning", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("canHandleSentryWarning")));
                    builder.b("posting_to_feed_only", FbJsonField.jsonField(PublishPostParams.class.getDeclaredField("isFeedOnlyPost")));
                    f11590a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11590a;
        }
        return map;
    }

    public final FbJsonField m19719a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19718e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19718e().keySet());
    }
}
