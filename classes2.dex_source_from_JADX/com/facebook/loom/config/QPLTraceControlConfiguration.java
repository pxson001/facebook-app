package com.facebook.loom.config;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = QPLTraceControlConfigurationDeserializer.class)
/* compiled from: zero_rating2/clearable/default_optin/campaign_id_key */
public class QPLTraceControlConfiguration implements Postprocessable<QPLTraceControlConfiguration> {
    private int f458a;
    @JsonProperty("coinflip_sample_rate")
    private final int mCoinflipSampleRate;
    @JsonProperty("enabled_event_providers")
    private final ImmutableList<String> mEnabledEventProviders;

    public QPLTraceControlConfiguration() {
        this(0, -1);
    }

    public QPLTraceControlConfiguration(int i, int i2) {
        this.mCoinflipSampleRate = i;
        this.mEnabledEventProviders = null;
        this.f458a = i2;
    }

    public final Object mo78a() {
        if (!(this.mEnabledEventProviders == null || this.mEnabledEventProviders.isEmpty())) {
            this.f458a = LoomConfiguration.a(this.mEnabledEventProviders);
        }
        return this;
    }

    public final int m995b() {
        return this.mCoinflipSampleRate;
    }

    public final int m996c() {
        return this.f458a;
    }
}
