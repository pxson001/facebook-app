package com.facebook.redspace.model;

import com.facebook.graphql.enums.GraphQLRedSpaceActivityType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: USER_CREATION_FINISHED */
public class RedSpaceSharedActivities {
    public ImmutableList<SharedActivity> f21348a = RegularImmutableList.a;
    public final PresenceActivitySharing f21349b = new PresenceActivitySharing();

    /* compiled from: USER_CREATION_FINISHED */
    public interface SharedActivity {
        boolean mo1161e();
    }

    /* compiled from: USER_CREATION_FINISHED */
    public /* synthetic */ class C22761 {
        public static final /* synthetic */ int[] f21347a = new int[GraphQLRedSpaceActivityType.values().length];

        static {
            try {
                f21347a[GraphQLRedSpaceActivityType.PRESENCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21347a[GraphQLRedSpaceActivityType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21347a[GraphQLRedSpaceActivityType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
