package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GifModelDeserializer.class)
/* compiled from: SEARCH */
public class GifModel {
    @JsonProperty("height")
    private Integer mHeight;
    @JsonProperty("url")
    private String mUrl;
    @JsonProperty("width")
    private Integer mWidth;

    public final String m26050a() {
        return this.mUrl;
    }
}
