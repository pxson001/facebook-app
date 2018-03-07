package com.facebook.groups.widget.preferenceview;

import android.content.Context;
import android.widget.TextView;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: presentationDisplayId */
public class GroupNotificationsSettingPreferenceView extends CustomLinearLayout {
    public TextView f6062a = ((TextView) a(2131562707));

    /* compiled from: presentationDisplayId */
    public /* synthetic */ class C05451 {
        public static final /* synthetic */ int[] f6061a = new int[GraphQLGroupSubscriptionLevel.values().length];

        static {
            try {
                f6061a[GraphQLGroupSubscriptionLevel.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6061a[GraphQLGroupSubscriptionLevel.FRIEND_POSTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6061a[GraphQLGroupSubscriptionLevel.ALL_POSTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6061a[GraphQLGroupSubscriptionLevel.HIGHLIGHTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public GroupNotificationsSettingPreferenceView(Context context) {
        super(context);
        setContentView(2130904682);
    }
}
