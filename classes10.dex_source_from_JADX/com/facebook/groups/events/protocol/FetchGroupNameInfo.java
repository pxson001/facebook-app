package com.facebook.groups.events.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.events.protocol.FetchGroupNameInfoModels.FetchGroupNameInfoModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: UNFAVORITE_GROUP */
public final class FetchGroupNameInfo {

    /* compiled from: UNFAVORITE_GROUP */
    public class FetchGroupNameInfoString extends TypedGraphQlQueryString<FetchGroupNameInfoModel> {
        public FetchGroupNameInfoString() {
            super(FetchGroupNameInfoModel.class, false, "FetchGroupNameInfo", "3f847c0f44efe456eb9114ded11705b0", "group_address", "10153791443776729", RegularImmutableSet.a);
        }

        public final String m23019a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
