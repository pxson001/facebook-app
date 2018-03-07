package com.facebook.productionprompts.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: startDate */
public class ProductionPromptSerializer extends JsonSerializer<ProductionPrompt> {
    public final void m6331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductionPrompt productionPrompt = (ProductionPrompt) obj;
        if (productionPrompt == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m6330b(productionPrompt, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ProductionPrompt.class, new ProductionPromptSerializer());
    }

    private static void m6330b(ProductionPrompt productionPrompt, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", productionPrompt.mPromptId);
        AutoGenJsonHelper.a(jsonGenerator, "title", productionPrompt.mPromptTitle);
        AutoGenJsonHelper.a(jsonGenerator, "banner_text", productionPrompt.mBannerText);
        AutoGenJsonHelper.a(jsonGenerator, "banner_subheader", productionPrompt.mBannerSubheader);
        AutoGenJsonHelper.a(jsonGenerator, "image_uri", productionPrompt.mPromptImageUri);
        AutoGenJsonHelper.a(jsonGenerator, "start_time", Long.valueOf(productionPrompt.mStartTime));
        AutoGenJsonHelper.a(jsonGenerator, "end_time", Long.valueOf(productionPrompt.mEndTime));
        AutoGenJsonHelper.a(jsonGenerator, "composer_prompt_text", productionPrompt.mComposerPromptText);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "minutiae_object", productionPrompt.mMinutiaeObject);
        AutoGenJsonHelper.a(jsonGenerator, "link_attachment_url", productionPrompt.mLinkAttachmentUrl);
        AutoGenJsonHelper.a(jsonGenerator, "dismiss_survey_id", productionPrompt.mDismissSurveyId);
        AutoGenJsonHelper.a(jsonGenerator, "ignore_survey_id", productionPrompt.mIgnoreSurveyId);
        AutoGenJsonHelper.a(jsonGenerator, "post_with_minutiae_survey_id", productionPrompt.mPostWithMinutiaeSurveyId);
        AutoGenJsonHelper.a(jsonGenerator, "checkin_location_id", productionPrompt.mCheckinLocationId);
        AutoGenJsonHelper.a(jsonGenerator, "checkin_location_name", productionPrompt.mCheckinLocationName);
        AutoGenJsonHelper.a(jsonGenerator, "prompt_type", productionPrompt.mPromptType);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "profile_picture_overlay", productionPrompt.mProfilePictureOverlay);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "frame_pack_model", productionPrompt.mFramePackModel);
        AutoGenJsonHelper.a(jsonGenerator, "server_ranking_score", Double.valueOf(productionPrompt.mServerRankingScore));
        AutoGenJsonHelper.a(jsonGenerator, "server_tracking_string", productionPrompt.mServerTrackingString);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "prompt_display_reason", productionPrompt.mPromptDisplayReason);
        AutoGenJsonHelper.a(jsonGenerator, "prompt_confidence", productionPrompt.mPromptConfidence);
        AutoGenJsonHelper.a(jsonGenerator, "cta_text", productionPrompt.mCallToActionText);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "meme_urls", productionPrompt.mMemeUrls);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "suggested_cover_photos", productionPrompt.mSuggestedCoverPhotos);
    }
}
