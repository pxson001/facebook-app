package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GifModelContainerDeserializer.class)
/* compiled from: SCRUBBER_MOVES */
public class GifModelContainer {
    @JsonProperty("images")
    private GifModelSubContainer mModelSubContainer;

    public final GifModelSubContainer m26051a() {
        return this.mModelSubContainer;
    }
}
