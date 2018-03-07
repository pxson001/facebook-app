package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VMDeckDeserializer.class)
@Immutable
/* compiled from: vnd.android.cursor.item/email */
public class VMDeck {
    private static final VMColor f287a = new VMColor("solid", ImmutableList.of(Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)), null, 0.0f, null);
    @JsonProperty("bg-color")
    public final VMColor bgColor;
    @JsonProperty("initial-slide")
    public final String initialSlide;
    @JsonProperty("resources")
    public final ImmutableMap<String, String> resources;
    @JsonProperty("size")
    public final ImmutableList<Float> size;
    @JsonProperty("slides")
    public final ImmutableList<VMSlide> slides;
    @JsonProperty("styles")
    public final ImmutableList<VMView> styles;
    @JsonProperty("theme")
    public final String theme;

    /* compiled from: vnd.android.cursor.item/email */
    public class Builder {
        public ImmutableList<Float> f280a;
        public ImmutableList<VMSlide> f281b;
        public ImmutableMap<String, String> f282c;
        public String f283d;
        public ImmutableList<VMView> f284e;
        public String f285f;
        public VMColor f286g;

        public final VMDeck m268a() {
            return new VMDeck(this.f280a, this.f281b, this.f282c, this.f283d, this.f284e, this.f285f, this.f286g);
        }
    }

    public VMDeck() {
        this.size = null;
        this.slides = null;
        this.resources = null;
        this.initialSlide = null;
        this.styles = null;
        this.theme = null;
        this.bgColor = null;
    }

    public VMDeck(ImmutableList<Float> immutableList, ImmutableList<VMSlide> immutableList2, ImmutableMap<String, String> immutableMap, String str, ImmutableList<VMView> immutableList3, String str2, VMColor vMColor) {
        this.size = immutableList;
        this.slides = immutableList2;
        this.resources = immutableMap;
        this.initialSlide = str;
        this.styles = immutableList3;
        this.theme = str2;
        this.bgColor = vMColor;
    }

    public final VMColor m269a() {
        return this.bgColor == null ? f287a : this.bgColor;
    }
}
