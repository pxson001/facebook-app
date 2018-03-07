package com.facebook.composer.publish.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.Clock;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.ipc.composer.model.CheckinEntryPoint;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_preprocessed_batch */
public class PublishHelper {
    public static final ImmutableList<String> f8063a = ImmutableList.of("2");

    public static List<NameValuePair> m11651a(PublishPostParams publishPostParams, Clock clock, FbObjectMapper fbObjectMapper) {
        Preconditions.checkArgument(publishPostParams.targetId > 0);
        List a = Lists.a();
        if (publishPostParams.targetId == publishPostParams.userId) {
            Preconditions.checkNotNull(publishPostParams.privacy);
            a.add(new BasicNameValuePair("privacy", publishPostParams.privacy));
        }
        if (publishPostParams.composerSessionLoggingData != null) {
            a.add(new BasicNameValuePair("composer_session_events_log", fbObjectMapper.a(publishPostParams.composerSessionLoggingData)));
        }
        if (!StringUtil.a(publishPostParams.link)) {
            a.add(new BasicNameValuePair("link", publishPostParams.link));
        }
        if (!StringUtil.a(publishPostParams.quote)) {
            a.add(new BasicNameValuePair("quote", publishPostParams.quote));
        }
        if (!StringUtil.a(publishPostParams.title)) {
            a.add(new BasicNameValuePair("title", publishPostParams.title));
            if (!(StringUtil.a(publishPostParams.souvenir) || StringUtil.a(publishPostParams.rawMessage))) {
                a.add(new BasicNameValuePair("message", publishPostParams.rawMessage));
            }
        } else if (!StringUtil.a(publishPostParams.rawMessage)) {
            a.add(new BasicNameValuePair("message", publishPostParams.rawMessage));
        } else if (!(publishPostParams.mProductItemAttachment == null || StringUtil.a(publishPostParams.mProductItemAttachment.description))) {
            a.add(new BasicNameValuePair("message", publishPostParams.mProductItemAttachment.description));
        }
        if (!StringUtil.a(publishPostParams.placeTag)) {
            a.add(new BasicNameValuePair("place", publishPostParams.placeTag));
        }
        if (!StringUtil.a(publishPostParams.nectarModule)) {
            a.add(new BasicNameValuePair("nectar_module", publishPostParams.nectarModule));
        }
        if (!(publishPostParams.taggedIds == null || publishPostParams.taggedIds.isEmpty())) {
            a.add(new BasicNameValuePair("tags", m11650a(Sets.b(publishPostParams.taggedIds))));
        }
        if (publishPostParams.publishMode != PublishMode.NORMAL) {
            a.add(new BasicNameValuePair("published", Boolean.FALSE.toString()));
            a.add(new BasicNameValuePair("unpublished_content_type", publishPostParams.publishMode.getContentType()));
        }
        if (publishPostParams.redSpaceValue == RedSpaceValue.POST_TO_REDSPACE) {
            a.add(new BasicNameValuePair("posting_to_redspace", publishPostParams.redSpaceValue.toApiString()));
        }
        if (!StringUtil.a(publishPostParams.composerSessionId)) {
            a.add(new BasicNameValuePair("composer_session_id", publishPostParams.composerSessionId));
            a.add(new BasicNameValuePair("qn", publishPostParams.composerSessionId));
        }
        if (!StringUtil.a(publishPostParams.idempotenceToken)) {
            a.add(new BasicNameValuePair("idempotence_token", publishPostParams.idempotenceToken));
        }
        if (publishPostParams.schedulePublishTime != 0) {
            a.add(new BasicNameValuePair("scheduled_publish_time", String.valueOf(publishPostParams.schedulePublishTime)));
        }
        if (publishPostParams.isTagsUserSelected) {
            a.add(new BasicNameValuePair("user_selected_tags", String.valueOf(publishPostParams.isTagsUserSelected)));
        }
        if (publishPostParams.ref != null) {
            a.add(new BasicNameValuePair("ref", publishPostParams.ref));
        }
        if (publishPostParams.proxiedAppId != null) {
            a.add(new BasicNameValuePair("proxied_app_id", publishPostParams.proxiedAppId));
        }
        if (publishPostParams.proxiedAppName != null) {
            a.add(new BasicNameValuePair("proxied_app_name", publishPostParams.proxiedAppName));
        }
        if (publishPostParams.androidKeyHash != null) {
            a.add(new BasicNameValuePair("android_key_hash", publishPostParams.androidKeyHash));
        }
        if (publishPostParams.ogActionTypeId != null) {
            a.add(new BasicNameValuePair("og_action_type_id", publishPostParams.ogActionTypeId));
        }
        if (publishPostParams.ogObjectId != null) {
            a.add(new BasicNameValuePair("og_object_id", publishPostParams.ogObjectId));
        }
        if (publishPostParams.ogPhrase != null) {
            a.add(new BasicNameValuePair("og_phrase", publishPostParams.ogPhrase));
        }
        if (publishPostParams.ogIconId != null) {
            a.add(new BasicNameValuePair("og_icon_id", publishPostParams.ogIconId));
        }
        if (publishPostParams.ogSuggestionMechansim != null) {
            a.add(new BasicNameValuePair("og_suggestion_mechanism", publishPostParams.ogSuggestionMechansim));
        }
        if (publishPostParams.ogHideObjectAttachment) {
            a.add(new BasicNameValuePair("og_hide_object_attachment", "true"));
        }
        a.add(new BasicNameValuePair("audience_exp", Boolean.TRUE.toString()));
        if (publishPostParams.isExplicitLocation) {
            a.add(new BasicNameValuePair("is_explicit_location", Boolean.TRUE.toString()));
            a.add(new BasicNameValuePair("user_selected_place", Boolean.TRUE.toString()));
        }
        if (publishPostParams.originalPostTime != 0) {
            a.add(new BasicNameValuePair("time_since_original_post", String.valueOf(Math.max((clock.a() / 1000) - publishPostParams.originalPostTime, 0))));
        }
        a.add(new BasicNameValuePair("attach_place_suggestion", String.valueOf(publishPostParams.b)));
        if (publishPostParams.c != null) {
            ObjectNode c = JsonNodeFactory.a.c();
            c.a("latitude", publishPostParams.c.latitude);
            c.a("longitude", publishPostParams.c.longitude);
            c.a("accuracy", publishPostParams.c.accuracy);
            a.add(new BasicNameValuePair("viewer_coordinates", c.toString()));
        }
        if (publishPostParams.mProductItemAttachment != null) {
            a.add(new BasicNameValuePair("product_item", fbObjectMapper.a(publishPostParams.mProductItemAttachment)));
        }
        if (publishPostParams.mMarketplaceId != 0) {
            a.add(new BasicNameValuePair("marketplace_id", String.valueOf(publishPostParams.mMarketplaceId)));
        }
        a.add(new BasicNameValuePair("format", "json"));
        if (!Strings.isNullOrEmpty(publishPostParams.connectionClass)) {
            a.add(new BasicNameValuePair("connection_class", publishPostParams.connectionClass));
        }
        if (!Strings.isNullOrEmpty(publishPostParams.textOnlyPlace)) {
            a.add(new BasicNameValuePair("text_only_place", publishPostParams.textOnlyPlace));
        }
        if (!Strings.isNullOrEmpty(publishPostParams.sourceType)) {
            a.add(new BasicNameValuePair("source_type", publishPostParams.sourceType));
        }
        if (!Strings.isNullOrEmpty(publishPostParams.throwbackCardJson)) {
            a.add(new BasicNameValuePair("throwback_card", publishPostParams.throwbackCardJson));
        }
        if (!Strings.isNullOrEmpty(publishPostParams.referencedStickerId)) {
            a.add(new BasicNameValuePair("referenced_sticker_id", publishPostParams.referencedStickerId));
        }
        if (publishPostParams.placeAttachmentRemoved) {
            a.add(new BasicNameValuePair("place_attachment_setting", "1"));
        }
        a.add(new BasicNameValuePair("checkin_entry_point", CheckinEntryPoint.a(publishPostParams.isCheckin)));
        if (publishPostParams.isBackoutDraft) {
            a.add(new BasicNameValuePair("is_backout_draft", Boolean.TRUE.toString()));
        }
        if (!(publishPostParams.mediaFbIds == null && publishPostParams.syncObjectUUIDs == null)) {
            a.add(new BasicNameValuePair("attached_media", m11649a(publishPostParams.mediaFbIds, publishPostParams.mediaCaptions, publishPostParams.syncObjectUUIDs)));
        }
        if (!Strings.isNullOrEmpty(publishPostParams.souvenir)) {
            a.add(new BasicNameValuePair("souvenir", publishPostParams.souvenir));
        }
        if (publishPostParams.warnAcknowledged) {
            a.add(new BasicNameValuePair("warn_ack", String.valueOf(publishPostParams.warnAcknowledged)));
        }
        if (publishPostParams.canHandleSentryWarning) {
            a.add(new BasicNameValuePair("warn_can_handle", String.valueOf(publishPostParams.canHandleSentryWarning)));
        }
        TopicFeedsPublishHelper.m11664a(publishPostParams.topicIds, a);
        if (publishPostParams.isFeedOnlyPost) {
            a.add(new BasicNameValuePair("post_surfaces_blacklist", JSONUtil.b(f8063a).toString()));
        }
        return a;
    }

