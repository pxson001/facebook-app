package com.facebook.places.create.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.places.create.graphql.GeocodeAddressModels.GeocodeAddressToLocationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: catalog_document */
public final class GeocodeAddress {

    /* compiled from: catalog_document */
    public class GeocodeAddressToLocationString extends TypedGraphQlQueryString<GeocodeAddressToLocationModel> {
        public GeocodeAddressToLocationString() {
            super(GeocodeAddressToLocationModel.class, false, "GeocodeAddressToLocation", "e8eca9cfb6b4e357b62ccf98a42a7897", "geocode_address", "10154661259076729", RegularImmutableSet.a);
        }

        public final String m22185a(String str) {
            switch (str.hashCode()) {
                case 874544034:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
