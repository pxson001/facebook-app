package com.facebook.groups.discover.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FetchSuggestedGroupsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: UserNameSearchQuery */
public final class FetchSuggestedGroups {

    /* compiled from: UserNameSearchQuery */
    public class FetchSuggestedGroupsString extends TypedGraphQlQueryString<FetchSuggestedGroupsModel> {
        public FetchSuggestedGroupsString() {
            super(FetchSuggestedGroupsModel.class, false, "FetchSuggestedGroups", "28556f6dee077a3331265c3e90d12482", "viewer", "10154358537321729", RegularImmutableSet.a);
        }

        public final String m22189a(String str) {
            switch (str.hashCode()) {
                case -1966910237:
                    return "1";
                case -1101600581:
                    return "4";
                case -147799178:
                    return "2";
                case -59350230:
                    return "3";
                case 16907033:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
