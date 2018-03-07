package com.facebook.transliteration.algorithms.unigram;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

@AutoGenJsonDeserializer
/* compiled from: external_activity_launch_failure */
public class UnigramModelDataItem {
    @JsonProperty("emissions")
    public ImmutableMap<String, Double> mEmissions;
    @JsonProperty("standard")
    public String mStandardEmission;
}
