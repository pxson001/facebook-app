package com.facebook.nearby.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = NearbyTilesMethodResultDeserializer.class)
/* compiled from: unreadNotifCount */
public class NearbyTilesMethodResult {
    @JsonProperty("tiles")
    public final NearbyTiles nearbyTiles = null;
    @JsonProperty("search_session_key")
    public final String searchSessionKey = null;
}
