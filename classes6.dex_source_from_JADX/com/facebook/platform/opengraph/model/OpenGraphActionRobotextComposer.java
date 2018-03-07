package com.facebook.platform.opengraph.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext.Span;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@AutoGenJsonDeserializer
/* compiled from: store_tab */
public class OpenGraphActionRobotextComposer extends OpenGraphActionRobotext {
    @JsonProperty("description")
    public void setDescription(String str) {
        this.a = str;
    }

    @JsonProperty("description_tags")
    public void setDescriptionTags(Map<String, List<Span>> map) {
        this.b = Lists.a();
        for (Entry value : map.entrySet()) {
            this.f4101b.add(((List) value.getValue()).get(0));
        }
    }
}
