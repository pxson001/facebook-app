package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GifModelSubContainerDeserializer.class)
/* compiled from: SAVING_IN_PROGRESS */
public class GifModelSubContainer {
    @JsonProperty("fixed_width")
    private GifModel mModel;

    public final GifModel m26056a() {
        return this.mModel;
    }
}
