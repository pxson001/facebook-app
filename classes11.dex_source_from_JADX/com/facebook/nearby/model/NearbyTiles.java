package com.facebook.nearby.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLMapTileNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@AutoGenJsonDeserializer
/* compiled from: unrecognized_graphql_type */
public class NearbyTiles {
    @JsonProperty("canonicalization")
    public final String canonicalization = null;
    @JsonProperty("display_region_hint")
    public final GraphQLGeoRectangle displayRegionHint = null;
    @JsonProperty("edges")
    public final List<GraphQLMapTileNode> tiles = null;
    @JsonProperty("version")
    public final String version = null;
}
