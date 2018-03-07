package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: is_refresh_only */
public final class ClashUnitQuery {

    /* compiled from: is_refresh_only */
    public class ClashUnitQueryString extends TypedGraphQlQueryString<ClashUnitQueryModel> {
        public ClashUnitQueryString() {
            super(ClashUnitQueryModel.class, false, "ClashUnitQuery", "581b26bc35b256b0189fc86bf4592be6", "viewer", "10154648066006729", RegularImmutableSet.a);
        }

        public final String m10303a(String str) {
            switch (str.hashCode()) {
                case 104585032:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final ClashUnitQueryString m10302a() {
        return new ClashUnitQueryString();
    }
}
