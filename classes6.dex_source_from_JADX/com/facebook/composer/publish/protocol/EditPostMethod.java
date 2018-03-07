package com.facebook.composer.publish.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_reminder_more_photos */
public class EditPostMethod implements ApiMethod<EditPostParams, Void> {
    private static final Class<?> f8061a = EditPostMethod.class;
    private final FbObjectMapper f8062b;

    public static EditPostMethod m11641b(InjectorLike injectorLike) {
        return new EditPostMethod(FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m11644a(Object obj) {
        EditPostParams editPostParams = (EditPostParams) obj;
        return new ApiRequest("editPost", "POST", editPostParams.legacyStoryApiId, m11642b(editPostParams), ApiResponseType.JSON);
    }

    @Inject
    public EditPostMethod(FbObjectMapper fbObjectMapper) {
        this.f8062b = fbObjectMapper;
    }

    public static EditPostMethod m11640a(InjectorLike injectorLike) {
        return m11641b(injectorLike);
    }

    public final Object m11645a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }

    private List<NameValuePair> m11642b(EditPostParams editPostParams) {
        List a = Lists.a();
        a.add(new BasicNameValuePair("message", MentionsUtils.m25501a(editPostParams.message)));
        a.add(new BasicNameValuePair("format", "json"));
        if (editPostParams.taggedIds != null) {
            a.add(new BasicNameValuePair("tags", PublishHelper.m11650a(Sets.b(editPostParams.taggedIds))));
        }
        if (!StringUtil.a(editPostParams.placeTag)) {
            a.add(new BasicNameValuePair("place", editPostParams.placeTag));
        }
        if (!StringUtil.a(editPostParams.privacy)) {
            a.add(new BasicNameValuePair("privacy", editPostParams.privacy));
        }
        if (editPostParams.linkEdit != null) {
            try {
                a.add(new BasicNameValuePair("link_edit", this.f8062b.a(editPostParams.linkEdit)));
            } catch (JsonProcessingException e) {
                BLog.b(f8061a, "Link Edit JSON Serialization failed", e);
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (editPostParams.hasMediaFbIds) {
            a.add(new BasicNameValuePair("attached_media", PublishHelper.m11648a(editPostParams.mediaFbIds, editPostParams.mediaCaptions)));
        }
        try {
            if (editPostParams.productItemAttachment != null) {
                a.add(new BasicNameValuePair("product_item", this.f8062b.a(editPostParams.productItemAttachment)));
            }
            a.addAll(m11643c(editPostParams));
            if (editPostParams.shouldPublishUnpublishedContent) {
                a.add(new BasicNameValuePair("is_published", Boolean.TRUE.toString()));
            }
            if (editPostParams.topics != null) {
                Builder builder = new Builder();
                ImmutableList immutableList = editPostParams.topics;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    builder.c(((GraphQLExploreFeed) immutableList.get(i)).n());
                }
                TopicFeedsPublishHelper.m11664a(builder.b(), a);
            }
            return a;
        } catch (JsonProcessingException e2) {
            BLog.b(f8061a, "Product Item JSON Serialization failed", e2);
            e2.printStackTrace();
            throw new RuntimeException(e2);
        }
    }

    private static List<NameValuePair> m11643c(EditPostParams editPostParams) {
        List<NameValuePair> a = Lists.a();
        if (editPostParams.minutiaeTag == null) {
            return a;
        }
        MinutiaeTag minutiaeTag = editPostParams.minutiaeTag;
        a.add(new BasicNameValuePair("og_action_type_id", minutiaeTag.ogActionTypeId));
        if (minutiaeTag.equals(MinutiaeTag.b)) {
            return a;
        }
        Preconditions.checkArgument(!"0".equals(minutiaeTag.ogActionTypeId));
        if (minutiaeTag.ogObjectId != null) {
            a.add(new BasicNameValuePair("og_object_id", minutiaeTag.ogObjectId));
        }
        if (minutiaeTag.ogPhrase != null) {
            a.add(new BasicNameValuePair("og_phrase", minutiaeTag.ogPhrase));
        }
        if (minutiaeTag.ogIconId != null) {
            a.add(new BasicNameValuePair("og_icon_id", minutiaeTag.ogIconId));
        }
        if (minutiaeTag.ogSuggestionMechanism != null) {
            a.add(new BasicNameValuePair("og_suggestion_mechanism", minutiaeTag.ogSuggestionMechanism));
        }
        if (minutiaeTag.ogHideAttachment) {
            a.add(new BasicNameValuePair("og_hide_object_attachment", "true"));
        }
        return a;
    }
}
