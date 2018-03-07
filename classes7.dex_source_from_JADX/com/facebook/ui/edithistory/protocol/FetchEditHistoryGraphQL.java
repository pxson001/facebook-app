package com.facebook.ui.edithistory.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.ui.edithistory.protocol.FetchEditHistoryGraphQLModels.FetchEditHistoryQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: encryptedUId */
public final class FetchEditHistoryGraphQL {

    /* compiled from: encryptedUId */
    public class FetchEditHistoryQueryString extends TypedGraphQlQueryString<FetchEditHistoryQueryModel> {
        public FetchEditHistoryQueryString() {
            super(FetchEditHistoryQueryModel.class, false, "FetchEditHistoryQuery", "96685554434978db38f6ba53a53b4c13", "node", "10154630857451729", RegularImmutableSet.a);
        }

        public final String m19286a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 25209764:
                    return "4";
                case 689802720:
                    return "2";
                case 1598177384:
                    return "3";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
