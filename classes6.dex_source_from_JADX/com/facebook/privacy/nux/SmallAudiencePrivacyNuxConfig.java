package com.facebook.privacy.nux;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SmallAudiencePrivacyNuxConfigDeserializer.class)
/* compiled from: fbpushdata */
public class SmallAudiencePrivacyNuxConfig {
    @JsonProperty("included_count")
    public final int includedCount = 0;
    @JsonProperty("previous_privacy")
    public final String previousPrivacy = null;

    SmallAudiencePrivacyNuxConfig() {
    }
}
