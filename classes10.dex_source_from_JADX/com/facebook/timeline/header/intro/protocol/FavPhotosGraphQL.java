package com.facebook.timeline.header.intro.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQLModels.FavPhotosQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetch_group_settings_row */
public final class FavPhotosGraphQL {

    /* compiled from: fetch_group_settings_row */
    public class FavPhotosQueryString extends TypedGraphQlQueryString<FavPhotosQueryModel> {
        public FavPhotosQueryString() {
            super(FavPhotosQueryModel.class, false, "FavPhotosQuery", "3fd8e51f620c7c835295da97950af8c3", "user", "10154663149576729", RegularImmutableSet.a);
        }

        public final String m11915a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "6";
                case -1745741354:
                    return "8";
                case -1663499699:
                    return "4";
                case -1150725321:
                    return "7";
                case -1102636175:
                    return "0";
                case -461877888:
                    return "5";
                case -317710003:
                    return "10";
                case 169846802:
                    return "3";
                case 342198569:
                    return "1";
                case 557908192:
                    return "9";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m11916a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    return obj instanceof String ? "image/jpeg".equals(obj) : false;
                case true:
                    return obj instanceof String ? "contain-fit".equals(obj) : false;
                default:
                    return false;
            }
        }
    }
}
