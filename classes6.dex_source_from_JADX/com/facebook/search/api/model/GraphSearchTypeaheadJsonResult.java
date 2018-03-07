package com.facebook.search.api.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GraphSearchTypeaheadJsonResultDeserializer.class)
/* compiled from: extra_nonnetwork_error_count */
public class GraphSearchTypeaheadJsonResult {
    @JsonProperty("all_shared_stories_count")
    public final String allSharedStoriesCount = null;
    @JsonProperty("bolded_subtext")
    public final String boldedSubtext = null;
    @JsonProperty("can_like")
    public final String canLike = null;
    @JsonProperty("category")
    public final String category = null;
    @JsonProperty("creation_time")
    public final String creationTime = null;
    @JsonProperty("external_url")
    public final String externalUrl = null;
    @JsonProperty("fallback_path")
    public final String fallbackPath = null;
    @JsonProperty("fragments")
    public final List<GraphSearchQueryFragment> fragments = RegularImmutableList.a;
    @JsonProperty("friendship_status")
    public final String friendshipStatus = null;
    @JsonProperty("grammar_type")
    public final String grammarType = null;
    @JsonProperty("grammar_result_set_type")
    public final String grammerResultSetType = null;
    @JsonProperty("is_live")
    public final boolean isLive = false;
    @JsonProperty("is_scoped")
    public final String isScoped = null;
    @JsonProperty("is_verified")
    public final String isVerified = null;
    @JsonProperty("keyword_source")
    public final String keywordSource = null;
    @JsonProperty("keyword_type")
    public final String keywordType = null;
    @JsonProperty("type")
    public final String link = null;
    @JsonProperty("matched_length")
    public final String matchedLength = null;
    @JsonProperty("matched_pos")
    public final String matchedPos = null;
    @JsonProperty("name")
    public final String name = null;
    @JsonProperty("path")
    public final String path = null;
    @JsonProperty("photo")
    public final String photoUri = null;
    @JsonProperty("result_type")
    public final String resultType = null;
    @JsonProperty("semantic")
    public final String semantic = null;
    @JsonProperty("source")
    public final String source = null;
    @JsonProperty("subtext")
    public final String subtext = null;
    @JsonProperty("text")
    public final String text = null;
    @JsonProperty("uid")
    public final String uid = null;
    @JsonProperty("verification_status")
    public final String verificationStatus = null;

    private GraphSearchTypeaheadJsonResult() {
    }
}
