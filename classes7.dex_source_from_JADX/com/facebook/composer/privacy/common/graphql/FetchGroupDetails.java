package com.facebook.composer.privacy.common.graphql;

import com.facebook.composer.privacy.common.graphql.FetchGroupDetailsModels.GroupDetailsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tapped_page_wikipedia_page */
public final class FetchGroupDetails {

    /* compiled from: tapped_page_wikipedia_page */
    public class GroupDetailsQueryString extends TypedGraphQlQueryString<GroupDetailsQueryModel> {
        public GroupDetailsQueryString() {
            super(GroupDetailsQueryModel.class, false, "GroupDetailsQuery", "f78ec2d3ab73c0a0b77e945f65f54261", "group_address", "10154339187506729", RegularImmutableSet.a);
        }

        public final String m2006a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
