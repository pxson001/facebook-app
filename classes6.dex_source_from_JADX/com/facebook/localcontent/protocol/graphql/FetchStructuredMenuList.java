package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuListModels.StructuredMenuListDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: lastReadTimestampMs */
public final class FetchStructuredMenuList {

    /* compiled from: lastReadTimestampMs */
    public class StructuredMenuListDataString extends TypedGraphQlQueryString<StructuredMenuListDataModel> {
        public StructuredMenuListDataString() {
            super(StructuredMenuListDataModel.class, false, "StructuredMenuListData", "da6c94ea0658ab58aa557a1167a3a43e", "node", "10154343225201729", RegularImmutableSet.a);
        }

        public final String m18509a(String str) {
            switch (str.hashCode()) {
                case -773594002:
                    return "1";
                case -400241712:
                    return "2";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
