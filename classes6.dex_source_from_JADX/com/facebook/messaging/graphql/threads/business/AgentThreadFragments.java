package com.facebook.messaging.graphql.threads.business;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsModels.BusinessIsPageLinkedQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video-bitrate */
public final class AgentThreadFragments {

    /* compiled from: video-bitrate */
    public class BusinessIsPageLinkedQueryString extends TypedGraphQlQueryString<BusinessIsPageLinkedQueryModel> {
        public BusinessIsPageLinkedQueryString() {
            super(BusinessIsPageLinkedQueryModel.class, false, "BusinessIsPageLinkedQuery", "5ab8bb0caf7768d55945b3d552bd6162", "me", "10154341706506729", RegularImmutableSet.a);
        }

        public final String m2976a(String str) {
            switch (str.hashCode()) {
                case 1987278668:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
