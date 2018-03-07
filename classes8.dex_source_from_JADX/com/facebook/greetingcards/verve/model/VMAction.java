package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VMActionDeserializer.class)
@Immutable
/* compiled from: warn_override_ */
public class VMAction {
    @JsonProperty("arg")
    public final String arg;
    @JsonProperty("type")
    public final String type;

    public VMAction() {
        this.type = null;
        this.arg = null;
    }

    public VMAction(String str, String str2) {
        this.type = str;
        this.arg = str2;
    }
}
