package com.facebook.groups.editsettings.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.editsettings.protocol.FetchGroupDescriptionModels.GroupNameDescriptionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unable to safeCancelWithRetry */
public final class FetchGroupDescription {

    /* compiled from: Unable to safeCancelWithRetry */
    public class GroupNameDescriptionQueryString extends TypedGraphQlQueryString<GroupNameDescriptionQueryModel> {
        public GroupNameDescriptionQueryString() {
            super(GroupNameDescriptionQueryModel.class, false, "GroupNameDescriptionQuery", "2e45e17aef025a24952498fc8b579682", "group_address", "10153910142071729", RegularImmutableSet.a);
        }

        public final String m22630a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
