package com.facebook.friendlist.listadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.data.FriendPageListItemModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: accuracy_meters */
public class ProfileFriendListBinder {
    public final Resources f20401a;
    public final String f20402b;
    public final ActionButtonsController f20403c;
    private final AllCapsTransformationMethod f20404d;

    /* compiled from: accuracy_meters */
    /* synthetic */ class C29203 {
        static final /* synthetic */ int[] f20400a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f20400a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20400a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20400a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20400a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public ProfileFriendListBinder(String str, @Assisted Context context, @Assisted FriendListType friendListType, @Assisted FriendListSource friendListSource, ActionButtonsControllerProvider actionButtonsControllerProvider, AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f20402b = str;
        this.f20401a = context.getResources();
        this.f20403c = actionButtonsControllerProvider.m20644a(context, friendListType, friendListSource);
        this.f20404d = allCapsTransformationMethod;
    }

    public final void m20669a(ProfileFriendListItemView profileFriendListItemView, FriendPageListItemModel friendPageListItemModel) {
        profileFriendListItemView.setThumbnailUri(friendPageListItemModel.d());
        profileFriendListItemView.setTitleText(friendPageListItemModel.b());
        m20667b(profileFriendListItemView, friendPageListItemModel);
        GraphQLFriendshipStatus f = friendPageListItemModel.f();
        GraphQLFriendshipStatus c = friendPageListItemModel.c();
        profileFriendListItemView.setSubtitleText("");
        if (f == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            profileFriendListItemView.setSubtitleText(2131233219);
        } else if (f != GraphQLFriendshipStatus.ARE_FRIENDS || f == c) {
            Object obj;
            if (f == GraphQLFriendshipStatus.CAN_REQUEST && c == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                profileFriendListItemView.setSubtitleText(2131233220);
            } else {
                if (f == GraphQLFriendshipStatus.CAN_REQUEST && c == GraphQLFriendshipStatus.ARE_FRIENDS) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    profileFriendListItemView.setSubtitleText(2131233234);
                } else {
                    CharSequence h = friendPageListItemModel.h();
                    if (StringUtil.a(h)) {
                        String str;
                        if (this.f20402b.equals(String.valueOf(friendPageListItemModel.a()))) {
                            str = "";
                        } else {
                            int e = friendPageListItemModel.e();
                            if (e > 0) {
                                str = this.f20401a.getQuantityString(2131689520, e, new Object[]{Integer.valueOf(e)});
                            } else {
                                str = "";
                            }
                        }
                        profileFriendListItemView.setSubtitleText(str);
                    } else {
                        profileFriendListItemView.setSubtitleText(h);
                    }
                }
            }
        } else {
            profileFriendListItemView.setSubtitleText(2131233222);
        }
        m20668d(profileFriendListItemView, friendPageListItemModel);
        profileFriendListItemView.setContentDescription(friendPageListItemModel.b() + " " + profileFriendListItemView.getSubtitleText());
    }

    private void m20667b(final ProfileFriendListItemView profileFriendListItemView, final FriendPageListItemModel friendPageListItemModel) {
        switch (C29203.f20400a[friendPageListItemModel.f().ordinal()]) {
            case 1:
                profileFriendListItemView.setActionButtonStyle(2130772389);
                profileFriendListItemView.m20670a(m20666a(2131233212), m20666a(2131233213));
                profileFriendListItemView.setActionButtonContentDescription(this.f20401a.getString(2131233228));
                break;
            case 2:
                profileFriendListItemView.setActionButtonStyle(2130772389);
                profileFriendListItemView.m20670a(m20666a(2131233212), m20666a(2131233213));
                profileFriendListItemView.setActionButtonContentDescription(this.f20401a.getString(2131233231));
                break;
            case 3:
                profileFriendListItemView.setActionButtonStyle(2130772383);
                profileFriendListItemView.setActionButtonText(m20666a(2131230727));
                profileFriendListItemView.setActionButtonContentDescription(this.f20401a.getString(2131233230));
                break;
            case 4:
                profileFriendListItemView.setActionButtonStyle(2130772383);
                profileFriendListItemView.setActionButtonText(m20666a(2131233209));
                profileFriendListItemView.setActionButtonContentDescription(this.f20401a.getString(2131233229));
                break;
            default:
                profileFriendListItemView.setShowButtonContainer(false);
                return;
        }
        profileFriendListItemView.setShowButtonContainer(true);
        profileFriendListItemView.f20406i.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProfileFriendListBinder f20396c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1258469000);
                this.f20396c.f20403c.m20642a(Long.parseLong(this.f20396c.f20402b), friendPageListItemModel.a(), friendPageListItemModel.b(), friendPageListItemModel.g(), friendPageListItemModel.f(), (View) profileFriendListItemView.f20406i);
                Logger.a(2, EntryType.UI_INPUT_END, 247447304, a);
            }
        });
        profileFriendListItemView.f20407j.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProfileFriendListBinder f20399c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 238349035);
                this.f20399c.f20403c.m20643a(Long.parseLong(this.f20399c.f20402b), friendPageListItemModel.a(), friendPageListItemModel.b(), friendPageListItemModel.f(), friendPageListItemModel.f20306h, profileFriendListItemView.f20407j);
                Logger.a(2, EntryType.UI_INPUT_END, -1326947250, a);
            }
        });
    }

    private static void m20668d(ProfileFriendListItemView profileFriendListItemView, FriendPageListItemModel friendPageListItemModel) {
        if (friendPageListItemModel.f20307i == 0) {
            profileFriendListItemView.setMetaText("");
            return;
        }
        profileFriendListItemView.setMetaText(profileFriendListItemView.getContext().getResources().getQuantityString(2131689628, friendPageListItemModel.f20307i, new Object[]{Integer.valueOf(friendPageListItemModel.f20307i)}).toLowerCase());
    }

    private CharSequence m20666a(@StringRes int i) {
        return this.f20404d.getTransformation(this.f20401a.getString(i), null);
    }
}
