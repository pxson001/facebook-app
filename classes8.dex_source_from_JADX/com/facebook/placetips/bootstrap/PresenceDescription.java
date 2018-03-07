package com.facebook.placetips.bootstrap;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.PlaceTipWelcomeHeaderFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipWelcomeHeaderFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PresenceDescriptionDeserializer.class)
@JsonSerialize(using = PresenceDescriptionSerializer.class)
/* compiled from: search_results_vertical */
public class PresenceDescription {
    @JsonProperty("confidence_level")
    final ConfidenceLevel mConfidenceLevel;
    @JsonProperty("existing_reaction_session_id")
    final String mExistingReactionSessionId;
    @JsonProperty("feed_unit_header_styled")
    final DefaultTextWithEntitiesLongFieldsModel mFeedUnitHeaderStyled;
    @JsonProperty("feed_unit_show_suggestifier_footer")
    boolean mFeedUnitShowSuggestifierFooter;
    @JsonProperty("feed_unit_subtitle_styled")
    final DefaultTextWithEntitiesLongFieldsModel mFeedUnitSubtitleStyled;
    @JsonProperty("page_categories")
    @Nullable
    final ImmutableList<String> mPageCategoryNames;
    @JsonProperty("page_id")
    final String mPageId;
    @JsonProperty("page_name")
    final String mPageName;
    @JsonProperty("place_tip_welcome_header")
    final PlaceTipWelcomeHeaderFragmentModel mPlaceTipWelcomeHeader;
    @JsonProperty("presence_acquired_at")
    final long mPresenceAcquiredAt;
    @JsonProperty("presence_last_seen_at")
    final long mPulsarLastSeenAt;
    @JsonProperty("reaction_stories")
    final ReactionStoriesModel mReactionStories;
    @JsonProperty("presence_source")
    final PresenceSource mSource;
    @JsonProperty("suggestifier_footer_description")
    final DefaultTextWithEntitiesLongFieldsModel mSuggestifierFooterDescription;
    @JsonProperty("suggestifier_footer_question")
    final DefaultTextWithEntitiesLongFieldsModel mSuggestifierFooterQuestion;
    @JsonProperty("suggestifier_footer_thank_you_text")
    final DefaultTextWithEntitiesLongFieldsModel mSuggestifierFooterThankYouText;
    @JsonProperty("suggestifier_response_id")
    final String mSuggestifierResponseId;

    public PresenceDescription() {
        this.mPageId = null;
        this.mPageName = null;
        this.mPageCategoryNames = null;
        this.mPresenceAcquiredAt = 0;
        this.mPulsarLastSeenAt = 0;
        this.mFeedUnitHeaderStyled = null;
        this.mFeedUnitSubtitleStyled = null;
        this.mFeedUnitShowSuggestifierFooter = false;
        this.mSuggestifierFooterQuestion = null;
        this.mSuggestifierFooterDescription = null;
        this.mSuggestifierFooterThankYouText = null;
        this.mSource = null;
        this.mPlaceTipWelcomeHeader = null;
        this.mReactionStories = null;
        this.mSuggestifierResponseId = null;
        this.mExistingReactionSessionId = null;
        this.mConfidenceLevel = ConfidenceLevel.UNKNOWN;
    }

