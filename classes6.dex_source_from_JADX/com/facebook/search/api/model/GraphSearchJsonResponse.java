package com.facebook.search.api.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GraphSearchJsonResponseDeserializer.class)
/* compiled from: extra_parent_category */
public class GraphSearchJsonResponse {
    @JsonProperty("num_topresults_to_show")
    public final String numTopResultsToShow = null;
    @JsonProperty("response")
    public final String response = null;

    private GraphSearchJsonResponse() {
    }
}
