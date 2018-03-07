package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.protocol.FetchGroupBlockedListModels.FetchGroupBlockedListModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_include_viewer */
public final class FetchGroupBlockedList {

    /* compiled from: extra_include_viewer */
    public class FetchGroupBlockedListString extends TypedGraphQlQueryString<FetchGroupBlockedListModel> {
        public FetchGroupBlockedListString() {
            super(FetchGroupBlockedListModel.class, false, "FetchGroupBlockedList", "9113987804c4791363363ef2db1378b4", "group_address", "10154358997911729", RegularImmutableSet.a);
        }

        public final String m16135a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "4";
                case -539238237:
                    return "1";
                case -77796550:
                    return "2";
                case -59350230:
                    return "3";
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
