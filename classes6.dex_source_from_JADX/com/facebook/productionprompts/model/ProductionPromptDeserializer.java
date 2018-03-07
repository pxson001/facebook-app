package com.facebook.productionprompts.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: startDownload */
public class ProductionPromptDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4258a;

    static {
        GlobalAutoGenDeserializerCache.a(ProductionPrompt.class, new ProductionPromptDeserializer());
        m6328e();
    }

    public ProductionPromptDeserializer() {
        a(ProductionPrompt.class);
    }

    private static synchronized Map<String, FbJsonField> m6328e() {
        Map<String, FbJsonField> map;
        synchronized (ProductionPromptDeserializer.class) {
            if (f4258a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPromptId")));
                    builder.b("title", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPromptTitle")));
                    builder.b("banner_text", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mBannerText")));
                    builder.b("banner_subheader", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mBannerSubheader")));
                    builder.b("image_uri", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPromptImageUri")));
                    builder.b("start_time", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mStartTime")));
                    builder.b("end_time", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mEndTime")));
                    builder.b("composer_prompt_text", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mComposerPromptText")));
                    builder.b("minutiae_object", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mMinutiaeObject")));
                    builder.b("link_attachment_url", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mLinkAttachmentUrl")));
                    builder.b("dismiss_survey_id", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mDismissSurveyId")));
                    builder.b("ignore_survey_id", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mIgnoreSurveyId")));
                    builder.b("post_with_minutiae_survey_id", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPostWithMinutiaeSurveyId")));
                    builder.b("checkin_location_id", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mCheckinLocationId")));
                    builder.b("checkin_location_name", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mCheckinLocationName")));
                    builder.b("prompt_type", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPromptType")));
                    builder.b("profile_picture_overlay", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mProfilePictureOverlay")));
                    builder.b("frame_pack_model", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mFramePackModel")));
                    builder.b("server_ranking_score", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mServerRankingScore")));
                    builder.b("server_tracking_string", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mServerTrackingString")));
                    builder.b("prompt_display_reason", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPromptDisplayReason")));
                    builder.b("prompt_confidence", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mPromptConfidence")));
                    builder.b("cta_text", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mCallToActionText")));
                    builder.b("meme_urls", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mMemeUrls"), String.class));
                    builder.b("suggested_cover_photos", FbJsonField.jsonField(ProductionPrompt.class.getDeclaredField("mSuggestedCoverPhotos"), String.class));
                    f4258a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4258a;
        }
        return map;
    }

    public final FbJsonField m6329a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6328e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6328e().keySet());
    }
}
