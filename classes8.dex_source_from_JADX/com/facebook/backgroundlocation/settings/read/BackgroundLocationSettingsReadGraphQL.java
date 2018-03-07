package com.facebook.backgroundlocation.settings.read;

import com.facebook.backgroundlocation.settings.read.BackgroundLocationSettingsReadGraphQLModels.LocationHistoryEnabledQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: is_deleted_client */
public final class BackgroundLocationSettingsReadGraphQL {

    /* compiled from: is_deleted_client */
    public class LocationHistoryEnabledQueryString extends TypedGraphQlQueryString<LocationHistoryEnabledQueryModel> {
        public LocationHistoryEnabledQueryString() {
            super(LocationHistoryEnabledQueryModel.class, false, "LocationHistoryEnabledQuery", "49ea1ee5b25fe5f4a3ce7030c020f8f1", "viewer", "10154339187346729", RegularImmutableSet.a);
        }
    }
}
