package com.facebook.pages.app.data.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PagesManagerUriConfigEntryDeserializer.class)
/* compiled from: tablet/ */
public class PagesManagerUriConfigEntry {
    @JsonProperty("setting")
    private String mSetting;
    @JsonProperty("value")
    private String mValue;
}
