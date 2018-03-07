package com.facebook.placetips.bootstrap;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: search_results_source */
public class PresenceDescriptionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3822a;

    static {
        GlobalAutoGenDeserializerCache.a(PresenceDescription.class, new PresenceDescriptionDeserializer());
        m3704e();
    }

    public PresenceDescriptionDeserializer() {
        a(PresenceDescription.class);
    }

    private static synchronized Map<String, FbJsonField> m3704e() {
        Map<String, FbJsonField> map;
        synchronized (PresenceDescriptionDeserializer.class) {
            if (f3822a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("page_id", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mPageId")));
                    builder.b("page_name", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mPageName")));
                    builder.b("presence_acquired_at", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mPresenceAcquiredAt")));
                    builder.b("presence_last_seen_at", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mPulsarLastSeenAt")));
                    builder.b("feed_unit_header_styled", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mFeedUnitHeaderStyled")));
                    builder.b("feed_unit_subtitle_styled", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mFeedUnitSubtitleStyled")));
                    builder.b("feed_unit_show_suggestifier_footer", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mFeedUnitShowSuggestifierFooter")));
                    builder.b("suggestifier_footer_question", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mSuggestifierFooterQuestion")));
                    builder.b("suggestifier_footer_description", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mSuggestifierFooterDescription")));
                    builder.b("suggestifier_footer_thank_you_text", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mSuggestifierFooterThankYouText")));
                    builder.b("presence_source", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mSource")));
                    builder.b("place_tip_welcome_header", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mPlaceTipWelcomeHeader")));
                    builder.b("reaction_stories", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mReactionStories")));
                    builder.b("suggestifier_response_id", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mSuggestifierResponseId")));
                    builder.b("existing_reaction_session_id", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mExistingReactionSessionId")));
                    builder.b("confidence_level", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mConfidenceLevel")));
                    builder.b("page_categories", FbJsonField.jsonField(PresenceDescription.class.getDeclaredField("mPageCategoryNames"), String.class));
                    f3822a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3822a;
        }
        return map;
    }

    public final FbJsonField m3705a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3704e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3704e().keySet());
    }
}
