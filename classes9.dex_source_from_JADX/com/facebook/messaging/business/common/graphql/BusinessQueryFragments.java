package com.facebook.messaging.business.common.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessFAQContentsQueryModel;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessGreetingContentsQueryModel;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessNuxContentsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: new AudioTrack illegal argument */
public final class BusinessQueryFragments {

    /* compiled from: new AudioTrack illegal argument */
    public class BusinessFAQContentsQueryString extends TypedGraphQlQueryString<BusinessFAQContentsQueryModel> {
        public BusinessFAQContentsQueryString() {
            super(BusinessFAQContentsQueryModel.class, false, "BusinessFAQContentsQuery", "f0b773fe05b88f8aa9e08cff99020ce6", "node", "10154341706491729", RegularImmutableSet.a);
        }

        public final String m8937a(String str) {
            switch (str.hashCode()) {
                case 1225234938:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: new AudioTrack illegal argument */
    public class BusinessGreetingContentsQueryString extends TypedGraphQlQueryString<BusinessGreetingContentsQueryModel> {
        public BusinessGreetingContentsQueryString() {
            super(BusinessGreetingContentsQueryModel.class, false, "BusinessGreetingContentsQuery", "f685bb18ace8ac953dd20c7369a2e6d1", "node", "10154478456016729", RegularImmutableSet.a);
        }

        public final String m8938a(String str) {
            switch (str.hashCode()) {
                case 272076239:
                    return "1";
                case 1225234938:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: new AudioTrack illegal argument */
    public class BusinessNuxContentsQueryString extends TypedGraphQlQueryString<BusinessNuxContentsQueryModel> {
        public BusinessNuxContentsQueryString() {
            super(BusinessNuxContentsQueryModel.class, false, "BusinessNuxContentsQuery", "6a1291ca61037828d20f508b9875139a", "node", "10154341706501729", RegularImmutableSet.a);
        }

        public final String m8939a(String str) {
            switch (str.hashCode()) {
                case 1225234938:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
