package com.facebook.groups.sideshow.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLModels.FetchRecentActiveGroupsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: windows-1250 */
public final class FetchRecentActiveGroupsDataQL {

    /* compiled from: windows-1250 */
    public class FetchRecentActiveGroupsQueryString extends TypedGraphQlQueryString<FetchRecentActiveGroupsQueryModel> {
        public FetchRecentActiveGroupsQueryString() {
            super(FetchRecentActiveGroupsQueryModel.class, false, "FetchRecentActiveGroupsQuery", "6ec6cfd9cfb3052c7c38268a3753b95b", "user", "10154405445296729", RegularImmutableSet.a);
        }

        public final String m414a(String str) {
            switch (str.hashCode()) {
                case 94851343:
                    return "1";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
