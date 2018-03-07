package com.facebook.search.api.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SearchTypeaheadJsonResultDeserializer.class)
/* compiled from: extra_logger_type */
public final class SearchTypeaheadJsonResult {
    @JsonProperty("category")
    public final String category = null;
    @JsonProperty("fallback_path")
    public final String fallbackPath = null;
    @JsonProperty("friendship_status")
    public final String friendshipStatus = null;
    @JsonProperty("is_verified")
    public final boolean isVerified = false;
    @JsonProperty("matched_tokens")
    public final ImmutableList<String> matchedTokens = null;
    @JsonProperty("native_android_url")
    public final String nativeAndroidUrl = null;
    @JsonProperty("path")
    public final String path = null;
    @JsonProperty("photo")
    public final String photo = null;
    @JsonProperty("saved_state")
    public final GraphQLSavedState savedState = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @JsonProperty("subtext")
    public final String subtext = null;
    @JsonProperty("text")
    public final String text = null;
    @JsonProperty("type")
    public final String type = null;
    @JsonProperty("uid")
    public final String uid = null;

    private SearchTypeaheadJsonResult() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SearchTypeaheadJsonResult)) {
            return false;
        }
        SearchTypeaheadJsonResult searchTypeaheadJsonResult = (SearchTypeaheadJsonResult) obj;
        if (Objects.equal(this.category, searchTypeaheadJsonResult.category) && Objects.equal(this.friendshipStatus, searchTypeaheadJsonResult.friendshipStatus) && this.isVerified == searchTypeaheadJsonResult.isVerified && Objects.equal(this.nativeAndroidUrl, searchTypeaheadJsonResult.nativeAndroidUrl) && Objects.equal(this.path, searchTypeaheadJsonResult.path) && Objects.equal(this.fallbackPath, searchTypeaheadJsonResult.fallbackPath) && Objects.equal(this.photo, searchTypeaheadJsonResult.photo) && Objects.equal(this.subtext, searchTypeaheadJsonResult.subtext) && Objects.equal(this.text, searchTypeaheadJsonResult.text) && Objects.equal(this.type, searchTypeaheadJsonResult.type) && Objects.equal(this.uid, searchTypeaheadJsonResult.uid) && this.savedState == searchTypeaheadJsonResult.savedState) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(SearchTypeaheadJsonResult.class).add("category", this.category).add("friendshipStatus", this.friendshipStatus).add("isVerified", this.isVerified).add("nativeAndroidUrl", this.nativeAndroidUrl).add("path", this.path).add("fallbackPath", this.fallbackPath).add("photo", this.photo).add("subtext", this.subtext).add("text", this.text).add("type", this.type).add("uid", this.uid).add("matchedTokens", this.matchedTokens).add("savedState", this.savedState).toString();
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.category, this.friendshipStatus, Boolean.valueOf(this.isVerified), this.nativeAndroidUrl, this.path, this.fallbackPath, this.photo, this.subtext, this.text, this.type, this.uid, this.matchedTokens, this.savedState});
    }
}
