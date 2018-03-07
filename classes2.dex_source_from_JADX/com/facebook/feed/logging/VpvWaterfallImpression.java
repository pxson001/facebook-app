package com.facebook.feed.logging;

import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonSerialize(using = VpvWaterfallImpressionSerializer.class)
/* compiled from: iorg/basicServices */
public class VpvWaterfallImpression {
    @JsonProperty("stage")
    public int stage;
    @JsonProperty("tracking")
    @Nullable
    public ArrayNode trackingCodes;

    public VpvWaterfallImpression(@Nullable ArrayNode arrayNode, int i) {
        this.trackingCodes = arrayNode;
        this.stage = i;
    }
}
