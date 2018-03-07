package com.facebook.messaging.groups.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.groups.graphql.GroupThreadQueueEnabledQueryModels.GroupThreadQueueEnabledQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: show_dashboard_nux */
public final class GroupThreadQueueEnabledQuery {

    /* compiled from: show_dashboard_nux */
    public class GroupThreadQueueEnabledQueryString extends TypedGraphQlQueryString<GroupThreadQueueEnabledQueryModel> {
        public GroupThreadQueueEnabledQueryString() {
            super(GroupThreadQueueEnabledQueryModel.class, false, "GroupThreadQueueEnabledQuery", "a35d3f7a46e8a352212257460eac1b20", "message_thread", "10154618605791729", RegularImmutableSet.a);
        }

        public final String m2428a(String str) {
            switch (str.hashCode()) {
                case 3355:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
