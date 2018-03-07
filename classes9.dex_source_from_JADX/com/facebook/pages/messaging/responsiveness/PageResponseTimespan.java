package com.facebook.pages.messaging.responsiveness;

import com.facebook.graphql.enums.GraphQLTimespanCategory;

/* compiled from: ccu_create_session_check_sync_event */
public enum PageResponseTimespan {
    NONE,
    MINUTES,
    ONE_HOUR,
    FEW_HOURS,
    ONE_DAY;

    /* compiled from: ccu_create_session_check_sync_event */
    /* synthetic */ class C21301 {
        static final /* synthetic */ int[] f18433a = null;

        static {
            f18433a = new int[GraphQLTimespanCategory.values().length];
            try {
                f18433a[GraphQLTimespanCategory.WITHIN_MINUTES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18433a[GraphQLTimespanCategory.WITHIN_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18433a[GraphQLTimespanCategory.WITHIN_FEW_HOURS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18433a[GraphQLTimespanCategory.WITHIN_A_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static PageResponseTimespan fromGraphQL(GraphQLTimespanCategory graphQLTimespanCategory) {
        switch (C21301.f18433a[graphQLTimespanCategory.ordinal()]) {
            case 1:
                return MINUTES;
            case 2:
                return ONE_HOUR;
            case 3:
                return FEW_HOURS;
            case 4:
                return ONE_DAY;
            default:
                return NONE;
        }
    }
}
