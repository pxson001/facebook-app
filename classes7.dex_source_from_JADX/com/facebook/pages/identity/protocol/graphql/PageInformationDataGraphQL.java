package com.facebook.pages.identity.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mediaQueryProviderClass */
public final class PageInformationDataGraphQL {

    /* compiled from: mediaQueryProviderClass */
    public class FetchPageInformationDataQueryString extends TypedGraphQlQueryString<PageInformationDataModel> {
        public FetchPageInformationDataQueryString() {
            super(PageInformationDataModel.class, false, "FetchPageInformationDataQuery", "09fc5988b3be2d19c41a93553594cf88", "node", "10154686281611729", RegularImmutableSet.a);
        }

        public final String m10960a(String str) {
            switch (str.hashCode()) {
                case -1870866650:
                    return "2";
                case -803548981:
                    return "0";
                case 496276124:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
