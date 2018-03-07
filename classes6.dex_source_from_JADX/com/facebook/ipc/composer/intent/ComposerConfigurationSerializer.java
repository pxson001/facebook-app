package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: local query cache */
public class ComposerConfigurationSerializer extends JsonSerializer<ComposerConfiguration> {
    public final void m18228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerConfiguration composerConfiguration = (ComposerConfiguration) obj;
        if (composerConfiguration == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18227b(composerConfiguration, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerConfiguration.class, new ComposerConfigurationSerializer());
    }

    private static void m18227b(ComposerConfiguration composerConfiguration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "allow_dynamic_text_style", Boolean.valueOf(composerConfiguration.getAllowDynamicTextStyle()));
        AutoGenJsonHelper.a(jsonGenerator, "allow_feed_only_post", Boolean.valueOf(composerConfiguration.getAllowFeedOnlyPost()));
        AutoGenJsonHelper.a(jsonGenerator, "allow_target_selection", Boolean.valueOf(composerConfiguration.getAllowTargetSelection()));
        AutoGenJsonHelper.a(jsonGenerator, "allows_red_space_toggle", Boolean.valueOf(composerConfiguration.getAllowsRedSpaceToggle()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "attached_story", composerConfiguration.getAttachedStory());
        AutoGenJsonHelper.a(jsonGenerator, "cache_id", composerConfiguration.getCacheId());
        AutoGenJsonHelper.a(jsonGenerator, "can_viewer_edit_post_media", Boolean.valueOf(composerConfiguration.canViewerEditPostMedia()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "commerce_info", composerConfiguration.getCommerceInfo());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "composer_type", composerConfiguration.getComposerType());
        AutoGenJsonHelper.a(jsonGenerator, "disable_attach_to_album", Boolean.valueOf(composerConfiguration.shouldDisableAttachToAlbum()));
        AutoGenJsonHelper.a(jsonGenerator, "disable_friend_tagging", Boolean.valueOf(composerConfiguration.shouldDisableFriendTagging()));
        AutoGenJsonHelper.a(jsonGenerator, "disable_mentions", Boolean.valueOf(composerConfiguration.shouldDisableMentions()));
        AutoGenJsonHelper.a(jsonGenerator, "disable_photos", Boolean.valueOf(composerConfiguration.shouldDisablePhotos()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "edit_post_feature_capabilities", composerConfiguration.getEditPostFeatureCapabilities());
        AutoGenJsonHelper.a(jsonGenerator, "external_ref_name", composerConfiguration.getExternalRefName());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "group_commerce_categories", composerConfiguration.getGroupCommerceCategories());
        AutoGenJsonHelper.a(jsonGenerator, "hide_keyboard_if_reached_minimum_height", Boolean.valueOf(composerConfiguration.shouldHideKeyboardIfReachedMinimumHeight()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_app_attribution", composerConfiguration.getInitialAppAttribution());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_attachments", composerConfiguration.getInitialAttachments());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_date_info", composerConfiguration.getInitialDateInfo());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_facecast_info", composerConfiguration.getInitialFacecastInfo());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_location_info", composerConfiguration.getInitialLocationInfo());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_page_data", composerConfiguration.getInitialPageData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_privacy_override", composerConfiguration.getInitialPrivacyOverride());
        AutoGenJsonHelper.a(jsonGenerator, "initial_rating", Integer.valueOf(composerConfiguration.getInitialRating()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_red_space_value", composerConfiguration.getInitialRedSpaceValue());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_share_params", composerConfiguration.getInitialShareParams());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_slideshow_data", composerConfiguration.getInitialSlideshowData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_sticker_data", composerConfiguration.getInitialStickerData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_tagged_users", composerConfiguration.getInitialTaggedUsers());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_target_album", composerConfiguration.getInitialTargetAlbum());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_target_data", composerConfiguration.getInitialTargetData());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "initial_text", composerConfiguration.getInitialText());
        AutoGenJsonHelper.a(jsonGenerator, "is_edit", Boolean.valueOf(composerConfiguration.isEdit()));
        AutoGenJsonHelper.a(jsonGenerator, "is_edit_privacy_enabled", Boolean.valueOf(composerConfiguration.isEditPrivacyEnabled()));
        AutoGenJsonHelper.a(jsonGenerator, "is_edit_tag_enabled", Boolean.valueOf(composerConfiguration.isEditTagEnabled()));
        AutoGenJsonHelper.a(jsonGenerator, "is_fire_and_forget", Boolean.valueOf(composerConfiguration.isFireAndForget()));
        AutoGenJsonHelper.a(jsonGenerator, "is_throwback_post", Boolean.valueOf(composerConfiguration.isThrowbackPost()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "launch_logging_params", composerConfiguration.getLaunchLoggingParams());
        AutoGenJsonHelper.a(jsonGenerator, "legacy_api_story_id", composerConfiguration.getLegacyApiStoryId());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "minutiae_object_tag", composerConfiguration.getMinutiaeObjectTag());
        AutoGenJsonHelper.a(jsonGenerator, "nectar_module", composerConfiguration.getNectarModule());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "og_mechanism", composerConfiguration.getOgMechanism());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "og_surface", composerConfiguration.getOgSurface());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "platform_configuration", composerConfiguration.getPlatformConfiguration());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "plugin_config", composerConfiguration.getPluginConfig());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "product_item_attachment", composerConfiguration.getProductItemAttachment());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "reaction_surface", composerConfiguration.getReactionSurface());
        AutoGenJsonHelper.a(jsonGenerator, "reaction_unit_id", composerConfiguration.getReactionUnitId());
        AutoGenJsonHelper.a(jsonGenerator, "should_picker_support_live_camera", Boolean.valueOf(composerConfiguration.getShouldPickerSupportLiveCamera()));
        AutoGenJsonHelper.a(jsonGenerator, "should_post_to_marketplace_by_default", Boolean.valueOf(composerConfiguration.shouldPostToMarketplaceByDefault()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "source_type", composerConfiguration.getSourceType());
        AutoGenJsonHelper.a(jsonGenerator, "story_id", composerConfiguration.getStoryId());
        AutoGenJsonHelper.a(jsonGenerator, "topic_feed_id", composerConfiguration.getTopicFeedId());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "topics", composerConfiguration.getTopics());
        AutoGenJsonHelper.a(jsonGenerator, "use_optimistic_posting", Boolean.valueOf(composerConfiguration.shouldUseOptimisticPosting()));
    }
}