    public PresenceDescription(String str, String str2, ImmutableList<String> immutableList, long j, long j2, DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields2, boolean z, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields3, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields4, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields5, PresenceSource presenceSource, @Nullable PlaceTipWelcomeHeaderFragment placeTipWelcomeHeaderFragment, @Nullable ReactionStories reactionStories, @Nullable String str3, @Nullable String str4, @Nullable ConfidenceLevel confidenceLevel) {
        this.mPageId = str;
        this.mPageName = str2;
        this.mPageCategoryNames = immutableList;
        this.mPresenceAcquiredAt = j;
        this.mPulsarLastSeenAt = j2;
        this.mFeedUnitHeaderStyled = DefaultTextWithEntitiesLongFieldsModel.a(defaultTextWithEntitiesLongFields);
        this.mFeedUnitSubtitleStyled = DefaultTextWithEntitiesLongFieldsModel.a(defaultTextWithEntitiesLongFields2);
        this.mFeedUnitShowSuggestifierFooter = z;
        this.mSuggestifierFooterQuestion = DefaultTextWithEntitiesLongFieldsModel.a(defaultTextWithEntitiesLongFields3);
        this.mSuggestifierFooterDescription = DefaultTextWithEntitiesLongFieldsModel.a(defaultTextWithEntitiesLongFields4);
        this.mSuggestifierFooterThankYouText = DefaultTextWithEntitiesLongFieldsModel.a(defaultTextWithEntitiesLongFields5);
        this.mSource = presenceSource;
        this.mReactionStories = ReactionStoriesModel.a(reactionStories);
        this.mPlaceTipWelcomeHeader = PlaceTipWelcomeHeaderFragmentModel.a(placeTipWelcomeHeaderFragment);
        this.mSuggestifierResponseId = str3;
        this.mExistingReactionSessionId = str4;
        if (confidenceLevel == null) {
            confidenceLevel = ConfidenceLevel.UNKNOWN;
        }
        this.mConfidenceLevel = confidenceLevel;
    }

    public final long m3685a() {
        return this.mPulsarLastSeenAt;
    }

    public final DefaultTextWithEntitiesLongFields m3688b() {
        return this.mFeedUnitHeaderStyled;
    }

    @Nullable
    public final DefaultTextWithEntitiesLongFields m3689c() {
        return this.mFeedUnitSubtitleStyled;
    }

    public final void m3687a(boolean z) {
        this.mFeedUnitShowSuggestifierFooter = z;
    }

    public final boolean m3690d() {
        return this.mFeedUnitShowSuggestifierFooter;
    }

    @Nullable
    public final DefaultTextWithEntitiesLongFields m3691e() {
        return this.mSuggestifierFooterQuestion;
    }

    @Nullable
    public final DefaultTextWithEntitiesLongFields m3692f() {
        return this.mSuggestifierFooterDescription;
    }

    @Nullable
    public final DefaultTextWithEntitiesLongFields m3693g() {
        return this.mSuggestifierFooterThankYouText;
    }

    @Nullable
    public final String m3694h() {
        return this.mPageName;
    }

    @Nullable
    public final String m3695i() {
        return this.mPageId;
    }

    @Nullable
    public final ImmutableList<String> m3696j() {
        return this.mPageCategoryNames;
    }

    public final PresenceSource m3697k() {
        return this.mSource;
    }

    public final PresenceSourceType m3698l() {
        return m3697k().m3711a();
    }

    @Nullable
    public final PlaceTipWelcomeHeaderFragmentModel m3699m() {
        return this.mPlaceTipWelcomeHeader;
    }

    @Nullable
    public final ReactionStories m3700n() {
        return this.mReactionStories;
    }

    public final String m3701o() {
        return this.mSuggestifierResponseId;
    }

    @Nullable
    public final String m3702p() {
        return this.mExistingReactionSessionId;
    }

    public final ConfidenceLevel m3703q() {
        return this.mConfidenceLevel;
    }

    public final PresenceDescription m3686a(long j, @Nullable PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel, @Nullable ReactionStories reactionStories, @Nullable String str, @Nullable String str2, PresenceSource presenceSource, @Nullable ConfidenceLevel confidenceLevel) {
        return new PresenceDescription(this.mPageId, this.mPageName, this.mPageCategoryNames, this.mPresenceAcquiredAt, j, this.mFeedUnitHeaderStyled, this.mFeedUnitSubtitleStyled, this.mFeedUnitShowSuggestifierFooter, this.mSuggestifierFooterQuestion, this.mSuggestifierFooterDescription, this.mSuggestifierFooterThankYouText, presenceSource, placeTipWelcomeHeaderFragmentModel, reactionStories, str, str2, confidenceLevel);
    }
}
