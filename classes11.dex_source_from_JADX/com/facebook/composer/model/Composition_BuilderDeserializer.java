package com.facebook.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.model.Composition.Builder;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: friend_view */
public class Composition_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f6821a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new Composition_BuilderDeserializer());
        m8153e();
    }

    public Composition_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m8153e() {
        Map<String, FbJsonField> map;
        synchronized (Composition_BuilderDeserializer.class) {
            if (f6821a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("app_attribution", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAppAttribution", new Class[]{ComposerAppAttribution.class})));
                    builder.b("attachments", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAttachments", new Class[]{ImmutableList.class}), ComposerAttachment.class));
                    builder.b("composer_date_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setComposerDateInfo", new Class[]{ComposerDateInfo.class})));
                    builder.b("facecast_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setFacecastInfo", new Class[]{ComposerFacecastInfo.class})));
                    builder.b("is_backout_draft", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsBackoutDraft", new Class[]{Boolean.TYPE})));
                    builder.b("is_feed_only_post", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsFeedOnlyPost", new Class[]{Boolean.TYPE})));
                    builder.b("location_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setLocationInfo", new Class[]{ComposerLocationInfo.class})));
                    builder.b("marketplace_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setMarketplaceId", new Class[]{Long.TYPE})));
                    builder.b("minutiae_object", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setMinutiaeObject", new Class[]{MinutiaeObject.class})));
                    builder.b("page_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPageData", new Class[]{ComposerPageData.class})));
                    builder.b("predicted_topics", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPredictedTopics", new Class[]{ImmutableList.class}), GraphQLExploreFeed.class));
                    builder.b("product_item_attachment", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setProductItemAttachment", new Class[]{ProductItemAttachment.class})));
                    builder.b("publish_mode", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPublishMode", new Class[]{PublishMode.class})));
                    builder.b("rating", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setRating", new Class[]{Integer.TYPE})));
                    builder.b("red_space_value", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setRedSpaceValue", new Class[]{RedSpaceValue.class})));
                    builder.b("referenced_sticker_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setReferencedStickerData", new Class[]{ComposerStickerData.class})));
                    builder.b("removed_u_r_ls", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setRemovedURLs", new Class[]{ImmutableList.class}), String.class));
                    builder.b("schedule_time", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setScheduleTime", new Class[]{Long.class})));
                    builder.b("share_params", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setShareParams", new Class[]{ComposerShareParams.class})));
                    builder.b("slideshow_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSlideshowData", new Class[]{ComposerSlideshowData.class})));
                    builder.b("tagged_users", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setTaggedUsers", new Class[]{ImmutableList.class}), ComposerTaggedUser.class));
                    builder.b("target_album", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setTargetAlbum", new Class[]{GraphQLAlbum.class})));
                    builder.b("text_with_entities", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setTextWithEntities", new Class[]{GraphQLTextWithEntities.class})));
                    builder.b("topics", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setTopics", new Class[]{ImmutableList.class}), GraphQLExploreFeed.class));
                    builder.b("user_selected_tags", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setUserSelectedTags", new Class[]{Boolean.TYPE})));
                    f6821a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f6821a;
        }
        return map;
    }

    public final FbJsonField m8154a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8153e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8153e().keySet());
    }
}
