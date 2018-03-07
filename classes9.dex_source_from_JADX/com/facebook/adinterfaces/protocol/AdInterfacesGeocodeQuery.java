package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQueryModels.AdInterfacesGeocodeQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: [.] */
public final class AdInterfacesGeocodeQuery {

    /* compiled from: [.] */
    public class AdInterfacesGeocodeQueryString extends TypedGraphQlQueryString<AdInterfacesGeocodeQueryModel> {
        public AdInterfacesGeocodeQueryString() {
            super(AdInterfacesGeocodeQueryModel.class, false, "AdInterfacesGeocodeQuery", "c4e5181164b61149ab0cd64d39fa3011", "geocode_address", "10153522947946729", RegularImmutableSet.a);
        }

        public final String m23019a(String str) {
            switch (str.hashCode()) {
                case 102976443:
                    return "1";
                case 874544034:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
