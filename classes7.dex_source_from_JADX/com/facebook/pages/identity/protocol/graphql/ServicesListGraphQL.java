package com.facebook.pages.identity.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServicesDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: me/notificationssettings */
public final class ServicesListGraphQL {

    /* compiled from: me/notificationssettings */
    public class ServicesListGraphQLString extends TypedGraphQlQueryString<PageServicesDataModel> {
        public ServicesListGraphQLString() {
            super(PageServicesDataModel.class, false, "ServicesListGraphQL", "3146be24ae7014864e86f3b65436d1fb", "node", "10154479060826729", RegularImmutableSet.a);
        }

        public final String m11101a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case -783752827:
                    return "2";
                case -11314776:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
