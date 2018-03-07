package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.FetchAccountsQueryModels.FetchAccountsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Weak */
public final class FetchAccountsQuery {

    /* compiled from: Weak */
    public class FetchAccountsQueryString extends TypedGraphQlQueryString<FetchAccountsQueryModel> {
        public FetchAccountsQueryString() {
            super(FetchAccountsQueryModel.class, false, "FetchAccountsQuery", "ea5fa72ebabab9fcd4315fb60f24e42b", "page", "10154643784036729", RegularImmutableSet.a);
        }

        public final String m24080a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case -554685518:
                    return "1";
                case -247173063:
                    return "2";
                case 182666285:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
