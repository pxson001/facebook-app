package com.facebook.loom.config;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ColdStartTraceControlConfigurationDeserializer.class)
/* compiled from: getSpecifiedContacts */
public class ColdStartTraceControlConfiguration implements Postprocessable<ColdStartTraceControlConfiguration>, ControllerConfig {
    private int f11098a;
    @JsonProperty("coinflip_sample_rate")
    private final int mCoinflipSampleRate = 0;
    @JsonProperty("enabled_event_providers")
    private final ImmutableList<String> mEnabledEventProviders = null;
    @JsonProperty("stop_qpl_marker")
    private final int mStopQPLMarker = 0;
    @JsonProperty("timed_out_upload_sample_rate")
    private int mTimedOutUploadSampleRate = 0;
    @JsonProperty("max_trace_timeout_ms")
    private final int mTraceTimeoutMs = 0;

    public final Object m11533a() {
        this.f11098a = LoomConfiguration.m11515a(this.mEnabledEventProviders);
        return this;
    }

    public final int m11534b() {
        return this.f11098a;
    }

    public final int m11535c() {
        return this.mStopQPLMarker;
    }

    public final int m11536d() {
        return this.mCoinflipSampleRate;
    }

    public final int m11537e() {
        return this.mTraceTimeoutMs;
    }

    public final int m11538f() {
        return this.mTimedOutUploadSampleRate;
    }
}
