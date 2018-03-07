package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesReverseGeocodeQueryModels.AdInterfacesReverseGeocodeQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: You're querying community link on not AtWork build */
public final class AdInterfacesReverseGeocodeQuery {

    /* compiled from: You're querying community link on not AtWork build */
    public class AdInterfacesReverseGeocodeQueryString extends TypedGraphQlQueryString<AdInterfacesReverseGeocodeQueryModel> {
        public AdInterfacesReverseGeocodeQueryString() {
            super(AdInterfacesReverseGeocodeQueryModel.class, false, "AdInterfacesReverseGeocodeQuery", "b942005d8057b6b3245545645217cbd6", "reverse_geocode", "10153916839661729", RegularImmutableSet.a);
        }

        public final String m23938a(String str) {
            switch (str.hashCode()) {
                case 1871919611:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
