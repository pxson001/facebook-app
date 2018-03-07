package com.facebook.placetips.bootstrap;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: search_results_scroll_perf */
public class PresenceDescriptionSerializer extends JsonSerializer<PresenceDescription> {
    public final void m3707a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PresenceDescription presenceDescription = (PresenceDescription) obj;
        if (presenceDescription == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3706b(presenceDescription, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PresenceDescription.class, new PresenceDescriptionSerializer());
    }

    private static void m3706b(PresenceDescription presenceDescription, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "page_id", presenceDescription.mPageId);
        AutoGenJsonHelper.a(jsonGenerator, "page_name", presenceDescription.mPageName);
        AutoGenJsonHelper.a(jsonGenerator, "presence_acquired_at", Long.valueOf(presenceDescription.mPresenceAcquiredAt));
        AutoGenJsonHelper.a(jsonGenerator, "presence_last_seen_at", Long.valueOf(presenceDescription.mPulsarLastSeenAt));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "feed_unit_header_styled", presenceDescription.mFeedUnitHeaderStyled);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "feed_unit_subtitle_styled", presenceDescription.mFeedUnitSubtitleStyled);
        AutoGenJsonHelper.a(jsonGenerator, "feed_unit_show_suggestifier_footer", Boolean.valueOf(presenceDescription.mFeedUnitShowSuggestifierFooter));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "suggestifier_footer_question", presenceDescription.mSuggestifierFooterQuestion);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "suggestifier_footer_description", presenceDescription.mSuggestifierFooterDescription);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "suggestifier_footer_thank_you_text", presenceDescription.mSuggestifierFooterThankYouText);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "presence_source", presenceDescription.mSource);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "place_tip_welcome_header", presenceDescription.mPlaceTipWelcomeHeader);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "reaction_stories", presenceDescription.mReactionStories);
        AutoGenJsonHelper.a(jsonGenerator, "suggestifier_response_id", presenceDescription.mSuggestifierResponseId);
        AutoGenJsonHelper.a(jsonGenerator, "existing_reaction_session_id", presenceDescription.mExistingReactionSessionId);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "confidence_level", presenceDescription.mConfidenceLevel);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "page_categories", presenceDescription.mPageCategoryNames);
    }
}
