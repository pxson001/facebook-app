package com.facebook.katana.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = UserServerSettingDeserializer.class)
/* compiled from: source_system_tray */
public class UserServerSetting {
    @JsonProperty("project")
    public final String mProjectName = null;
    @JsonProperty("setting")
    public final String mSettingName = null;
    @JsonProperty("value")
    public final String mValue = null;

    private UserServerSetting() {
    }
}
