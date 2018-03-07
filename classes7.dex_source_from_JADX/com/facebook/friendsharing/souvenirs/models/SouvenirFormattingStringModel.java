package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SouvenirFormattingStringModelDeserializer.class)
@Immutable
/* compiled from: ROTATION_COUNT */
public class SouvenirFormattingStringModel {
    @JsonIgnore
    public String f24059a;
    @JsonProperty("assetCount")
    public final int assetCount;
    @JsonProperty("name")
    public final String name;

    public SouvenirFormattingStringModel() {
        this.name = null;
        this.assetCount = 0;
        this.f24059a = null;
    }

    public SouvenirFormattingStringModel(String str, int i) {
        this.name = str;
        this.assetCount = i;
    }

    public final String m26161a() {
        if (this.f24059a == null) {
            this.f24059a = this.name + "_" + this.assetCount;
        }
        return this.f24059a;
    }
}
