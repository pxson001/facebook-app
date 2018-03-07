package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VMColorDeserializer.class)
@Immutable
/* compiled from: wall_load_failure */
public class VMColor {
    @JsonProperty("angle")
    public final float angle;
    @JsonProperty("color")
    public final ImmutableList<Float> color;
    @JsonProperty("colors")
    public final ImmutableList<ImmutableList<Float>> colors;
    @JsonProperty("locations")
    public final ImmutableList<Float> locations;
    @JsonProperty("type")
    public final String type;

    public VMColor() {
        this.type = null;
        this.color = null;
        this.colors = null;
        this.angle = 0.0f;
        this.locations = null;
    }

    public VMColor(String str, ImmutableList<Float> immutableList, ImmutableList<ImmutableList<Float>> immutableList2, float f, ImmutableList<Float> immutableList3) {
        this.type = str;
        this.color = immutableList;
        this.colors = immutableList2;
        this.angle = f;
        this.locations = immutableList3;
    }
}
