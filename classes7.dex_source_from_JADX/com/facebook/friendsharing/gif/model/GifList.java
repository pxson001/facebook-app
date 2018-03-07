package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GifListDeserializer.class)
/* compiled from: SEARCH_TYPEAHEAD */
public class GifList {
    @JsonProperty("data")
    private ImmutableList<GifModelContainer> mList;

    public final ImmutableList<GifModelContainer> m26047a() {
        return this.mList;
    }
}
