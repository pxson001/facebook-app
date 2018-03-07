package com.facebook.feedplugins.hpp.ui;

import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;

/* compiled from: current_battery_level */
/* synthetic */ class MobilePageAdminPanelPagePartDefinition$4 {
    static final /* synthetic */ int[] f7821a = new int[GraphQLEntityCardContextItemType.values().length];
    static final /* synthetic */ int[] f7822b = new int[GraphQLAYMTNativeAction.values().length];

    static {
        try {
            f7822b[GraphQLAYMTNativeAction.CREATE_PAGE_POST.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7822b[GraphQLAYMTNativeAction.MANAGE_ALL_PAGES.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7822b[GraphQLAYMTNativeAction.ADD_PAGE_COVER_PHOTO.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7822b[GraphQLAYMTNativeAction.ADD_PAGE_PROFILE_PIC.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f7821a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_NEW_LIKES.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f7821a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_POST_REACH.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f7821a[GraphQLEntityCardContextItemType.VISIT_YOUR_PAGE.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
