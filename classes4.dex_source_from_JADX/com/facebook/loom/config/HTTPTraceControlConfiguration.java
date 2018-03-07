package com.facebook.loom.config;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = HTTPTraceControlConfigurationDeserializer.class)
/* compiled from: getSubtitles */
public class HTTPTraceControlConfiguration implements Postprocessable<HTTPTraceControlConfiguration>, ControllerConfig {
    private int f11097a;
    @JsonProperty("enabled_event_providers")
    private final ImmutableList<String> mEnabledEventProviders = null;

    public final Object m11531a() {
        this.f11097a = LoomConfiguration.m11515a(this.mEnabledEventProviders);
        return this;
    }

    public final int m11532b() {
        return this.f11097a;
    }
}
