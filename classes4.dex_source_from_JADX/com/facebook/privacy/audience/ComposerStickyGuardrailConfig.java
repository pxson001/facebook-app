package com.facebook.privacy.audience;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerStickyGuardrailConfigDeserializer.class)
@JsonSerialize(using = ComposerStickyGuardrailConfigSerializer.class)
/* compiled from: receipt_id */
public class ComposerStickyGuardrailConfig {
    @JsonProperty("current_privacy_option")
    public final GraphQLPrivacyOption mCurrentPrivacyOption;
    @JsonProperty("eligible")
    public final boolean mEligible;
    @JsonProperty("suggested_privacy_option")
    public final GraphQLPrivacyOption mSuggestedPrivacyOption;
    @JsonProperty("suggestion_timestamp")
    public final long mSuggestedTime;
    @JsonProperty("config_updated_time")
    public final long mUpdatedTime;

    /* compiled from: receipt_id */
    public class Builder {
        public boolean f3741a = false;
        public GraphQLPrivacyOption f3742b;
        public GraphQLPrivacyOption f3743c;
        public long f3744d = 0;
        public long f3745e = 0;

        public final ComposerStickyGuardrailConfig m4168a() {
            return new ComposerStickyGuardrailConfig(this);
        }
    }

    public ComposerStickyGuardrailConfig() {
        this.mEligible = false;
        this.mCurrentPrivacyOption = null;
        this.mSuggestedPrivacyOption = null;
        this.mSuggestedTime = 0;
        this.mUpdatedTime = 0;
    }

    public ComposerStickyGuardrailConfig(Builder builder) {
        this.mEligible = builder.f3741a;
        this.mCurrentPrivacyOption = builder.f3742b;
        this.mSuggestedPrivacyOption = builder.f3743c;
        this.mSuggestedTime = builder.f3744d;
        this.mUpdatedTime = builder.f3745e;
    }

    public final boolean m4169a() {
        return this.mEligible;
    }

    public final GraphQLPrivacyOption m4170b() {
        return this.mCurrentPrivacyOption;
    }

    public final GraphQLPrivacyOption m4171c() {
        return this.mSuggestedPrivacyOption;
    }

    public final long m4172d() {
        return this.mSuggestedTime;
    }
}