    public static String m11650a(Set<Long> set) {
        return "[" + Joiner.on(',').skipNulls().join(set) + "]";
    }

    public static String m11648a(ImmutableList<String> immutableList, ImmutableList<String> immutableList2) {
        return m11649a((ImmutableList) immutableList, (ImmutableList) immutableList2, null);
    }

    private static String m11649a(ImmutableList<String> immutableList, ImmutableList<String> immutableList2, ImmutableList<String> immutableList3) {
        boolean z;
        int i = 0;
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        int size = CollectionUtil.a(immutableList) ? 0 : immutableList.size();
        int size2 = CollectionUtil.a(immutableList3) ? 0 : immutableList3.size();
        if (size + size2 == (CollectionUtil.a(immutableList2) ? 0 : immutableList2.size())) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (int i2 = 0; i2 < size2; i2++) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            String str = (String) immutableList2.get(i2);
            objectNode.a("sync_object_uuid", (String) immutableList3.get(i2));
            objectNode.a("message", str);
            objectNode.a("notify_when_processed", false);
            arrayNode.a(objectNode);
        }
        while (i < size) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            str = (String) immutableList2.get(i + size2);
            objectNode2.a("media_fbid", (String) immutableList.get(i));
            objectNode2.a("message", str);
            arrayNode.a(objectNode2);
            i++;
        }
        return arrayNode.toString();
    }
}
