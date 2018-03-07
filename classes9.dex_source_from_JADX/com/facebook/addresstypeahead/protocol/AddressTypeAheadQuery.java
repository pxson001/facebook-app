package com.facebook.addresstypeahead.protocol;

import com.facebook.addresstypeahead.protocol.AddressTypeAheadQueryModels.AddressTypeAheadQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sent/# */
public final class AddressTypeAheadQuery {

    /* compiled from: sent/# */
    public class AddressTypeAheadQueryString extends TypedGraphQlQueryString<AddressTypeAheadQueryModel> {
        public AddressTypeAheadQueryString() {
            super(AddressTypeAheadQueryModel.class, false, "AddressTypeAheadQuery", "57850af817c8832ad2a1f2f7ae50b34d", "city_street_search", "10154667126276729", RegularImmutableSet.a);
        }

        public final String m3770a(String str) {
            switch (str.hashCode()) {
                case -1147692044:
                    return "0";
                case 102976443:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
