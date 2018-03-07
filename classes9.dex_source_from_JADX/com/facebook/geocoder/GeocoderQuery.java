package com.facebook.geocoder;

import com.facebook.geocoder.GeocoderQueryModels.GeocodeQueryModel;
import com.facebook.geocoder.GeocoderQueryModels.ReverseGeocodeQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: peer_to_peer_payments */
public final class GeocoderQuery {

    /* compiled from: peer_to_peer_payments */
    public class GeocodeQueryString extends TypedGraphQlQueryString<GeocodeQueryModel> {
        public GeocodeQueryString() {
            super(GeocodeQueryModel.class, false, "GeocodeQuery", "2070fc65a1706dbb845adbab55fa99ef", "geocode_address", "10154201420061729", RegularImmutableSet.a);
        }

        public final String m7035a(String str) {
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

    /* compiled from: peer_to_peer_payments */
    public class ReverseGeocodeQueryString extends TypedGraphQlQueryString<ReverseGeocodeQueryModel> {
        public ReverseGeocodeQueryString() {
            super(ReverseGeocodeQueryModel.class, false, "ReverseGeocodeQuery", "b210863b0d702696f2bbdff270d0df60", "reverse_geocode", "10154112210406729", RegularImmutableSet.a);
        }

        public final String m7036a(String str) {
            switch (str.hashCode()) {
                case 102976443:
                    return "1";
                case 1871919611:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
