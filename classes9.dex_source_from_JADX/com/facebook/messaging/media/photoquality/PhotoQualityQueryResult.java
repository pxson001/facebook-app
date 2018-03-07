package com.facebook.messaging.media.photoquality;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PhotoQualityQueryResultDeserializer.class)
/* compiled from: long_click */
public class PhotoQualityQueryResult {
    @JsonProperty("resolution")
    public final Integer resolution = Integer.valueOf(0);
    @JsonProperty("thumbnail_resolution")
    public final Integer thumbnailResolution = Integer.valueOf(0);
}
