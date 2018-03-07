package com.facebook.privacy.audience;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = InlinePrivacySurveyConfigDeserializer.class)
@JsonSerialize(using = InlinePrivacySurveyConfigSerializer.class)
/* compiled from: record_self_raw_video */
public class InlinePrivacySurveyConfig {
    @JsonProperty("eligible")
    public final boolean mEligible;
    @JsonProperty("first_option")
    public final GraphQLPrivacyOption mFirstSurveyOption;
    @JsonProperty("second_option")
    public final GraphQLPrivacyOption mSecondSurveyOption;
    @JsonProperty("trigger_option")
    public final GraphQLPrivacyOption mTriggerPrivacyOption;

    /* compiled from: record_self_raw_video */
    public class Builder {
        public boolean f3549a = false;
        public GraphQLPrivacyOption f3550b = null;
        public GraphQLPrivacyOption f3551c = null;
        public GraphQLPrivacyOption f3552d = null;

        public final InlinePrivacySurveyConfig m3940a() {
            return new InlinePrivacySurveyConfig(this);
        }
    }

    private InlinePrivacySurveyConfig() {
        this.mEligible = false;
        this.mTriggerPrivacyOption = null;
        this.mFirstSurveyOption = null;
        this.mSecondSurveyOption = null;
    }

    public InlinePrivacySurveyConfig(Builder builder) {
        this.mEligible = builder.f3549a;
        this.mTriggerPrivacyOption = builder.f3550b;
        this.mFirstSurveyOption = builder.f3551c;
        this.mSecondSurveyOption = builder.f3552d;
    }
}
