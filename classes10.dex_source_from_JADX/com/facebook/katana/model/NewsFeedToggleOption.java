package com.facebook.katana.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = NewsFeedToggleOptionDeserializer.class)
/* compiled from: upcoming_birthdays */
public class NewsFeedToggleOption {
    @JsonProperty("script")
    public final String script = null;
    @JsonProperty("title")
    public final String title = null;

    private NewsFeedToggleOption() {
    }
}
