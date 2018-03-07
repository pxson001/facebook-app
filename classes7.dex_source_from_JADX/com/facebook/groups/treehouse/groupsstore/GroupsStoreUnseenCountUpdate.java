package com.facebook.groups.treehouse.groupsstore;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonDeserializer
/* compiled from: profile_picture_vpv */
class GroupsStoreUnseenCountUpdate {
    @JsonProperty("group_id")
    public final String groupId = "";
    @JsonProperty("unseen")
    public final int unseenCount = 0;

    GroupsStoreUnseenCountUpdate() {
    }
}
