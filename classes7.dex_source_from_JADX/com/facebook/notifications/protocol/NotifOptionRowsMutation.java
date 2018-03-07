package com.facebook.notifications.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.notifications.protocol.NotifOptionRowsMutationModels.NotifOptionActionMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: native_post/{%s}?fallback_url={%s} */
public final class NotifOptionRowsMutation {

    /* compiled from: native_post/{%s}?fallback_url={%s} */
    public class NotifOptionActionMutationString extends TypedGraphQLMutationString<NotifOptionActionMutationModel> {
        public NotifOptionActionMutationString() {
            super(NotifOptionActionMutationModel.class, false, "NotifOptionActionMutation", "0809a3e5137fdda83ca89bf9cb06e134", "notif_option_action", "0", "10154204804136729", RegularImmutableSet.a);
        }

        public final String m10378a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final NotifOptionActionMutationString m10379a() {
        return new NotifOptionActionMutationString();
    }
}
