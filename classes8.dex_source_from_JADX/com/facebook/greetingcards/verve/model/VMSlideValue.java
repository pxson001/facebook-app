package com.facebook.greetingcards.verve.model;

import android.graphics.PointF;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VMSlideValueDeserializer.class)
@Immutable
/* compiled from: viewer_unblacklist_page_from_gravity */
public class VMSlideValue {
    public final PointF f299a;
    private VMViewType f300b;
    @JsonProperty("duration")
    public final Float duration;
    @JsonProperty("type")
    private final String mType;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("src")
    public final String src;
    @JsonProperty("subviews")
    public final ImmutableList<VMView> subviews;
    @JsonProperty("text")
    public final String text;
    @JsonProperty("title")
    public final String title;

    public VMSlideValue() {
        this.name = null;
        this.mType = null;
        this.src = null;
        this.text = null;
        this.title = null;
        this.subviews = null;
        this.duration = null;
        this.f299a = null;
    }

    private VMSlideValue(String str, String str2, String str3, String str4, String str5, ImmutableList<VMView> immutableList, Float f, PointF pointF) {
        this.name = str;
        this.mType = str2;
        this.src = str3;
        this.text = str4;
        this.title = str5;
        this.subviews = immutableList;
        this.duration = f;
        this.f299a = pointF;
    }

    public final VMViewType m282a() {
        if (this.f300b == null) {
            this.f300b = VMViewType.fromString(this.mType);
        }
        return this.f300b;
    }

    public static VMSlideValue m279a(String str, String str2) {
        return new VMSlideValue(str, VMViewType.LABEL.toString(), null, str2, null, null, null, null);
    }

    public static VMSlideValue m280a(String str, String str2, @Nullable PointF pointF) {
        return new VMSlideValue(str, VMViewType.MEDIA.toString(), str2, null, null, null, null, pointF);
    }

    public static VMSlideValue m281b(String str, String str2) {
        return new VMSlideValue(str, VMViewType.BUTTON.toString(), null, null, str2, null, null, null);
    }
}
