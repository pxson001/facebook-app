package com.facebook.cookiesync;

import com.facebook.cookiesync.CookieSyncUserDataEncryptionGraphQLModels.FetchEncrytedCookieSyncUserDataModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: platform app */
public final class CookieSyncUserDataEncryptionGraphQL {

    /* compiled from: platform app */
    public class FetchEncrytedCookieSyncUserDataString extends TypedGraphQlQueryString<FetchEncrytedCookieSyncUserDataModel> {
        public FetchEncrytedCookieSyncUserDataString() {
            super(FetchEncrytedCookieSyncUserDataModel.class, false, "FetchEncrytedCookieSyncUserData", "ee7876af4ac18f40d38f7b803eeea336", "me", "10154341705276729", RegularImmutableSet.a);
        }

        public final String m6875a(String str) {
            switch (str.hashCode()) {
                case -309310695:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
