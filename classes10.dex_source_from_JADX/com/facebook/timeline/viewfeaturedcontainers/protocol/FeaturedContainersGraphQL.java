package com.facebook.timeline.viewfeaturedcontainers.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_events_discovery_fragment_previous_tab_position */
public final class FeaturedContainersGraphQL {

    /* compiled from: extra_events_discovery_fragment_previous_tab_position */
    public class FeaturedContainersQueryString extends TypedGraphQlQueryString<FeaturedContainersQueryModel> {
        public FeaturedContainersQueryString() {
            super(FeaturedContainersQueryModel.class, false, "FeaturedContainersQuery", "71967400f2746cf4b13552e34433cb9f", "user", "10154572658161729", RegularImmutableSet.a);
        }

        public final String m12797a(String str) {
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
                case 557908192:
                    return "9";
                case 1615641919:
                    return "1";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }

        protected final boolean m12798a(String str, Object obj) {
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
                        return "8".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 8) {
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
