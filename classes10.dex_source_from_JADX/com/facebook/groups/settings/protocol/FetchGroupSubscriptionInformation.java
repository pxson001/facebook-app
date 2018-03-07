package com.facebook.groups.settings.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: THREAD_SUMMARY */
public final class FetchGroupSubscriptionInformation {

    /* compiled from: THREAD_SUMMARY */
    public class FetchGroupSubscriptionInformationString extends TypedGraphQlQueryString<GroupSubscriptionDataModel> {
        public FetchGroupSubscriptionInformationString() {
            super(GroupSubscriptionDataModel.class, false, "FetchGroupSubscriptionInformation", "a6e00e8fca8a5735d7a0c4443dde4c93", "group_address", "10154500825801729", RegularImmutableSet.a);
        }

        public final String m24458a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
