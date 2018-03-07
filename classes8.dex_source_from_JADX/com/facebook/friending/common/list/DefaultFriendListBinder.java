package com.facebook.friending.common.list;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.common.list.FriendListItemView.ActionButtonTheme;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: fontResourceCache.json */
public class DefaultFriendListBinder {
    public final Resources f13113a;
    public final String f13114b;
    public final FriendingButtonController f13115c;
    private final AllCapsTransformationMethod f13116d;

    /* compiled from: fontResourceCache.json */
    /* synthetic */ class C13622 {
        static final /* synthetic */ int[] f13112a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f13112a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13112a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13112a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13112a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13112a[GraphQLFriendshipStatus.CANNOT_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13112a[GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public DefaultFriendListBinder(@Assisted Resources resources, String str, FriendingButtonController friendingButtonController, AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f13113a = resources;
        this.f13114b = str;
        this.f13115c = friendingButtonController;
        this.f13116d = allCapsTransformationMethod;
    }

    public final void m14776a(FriendListItemView friendListItemView, FriendListItemModel friendListItemModel) {
        friendListItemView.setEnableActionButton(true);
        friendListItemView.setThumbnailUri(friendListItemModel.d());
        friendListItemView.setTitleText(friendListItemModel.b());
        m14775a(friendListItemView, friendListItemModel, friendListItemModel.f(), friendListItemModel.c());
        friendListItemView.setContentDescription(friendListItemModel.b() + " " + friendListItemView.getSubtitleText());
    }

    private void m14775a(FriendListItemView friendListItemView, FriendListItemModel friendListItemModel, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLFriendshipStatus graphQLFriendshipStatus2) {
        m14774a(friendListItemView, friendListItemModel, graphQLFriendshipStatus);
        friendListItemView.setSubtitleText("");
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            friendListItemView.setSubtitleText(2131233219);
        } else if (graphQLFriendshipStatus != GraphQLFriendshipStatus.ARE_FRIENDS || graphQLFriendshipStatus == graphQLFriendshipStatus2) {
            Object obj;
            if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && graphQLFriendshipStatus2 == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                friendListItemView.setSubtitleText(2131233220);
                return;
            }
            if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST && graphQLFriendshipStatus2 == GraphQLFriendshipStatus.ARE_FRIENDS) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                friendListItemView.setSubtitleText(2131233234);
                return;
            }
            CharSequence h = friendListItemModel.h();
            if (StringUtil.a(h)) {
                String str;
                if (this.f13114b.equals(String.valueOf(friendListItemModel.a()))) {
                    str = "";
                } else {
                    int e = friendListItemModel.e();
                    if (e > 0) {
                        str = this.f13113a.getQuantityString(2131689520, e, new Object[]{Integer.valueOf(e)});
                    } else {
                        str = "";
                    }
                }
                friendListItemView.setSubtitleText(str);
                return;
            }
            friendListItemView.setSubtitleText(h);
        } else {
            friendListItemView.setSubtitleText(2131233222);
        }
    }

    private void m14774a(FriendListItemView friendListItemView, final FriendListItemModel friendListItemModel, final GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C13622.f13112a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                friendListItemView.m14778a(ActionButtonTheme.PRIMARY, this.f13113a.getDrawable(2130840448));
                friendListItemView.m14779a(m14773a(2131233212, (View) friendListItemView), m14773a(2131233213, (View) friendListItemView));
                friendListItemView.setActionButtonContentDescription(this.f13113a.getString(2131233228));
                break;
            case 2:
                friendListItemView.m14778a(ActionButtonTheme.SECONDARY, this.f13113a.getDrawable(2130840450));
                friendListItemView.m14779a(m14773a(2131230727, (View) friendListItemView), null);
                friendListItemView.setActionButtonContentDescription(this.f13113a.getString(2131233230));
                break;
            case 3:
                friendListItemView.m14778a(ActionButtonTheme.PRIMARY, this.f13113a.getDrawable(2130840448));
                friendListItemView.m14779a(m14773a(2131233212, (View) friendListItemView), m14773a(2131233213, (View) friendListItemView));
                friendListItemView.setActionButtonContentDescription(this.f13113a.getString(2131233231));
                break;
            case 4:
                friendListItemView.m14778a(ActionButtonTheme.SECONDARY, this.f13113a.getDrawable(2130840454));
                friendListItemView.m14779a(m14773a(2131233209, (View) friendListItemView), null);
                friendListItemView.setActionButtonContentDescription(this.f13113a.getString(2131233229));
                break;
            case 5:
            case 6:
                friendListItemView.setShowActionButton(false);
                return;
        }
        friendListItemView.setShowActionButton(true);
        friendListItemView.setActionButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DefaultFriendListBinder f13111c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1951635438);
                view.setEnabled(false);
                this.f13111c.f13115c.a(friendListItemModel.a(), friendListItemModel.b(), friendListItemModel.g(), graphQLFriendshipStatus);
                Logger.a(2, EntryType.UI_INPUT_END, -1422608094, a);
            }
        });
    }

    private CharSequence m14773a(int i, View view) {
        return this.f13116d.getTransformation(this.f13113a.getString(i), view);
    }
}
