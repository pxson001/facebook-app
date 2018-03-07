package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VMSlideDeserializer.class)
@Immutable
/* compiled from: visible_interval */
public class VMSlide {
    private static final ImmutableList<VMSlideValue> f297a = RegularImmutableList.a;
    @JsonProperty("actions")
    public final ImmutableMap<String, VMAction> actionsMap;
    @JsonProperty("bg-color")
    public final VMColor bgColor;
    @JsonProperty("class")
    public final String className;
    @JsonProperty("master")
    public final boolean master;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("size")
    public final ImmutableList<Float> size;
    @JsonProperty("values")
    public final ImmutableList<VMSlideValue> values;
    @JsonProperty("views")
    public final ImmutableList<VMView> views;

    /* compiled from: visible_interval */
    public class Builder {
        private String f289a;
        private ImmutableList<Float> f290b;
        private ImmutableList<VMView> f291c;
        private ImmutableMap<String, VMAction> f292d;
        public boolean f293e;
        private String f294f;
        public ImmutableList<VMSlideValue> f295g;
        private VMColor f296h;

        public final Builder m272a(VMSlide vMSlide) {
            this.f289a = vMSlide.name;
            this.f290b = vMSlide.size;
            this.f291c = vMSlide.views;
            this.f292d = vMSlide.actionsMap;
            this.f293e = vMSlide.master;
            this.f294f = vMSlide.className;
            this.f295g = vMSlide.values;
            this.f296h = vMSlide.bgColor;
            return this;
        }

        public final VMSlide m273a() {
            return new VMSlide(this.f289a, this.f290b, this.f291c, this.f292d, this.f293e, this.f294f, this.f295g, this.f296h);
        }
    }

    public VMSlide() {
        this.name = null;
        this.size = null;
        this.views = null;
        this.actionsMap = null;
        this.master = false;
        this.className = null;
        this.values = null;
        this.bgColor = null;
    }

    public VMSlide(String str, ImmutableList<Float> immutableList, ImmutableList<VMView> immutableList2, ImmutableMap<String, VMAction> immutableMap, boolean z, String str2, ImmutableList<VMSlideValue> immutableList3, VMColor vMColor) {
        this.name = str;
        this.size = immutableList;
        this.views = immutableList2;
        this.actionsMap = immutableMap;
        this.master = z;
        this.className = str2;
        this.values = immutableList3;
        this.bgColor = vMColor;
    }

    public final ImmutableList<VMSlideValue> m274a() {
        return this.values == null ? f297a : this.values;
    }

    public final float m275b() {
        return ((Float) this.size.get(0)).floatValue();
    }

    public final float m276c() {
        return ((Float) this.size.get(1)).floatValue();
    }
}
