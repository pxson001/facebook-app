package com.facebook.ipc.composer.intent;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.groupcommerce.model.GroupCommerceCategory;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.model.ComposerCommerceInfo;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: loan */
public class ComposerConfiguration_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11552a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerConfiguration_BuilderDeserializer());
        m18231e();
    }

    public ComposerConfiguration_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m18231e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerConfiguration_BuilderDeserializer.class) {
            if (f11552a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("allow_dynamic_text_style", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAllowDynamicTextStyle", new Class[]{Boolean.TYPE})));
                    builder.b("allow_feed_only_post", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAllowFeedOnlyPost", new Class[]{Boolean.TYPE})));
                    builder.b("allow_target_selection", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAllowTargetSelection", new Class[]{Boolean.TYPE})));
                    builder.b("allows_red_space_toggle", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAllowsRedSpaceToggle", new Class[]{Boolean.TYPE})));
                    builder.b("attached_story", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setAttachedStory", new Class[]{GraphQLStory.class})));
                    builder.b("cache_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setCacheId", new Class[]{String.class})));
                    builder.b("can_viewer_edit_post_media", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setCanViewerEditPostMedia", new Class[]{Boolean.TYPE})));
                    builder.b("commerce_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setCommerceInfo", new Class[]{ComposerCommerceInfo.class})));
                    builder.b("composer_type", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setComposerType", new Class[]{ComposerType.class})));
                    builder.b("disable_attach_to_album", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setDisableAttachToAlbum", new Class[]{Boolean.TYPE})));
                    builder.b("disable_friend_tagging", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setDisableFriendTagging", new Class[]{Boolean.TYPE})));
                    builder.b("disable_mentions", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setDisableMentions", new Class[]{Boolean.TYPE})));
                    builder.b("disable_photos", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setDisablePhotos", new Class[]{Boolean.TYPE})));
                    builder.b("edit_post_feature_capabilities", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setEditPostFeatureCapabilities", new Class[]{ImmutableList.class}), GraphQLEditPostFeatureCapability.class));
                    builder.b("external_ref_name", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setExternalRefName", new Class[]{String.class})));
                    builder.b("group_commerce_categories", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setGroupCommerceCategories", new Class[]{ImmutableList.class}), GroupCommerceCategory.class));
                    builder.b("hide_keyboard_if_reached_minimum_height", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setHideKeyboardIfReachedMinimumHeight", new Class[]{Boolean.TYPE})));
                    builder.b("initial_app_attribution", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialAppAttribution", new Class[]{ComposerAppAttribution.class})));
                    builder.b("initial_attachments", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialAttachments", new Class[]{ImmutableList.class}), ComposerAttachment.class));
                    builder.b("initial_date_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialDateInfo", new Class[]{ComposerDateInfo.class})));
                    builder.b("initial_facecast_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialFacecastInfo", new Class[]{ComposerFacecastInfo.class})));
                    builder.b("initial_location_info", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialLocationInfo", new Class[]{ComposerLocationInfo.class})));
                    builder.b("initial_page_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialPageData", new Class[]{ComposerPageData.class})));
                    builder.b("initial_privacy_override", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialPrivacyOverride", new Class[]{GraphQLPrivacyOption.class})));
                    builder.b("initial_rating", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialRating", new Class[]{Integer.TYPE})));
                    builder.b("initial_red_space_value", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialRedSpaceValue", new Class[]{RedSpaceValue.class})));
                    builder.b("initial_share_params", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialShareParams", new Class[]{ComposerShareParams.class})));
                    builder.b("initial_slideshow_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialSlideshowData", new Class[]{ComposerSlideshowData.class})));
                    builder.b("initial_sticker_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialStickerData", new Class[]{ComposerStickerData.class})));
                    builder.b("initial_tagged_users", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialTaggedUsers", new Class[]{ImmutableList.class}), ComposerTaggedUser.class));
                    builder.b("initial_target_album", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialTargetAlbum", new Class[]{GraphQLAlbum.class})));
                    builder.b("initial_target_data", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialTargetData", new Class[]{ComposerTargetData.class})));
                    builder.b("initial_text", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setInitialText", new Class[]{GraphQLTextWithEntities.class})));
                    builder.b("is_edit", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsEdit", new Class[]{Boolean.TYPE})));
                    builder.b("is_edit_privacy_enabled", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsEditPrivacyEnabled", new Class[]{Boolean.TYPE})));
                    builder.b("is_edit_tag_enabled", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsEditTagEnabled", new Class[]{Boolean.TYPE})));
                    builder.b("is_fire_and_forget", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsFireAndForget", new Class[]{Boolean.TYPE})));
                    builder.b("is_throwback_post", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setIsThrowbackPost", new Class[]{Boolean.TYPE})));
                    builder.b("launch_logging_params", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setLaunchLoggingParams", new Class[]{ComposerLaunchLoggingParams.class})));
                    builder.b("legacy_api_story_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setLegacyApiStoryId", new Class[]{String.class})));
                    builder.b("minutiae_object_tag", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setMinutiaeObjectTag", new Class[]{MinutiaeObject.class})));
                    builder.b("nectar_module", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setNectarModule", new Class[]{String.class})));
                    builder.b("og_mechanism", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setOgMechanism", new Class[]{CurationMechanism.class})));
                    builder.b("og_surface", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setOgSurface", new Class[]{CurationSurface.class})));
                    builder.b("platform_configuration", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPlatformConfiguration", new Class[]{PlatformConfiguration.class})));
                    builder.b("plugin_config", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setPluginConfig", new Class[]{SerializedComposerPluginConfig.class})));
                    builder.b("product_item_attachment", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setProductItemAttachment", new Class[]{ProductItemAttachment.class})));
                    builder.b("reaction_surface", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setReactionSurface", new Class[]{Surface.class})));
                    builder.b("reaction_unit_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setReactionUnitId", new Class[]{String.class})));
                    builder.b("should_picker_support_live_camera", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setShouldPickerSupportLiveCamera", new Class[]{Boolean.TYPE})));
                    builder.b("should_post_to_marketplace_by_default", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setShouldPostToMarketplaceByDefault", new Class[]{Boolean.TYPE})));
                    builder.b("source_type", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSourceType", new Class[]{ComposerSourceType.class})));
                    builder.b("story_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setStoryId", new Class[]{String.class})));
                    builder.b("topic_feed_id", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setTopicFeedId", new Class[]{String.class})));
                    builder.b("topics", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setTopics", new Class[]{ImmutableList.class}), GraphQLExploreFeed.class));
                    builder.b("use_optimistic_posting", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setUseOptimisticPosting", new Class[]{Boolean.TYPE})));
                    f11552a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11552a;
        }
        return map;
    }

    public final FbJsonField m18232a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18231e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18231e().keySet());
    }
}
