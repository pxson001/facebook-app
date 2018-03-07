package com.facebook.search.api.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GraphSearchQueryFragmentDeserializer.class)
/* compiled from: extra_optimistic_feed_story */
public class GraphSearchQueryFragment {
    @JsonProperty("is_matched")
    public final Boolean isMatched = Boolean.valueOf(false);
    @JsonProperty("text")
    public final String text = null;

    private GraphSearchQueryFragment() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GraphSearchQueryFragment)) {
            return false;
        }
        GraphSearchQueryFragment graphSearchQueryFragment = (GraphSearchQueryFragment) obj;
        if (Objects.equal(this.text, graphSearchQueryFragment.text) && Objects.equal(this.isMatched, graphSearchQueryFragment.isMatched)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Objects.toStringHelper(GraphSearchQueryFragment.class).add("text", this.text).add("isMatched", this.isMatched).toString();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.text, this.isMatched});
    }
}
