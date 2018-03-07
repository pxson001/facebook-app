package com.facebook.goodfriends.protocol;

import com.facebook.goodfriends.protocol.GoodFriendsMutatorsModels.FriendListUpdateMembersFieldsModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mRotationAngle */
public final class GoodFriendsMutators {

    /* compiled from: mRotationAngle */
    public class FriendListUpdateMembersString extends TypedGraphQLMutationString<FriendListUpdateMembersFieldsModel> {
        public FriendListUpdateMembersString() {
            super(FriendListUpdateMembersFieldsModel.class, false, "FriendListUpdateMembers", "9161ad6210fd8d00cf33d313d8eb4de9", "friend_list_update_members", "0", "10154617578096729", RegularImmutableSet.a);
        }

        public final String m17571a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
