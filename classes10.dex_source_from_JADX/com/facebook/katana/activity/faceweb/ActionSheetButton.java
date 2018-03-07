package com.facebook.katana.activity.faceweb;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ActionSheetButtonDeserializer.class)
/* compiled from: userLocale */
public class ActionSheetButton {
    @JsonProperty("callback")
    public final String callback = null;
    @JsonProperty("title")
    public final String title = null;
    @JsonProperty("type")
    public final String type = null;

    private ActionSheetButton() {
    }
}
