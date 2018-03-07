package com.facebook.ufiservices.ui;

import android.content.res.Resources;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: crop_rect_top */
public class SmartFriendingButtonBinder implements ProfileListFriendingButtonBinder<SmartButtonLite> {

    /* compiled from: crop_rect_top */
    /* synthetic */ class C13451 {
        static final /* synthetic */ int[] f18282a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f18282a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18282a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18282a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18282a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void m26823a(SmartButtonLite smartButtonLite, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        Resources resources = smartButtonLite.getResources();
        switch (C13451.f18282a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                smartButtonLite.setStyle(2130772395);
                smartButtonLite.m17434a(resources.getString(2131233212), resources.getString(2131233213));
                smartButtonLite.setContentDescription(resources.getString(2131233228));
                break;
            case 2:
                smartButtonLite.setStyle(2130772395);
                smartButtonLite.m17434a(resources.getString(2131233212), resources.getString(2131233213));
                smartButtonLite.setContentDescription(resources.getString(2131233231));
                break;
            case 3:
                smartButtonLite.setStyle(2130772383);
                smartButtonLite.m17434a(resources.getString(2131230727), null);
                smartButtonLite.setContentDescription(resources.getString(2131233230));
                break;
            case 4:
                smartButtonLite.setStyle(2130772383);
                smartButtonLite.m17434a(resources.getString(2131233209), null);
                smartButtonLite.setContentDescription(resources.getString(2131233229));
                break;
            default:
                smartButtonLite.setVisibility(8);
                return;
        }
        smartButtonLite.setVisibility(0);
        smartButtonLite.setFocusable(false);
    }
}
