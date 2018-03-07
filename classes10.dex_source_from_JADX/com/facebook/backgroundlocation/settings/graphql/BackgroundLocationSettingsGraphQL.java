package com.facebook.backgroundlocation.settings.graphql;

import com.facebook.backgroundlocation.settings.graphql.BackgroundLocationSettingsGraphQLModels.LocationSharingPrivacyOptionsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: dialogIsInteractive */
public final class BackgroundLocationSettingsGraphQL {

    /* compiled from: dialogIsInteractive */
    public class LocationSharingPrivacyOptionsQueryString extends TypedGraphQlQueryString<LocationSharingPrivacyOptionsQueryModel> {
        public LocationSharingPrivacyOptionsQueryString() {
            super(LocationSharingPrivacyOptionsQueryModel.class, false, "LocationSharingPrivacyOptionsQuery", "2138bd1f2c11a50adff9b69367909a04", "viewer", "10154661257716729", RegularImmutableSet.a);
        }

        public final String m15510a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "1";
                case -1442803611:
                    return "2";
                case 1973879317:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
