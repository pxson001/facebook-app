package com.facebook.photos.upload.operation;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

@AutoGenJsonDeserializer
/* compiled from: goodwill_composer */
public class MultimediaInfo {
    @JsonProperty("videoPathToWaterfallId")
    public ImmutableMap<String, String> videoPathToWaterfallId;

    public MultimediaInfo(ImmutableMap<String, String> immutableMap) {
        this.videoPathToWaterfallId = immutableMap;
    }
}
