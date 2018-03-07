package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.graphql.visitor.HasCustomTags;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.instagram.common.json.annotation.JsonType;

@JsonDeserialize(using = FeedUnitDeserializer.class)
@JsonPropertyOrder(a = {"__type__"})
@JsonType
/* compiled from: missing tracking codes trace */
public interface FeedUnit extends FeedUnitCommon, HasCustomTags {
    @JsonProperty("__type__")
    GraphQLObjectType getType();
}
