package com.facebook.platform.opengraph.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext.Span;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@AutoGenJsonDeserializer
@JsonDeserialize(using = OpenGraphActionRobotextMessageDeserializer.class)
/* compiled from: storeFragment */
public class OpenGraphActionRobotextMessage extends OpenGraphActionRobotext {
    @JsonProperty("robotext")
    public void setRobotext(String str) {
        this.a = str;
    }

    @JsonProperty("robotext_tags")
    public void setRobotextTags(Map<String, List<Span>> map) {
        this.b = Lists.a();
        for (Entry value : map.entrySet()) {
            this.f4101b.add(((List) value.getValue()).get(0));
        }
    }
}
